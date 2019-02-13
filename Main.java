import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

// By Harsh Verma
// HXV180001

public class Main {

    BufferedReader reader;
    Map<String, Integer> bigramMap;
    Map<String, Integer> unigramMap;
    Map<Integer, Integer> numFreqMap;
    String allLines = "";
    String token1, token2;
    int totalWords;

    enum operation {
        NO_SMOOTHING, ADD_ONE_SMOOTHING
    };


    public static void main(String[] args)
    {
       Main obj = new Main();
       obj.Execute(args[0],args[1],args[2]);
    }

    void Execute(String fileName, String sent1, String sent2) {
        IsFilePresent(fileName);
        ReadFile();
        numFreq();
        calcSentence(sent1, sent2);
    }

    // Check file is present
    void IsFilePresent(String filename) {
        try {
            reader = new BufferedReader(new FileReader(
                    filename));
        } catch (Exception e) {
            System.out.println("File not found in the directory");
        }
    }


    void ReadFile() {
        try {
            bigramMap = new HashMap<String, Integer>();
            unigramMap = new HashMap<String, Integer>();
            // join all lines
            String singleLine = reader.readLine();

            while (singleLine != null) {
                allLines = allLines + " " + singleLine;
                singleLine = reader.readLine();
            }
            // Considering only words
            allLines = allLines.replaceAll("[^a-zA-Z0-9. ]", "");
            allLines = allLines.replaceAll("\\s+", " ").toLowerCase();

            StringTokenizer tokenizer = new StringTokenizer(allLines);
          //  System.out.println("Total Tokenizers : " + tokenizer.countTokens());

            // loop through the words.
            if (tokenizer.hasMoreTokens()) {
                token1 = tokenizer.nextToken();
            }

            while (tokenizer.hasMoreTokens()) {
                String token2 = tokenizer.nextToken();
                String word = token1 + " " + token2;

                if (bigramMap.containsKey(word)) {
                    bigramMap.put(word, bigramMap.get(word) + 1);
                } else {
                    bigramMap.put(word, 1);
                }
                totalWords++;
                if (unigramMap.containsKey(token1)) {
                    unigramMap.put(token1, unigramMap.get(token1) + 1);
                } else {
                    unigramMap.put(token1, 1);
                }
                // The second token becomes the first token for the next bigram
                token1 = token2;
            }

            int totalUniqueWords = bigramMap.size();
            int totalUniqueTokens = unigramMap.size();
           // System.out.println("Total Bigram: " + totalUniqueWords + " : Total Unigram: " + totalUniqueTokens);

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Error parsing file");
        }
    }

    double doSmoothing(String sentence, int smoothingType) {
        String tempToken1 = "", tempToken2 = "";
        int unigramCount, bigramCount;

        double sentenceProb = 1, conditionalProb;
        StringTokenizer tempTokenize = new StringTokenizer(sentence);

        if (tempTokenize.hasMoreTokens()) {
            tempToken1 = tempTokenize.nextToken();
        }

        while (tempTokenize.hasMoreTokens()) {
            tempToken2 = tempTokenize.nextToken();
            String bigramToken = tempToken1 + " " + tempToken2;

            boolean isBigramPresent = bigramMap.containsKey(bigramToken);
            boolean isUnigramPresent = unigramMap.containsKey(tempToken1);

            bigramCount = (isBigramPresent) ? bigramMap.get(bigramToken) : 0;
            unigramCount = (isUnigramPresent) ? unigramMap.get(tempToken1) : 0;
            // For no smoothing, just divide bigram count by unigram count
            if (smoothingType == 0) {
                if (isBigramPresent) {
                    conditionalProb = (double) (bigramCount) / (double) (unigramCount);
                    sentenceProb *= conditionalProb;
                }
            }

            // For add one smoothing - Add one to bigram count and divide by unigram count added by total number of unigrams
            else if (smoothingType == 1) {
                conditionalProb = (double) (bigramCount + 1) / (double) (unigramCount + unigramMap.size());
                sentenceProb *= conditionalProb;
            }
            tempToken1 = tempToken2;
        }

        return sentenceProb;
    }

    void compareSentence(String sentence1, String sentence2, Main.operation operation) {
        System.out.println(operation);
        double comp1 = doSmoothing(sentence1, operation.ordinal());
        System.out.println("Sentance 1 Total Probability >> " + comp1);
        double comp2 = doSmoothing(sentence2, operation.ordinal());
        System.out.println("Sentance 2 Total Probability >> " + comp2);
        String output = comp1 > comp2 ? "Sentence 1 is preferred" : "Sentence 2 is preferred";
        System.out.println("Conclusion : " + output);
        System.out.println(" ");
    }

    void calcSentence(String sentence1, String sentence2) {
         sentence1 = sentence1.toLowerCase();
         sentence2 = sentence2.toLowerCase();

        compareSentence(sentence1, sentence2, operation.NO_SMOOTHING);
        compareSentence(sentence1, sentence2, operation.ADD_ONE_SMOOTHING);

        System.out.println("\n Frequency Table for Sentence 1, No Smoothning\n");
        displayFreqNoSmoothing(sentence1);
        System.out.println("\n Frequency Table for Sentence 2, No Smoothning\n");
        displayFreqNoSmoothing(sentence2);

        System.out.println("\n Frequency Table for Sentence 1, with AddOne Smoothning\n");
        displayFreqAddOneSmoothing(sentence1);
        System.out.println("\n Frequency Table for Sentence 2, with AddOne Smoothning\n");
        displayFreqAddOneSmoothing(sentence2);

        System.out.println("\n Probability Table for Sentence 1, with No Smoothning\n");
        displayProb(sentence1);
        System.out.println("\n Probability Table for Sentence 2, with No Smoothning\n");
        displayProb(sentence2);

        System.out.println("\n Probability Table for Sentence 1, with AddOne Smoothning\n");
        displayProbOneAdd(sentence1);
        System.out.println("\n Probability Table for Sentence 2, with AddOne Smoothning\n");
        displayProbOneAdd(sentence2);

    }

    public void displayFreqNoSmoothing(String sentence) {
        DecimalFormat dF = new DecimalFormat("#.###");
        String[] tokenz = sentence.split(" ");
        System.out.print(buildSpaceTab(" "));
        for (int cntr = 0; cntr < tokenz.length; cntr++) {
            System.out.print("\t" + tokenz[cntr]);
        }
        System.out.println("\n");
        for (int cntr = 0; cntr < tokenz.length; cntr++) {
            System.out.print(buildSpaceTab(tokenz[cntr]));
            for (int cntr1 = 0; cntr1 < tokenz.length; cntr1++) {
                String bigram = tokenz[cntr] + " " + tokenz[cntr1];
                if (bigramMap.containsKey(bigram)) {
                    System.out.print("\t" + dF.format(bigramMap.get(bigram)));
                } else {
                    System.out.print("\t0");
                }
            }
            System.out.println("\n");
        }
        System.out.println("_________________________________________________________");
    }


    void displayProb(String sentence) {
        DecimalFormat dF = new DecimalFormat("#.###");
        String[] tempToken = sentence.split(" ");
        System.out.print(buildSpaceTab(" "));
        for (int cntr = 0; cntr < tempToken.length; cntr++) {
            System.out.print("\t" + tempToken[cntr]);
        }
        System.out.println("\n");
        for (int cntr = 0; cntr < tempToken.length; cntr++) {
            System.out.print(buildSpaceTab(tempToken[cntr]));
            for (int cntr1 = 0; cntr1 < tempToken.length; cntr1++) {
                String bigram = tempToken[cntr] + " " + tempToken[cntr1];
                if (bigramMap.containsKey(bigram)) {
                    System.out
                            .print("\t"
                                    + dF.format(((double) bigramMap.get(bigram) / (double) unigramMap
                                    .get(tempToken[cntr1]))));
                } else {
                    System.out.print("\t0");
                }
            }
            System.out.println("\n");
        }
        System.out.println("_________________________________________________________");
    }

    void displayProbOneAdd(String sentence) {
        DecimalFormat dF = new DecimalFormat("#.###");
        String[] tokens = sentence.split(" ");
        System.out.print(buildSpaceTab(" "));
        for (int cntr = 0; cntr < tokens.length; cntr++) {
            System.out.print("\t" + tokens[cntr]);
        }
        System.out.println("\n");
        for (int cntr = 0; cntr < tokens.length; cntr++) {
            System.out.print(buildSpaceTab(tokens[cntr]));
            for (int cntr1 = 0; cntr1 < tokens.length; cntr1++) {
                String bigram = tokens[cntr] + " " + tokens[cntr1];
                if (bigramMap.containsKey(bigram)) {
                    System.out
                            .print("\t"
                                    + dF.format(((double) (bigramMap
                                    .get(bigram) + 1) / ((double) unigramMap
                                    .get(tokens[cntr1]) + unigramMap
                                    .size()))));

                } else {
                    System.out.print("\t0");
                }
            }
            System.out.println("\n");
        }
        System.out.println("***********************");
    }

    public void displayFreqAddOneSmoothing(String sentence) {
        DecimalFormat dF = new DecimalFormat("#.###");
        String[] tokenz = sentence.split(" ");
        System.out.print(buildSpaceTab(" "));
        for (int cntr = 0; cntr < tokenz.length; cntr++) {
            System.out.print("\t" + tokenz[cntr]);
        }
        System.out.println("\n");
        for (int cntr = 0; cntr < tokenz.length; cntr++) {
            System.out.print(buildSpaceTab(tokenz[cntr]));
            for (int cntr1 = 0; cntr1 < tokenz.length; cntr1++) {
                String bigram = tokenz[cntr] + " " + tokenz[cntr1];
                if (bigramMap.containsKey(bigram)) {
                    System.out.print("\t" + dF.format(bigramMap.get(bigram) + 1));
                } else {
                    System.out.print("\t1");
                }
            }
            System.out.println("\n");
        }
        System.out.println("_________________________________________________________");
    }



    public static String buildSpaceTab(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = 1; i < 10 - s.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    void numFreq() {
        numFreqMap = new HashMap<Integer, Integer>();
        for (String key : bigramMap.keySet()) {
            int val = bigramMap.get(key);
            if (numFreqMap.containsKey(val)) {
                int count = numFreqMap.get(val);
                numFreqMap.put(val, count + 1);
            } else {
                numFreqMap.put(val, 1);
            }
        }
    }

}
