# -*- coding: utf-8 -*-
"""
Created on Sat Feb  11 12:43:56 2019

@author: harsh Verma
"""
import collections as col
import nltk
import sys
from nltk.util import ngrams
nltk.download('punkt')
from nltk import word_tokenize
from nltk.tokenize import RegexpTokenizer

tokenizer = RegexpTokenizer(r'\w+')


def getNgrams(text, groupsize):
    token = word_tokenize(text)
    bigrams = ngrams(token, groupsize)
    return bigrams


def outputFormat(bigramDictionary):
    for key, value in bigramDictionary.items():
        print(str(key) + "  --->  " + str(value))


def compute_biagram_counter(courpus_biagram, statement_biagram, with_smothing):
    bigramCountDict = {}
    for key in statement_biagram:
        countPerBigram = courpus_biagram[key]
        bigramCountDict[key] = countPerBigram + with_smothing
    return bigramCountDict


def compute_Probability_without_smothing(bigramCountDict, WordCountInCorpus):
    ProbabilityDict = {}
    for key in bigramCountDict:
        countPerBigram = bigramCountDict[key]
        total = WordCountInCorpus[key[0]]
        if total == 0:
            ProbabilityDict[key] = 0
        else:
            ProbabilityDict[key] = round(countPerBigram / total, 4)

    return ProbabilityDict


def Probability_with_smothing_compute(bigramCountDict, WordCountInCorpus):
    total_vocab_count = len(WordCountInCorpus)
    ProbabilityDict = {}
    for key in bigramCountDict:
        countPerBigram = bigramCountDict[key]
        total = WordCountInCorpus[key[0]]
        if total == 0:
            ProbabilityDict[key] = 1
        else:
            ProbabilityDict[key] = round((countPerBigram + 1) / (total + total_vocab_count), 4)
    return ProbabilityDict


def probability(bigramCountDict, WordCountInCorpus):
    probability = 1 / len(WordCountInCorpus)
    for key, value in bigramCountDict.items():
        probability = probability * value
    return probability

def checkOutputConclusion(p3,p4):
    if p3 > p4:
        print("Statement 1 is more probable than Statement 2")
    elif p3 < p4:
        print("Statement 2 is more probable than Statement 1")
    else:
        print("Both Statement 1 and Statement 2 has equal probable")

def computeAndCheck(corpus, statement1, statement2):
    textfile = open(corpus, 'r')
    filetext = textfile.read()
    courpus_biagram = col.Counter(getNgrams(filetext, 2))
    statement_biagram1 = col.Counter(getNgrams(statement1, 2))
    statement_biagram2 = col.Counter(getNgrams(statement2, 2))
    WordCountInCorpus = col.Counter(filetext.split())

    print("_______________________________________________")
    print("Table 1 : Statement 1 - Biagram count - Without smothing")
    print("_______________________________________________")
    bigramCountDict1 = compute_biagram_counter(courpus_biagram, statement_biagram1, 0)
    outputFormat(bigramCountDict1)
    print("_______________________________________________")
    print("Table 2 :Statement 2 - Biagram count - Without smothing")
    print("_______________________________________________")
    bigramCountDict2 = compute_biagram_counter(courpus_biagram, statement_biagram2, 0)
    outputFormat(bigramCountDict2)

    print("_______________________________________________")
    print("Table 3 :Statement 1 - Biagram Probability - Without smoothing")
    print("_______________________________________________")

    prob_stat_1 = compute_Probability_without_smothing(bigramCountDict1, WordCountInCorpus)
    outputFormat(prob_stat_1)

    print("_______________________________________________")
    print("Table 4 : Statement 2 - Biagram Probability - Without smoothing")
    print("_______________________________________________")

    prob_stat_2 = compute_Probability_without_smothing(bigramCountDict2, WordCountInCorpus)
    outputFormat(prob_stat_2)

    print("_______________________________________________")
    print("Probability 1 : Statement 1 - Total Probability - Without smoothing")
    print("_______________________________________________")

    p1 = probability(prob_stat_1, WordCountInCorpus)
    print(p1)

    print("_______________________________________________")
    print("Probability 2 : Statement 2 - Total Probability - Without smoothing")
    print("_______________________________________________")

    p2 = probability(prob_stat_2, WordCountInCorpus)
    print(p2)
    print("Final Conclusion")
    checkOutputConclusion(p1,p2)

    print("_______________________________________________")
    print("Table 5 : Statement 1 - Biagram count - With smoothing")
    print("_______________________________________________")
    bigramCountDict1 = compute_biagram_counter(courpus_biagram, statement_biagram1, 1)
    outputFormat(bigramCountDict1)
    print("_______________________________________________")
    print("Table 6 : Statement 2 - Biagram count - With smoothing")
    print("_______________________________________________")
    bigramCountDict2 = compute_biagram_counter(courpus_biagram, statement_biagram2, 1)
    outputFormat(bigramCountDict2)

    print("_______________________________________________")
    print("Table 7 : Statement 1 - Biagram Probability - With smoothing")
    print("_______________________________________________")

    f1 = Probability_with_smothing_compute(bigramCountDict1, WordCountInCorpus)
    outputFormat(f1)

    print("_______________________________________________")
    print("Table 8 : Statement 2 - Biagram Probability - With smoothing")
    print("_______________________________________________")

    f2 = Probability_with_smothing_compute(bigramCountDict2, WordCountInCorpus)
    outputFormat(f2)

    print("_______________________________________________")
    print("Probability 3 : Statement 1 - Total Probability - smoothing")
    print("_______________________________________________")

    p3 = probability(f1, WordCountInCorpus)
    print(p3)

    print("_______________________________________________")
    print("Probability 3 : Statement 2 - Total Probability - smoothing")
    print("_______________________________________________")

    p4 = probability(f2, WordCountInCorpus)
    print(p4)

    print("_______________________________________________")
    print("Final Conclusion")
    print("_______________________________________________")
    checkOutputConclusion(p3, p4)


if __name__ == "__main__":
    corpus = sys.argv[1]
    statement1 = sys.argv[2]
    statement2 = sys.argv[3]
    #statement1 = "The chairman made the decision to bring in a new financial planner ."
    #statement2 = "The profit of the company was going down last year said by the chief executive . "
    computeAndCheck(corpus, statement1.lower(), statement2.lower())
