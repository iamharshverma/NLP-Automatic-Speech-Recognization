# NLP-Automatic-Speech-Recognization

An automatic speech recognition system has provided two written sentences as possible interpretations to a speech input.

S1: The chairman made the decision to bring in a new financial planner .
S2: The profit of the company was going down last year said by the chief executive .

Using the bigram language model trained on Corpus, find out which of the two sentences is more probable. Compute the probability of each of the two sentences under the two following scenarios:

i. Use the bigram model without smoothing.

ii. Use the bigram model with add-one smoothing

Expected Problems:

Write a computer program to:
A. For each of the two scenarios, construct the tables with the bigram counts for the two sentences above.
B. For each of the two scenarios, construct the table with the bigram probabilities for the sentences.
C. For each of the two scenarios, compute the total probabilities for each sentence S1 and S2.


To Execute the python program make sure nltk is installed in system, you can do that using command pip install nltk

To Execute the python program run command :

python3 ngram.py Corpus.txt  "The chairman made the decision to bring in a new financial planner ." "The profit of the company was going down last year said by the chief executive . "

This will give the following output :

_______________________________________________
Table 1 : Statement 1 - Biagram count - Without smothing
_______________________________________________
('the', 'chairman')  --->  39
('chairman', 'made')  --->  0
('made', 'the')  --->  3
('the', 'decision')  --->  2
('decision', 'to')  --->  7
('to', 'bring')  --->  1
('bring', 'in')  --->  0
('in', 'a')  --->  23
('a', 'new')  --->  20
('new', 'financial')  --->  0
('financial', 'planner')  --->  1
('planner', '.')  --->  0
_______________________________________________
Table 2 :Statement 2 - Biagram count - Without smothing
_______________________________________________
('the', 'profit')  --->  0
('profit', 'of')  --->  0
('of', 'the')  --->  266
('the', 'company')  --->  84
('company', 'was')  --->  1
('was', 'going')  --->  0
('going', 'down')  --->  0
('down', 'last')  --->  0
('last', 'year')  --->  4
('year', 'said')  --->  0
('said', 'by')  --->  0
('by', 'the')  --->  43
('the', 'chief')  --->  0
('chief', 'executive')  --->  164
('executive', '.')  --->  10
_______________________________________________
Table 3 :Statement 1 - Biagram Probability - Without smoothing
_______________________________________________
('the', 'chairman')  --->  0.0273
('chairman', 'made')  --->  0.0
('made', 'the')  --->  0.1579
('the', 'decision')  --->  0.0014
('decision', 'to')  --->  0.4118
('to', 'bring')  --->  0.0015
('bring', 'in')  --->  0.0
('in', 'a')  --->  0.0641
('a', 'new')  --->  0.0344
('new', 'financial')  --->  0.0
('financial', 'planner')  --->  0.0435
('planner', '.')  --->  0.0
_______________________________________________
Table 4 : Statement 2 - Biagram Probability - Without smoothing
_______________________________________________
('the', 'profit')  --->  0.0
('profit', 'of')  --->  0.0
('of', 'the')  --->  0.2836
('the', 'company')  --->  0.0587
('company', 'was')  --->  0.0068
('was', 'going')  --->  0.0
('going', 'down')  --->  0.0
('down', 'last')  --->  0.0
('last', 'year')  --->  0.1212
('year', 'said')  --->  0.0
('said', 'by')  --->  0.0
('by', 'the')  --->  0.3185
('the', 'chief')  --->  0.0
('chief', 'executive')  --->  0.8632
('executive', '.')  --->  0.0529
_______________________________________________
Probability 1 : Statement 1 - Total Probability - Without smoothing
_______________________________________________
0.0
_______________________________________________
Probability 2 : Statement 2 - Total Probability - Without smoothing
_______________________________________________
0.0
Final Conclusion
Both Statement 1 and Statement 2 has equal probable
_______________________________________________
Table 5 : Statement 1 - Biagram count - With smoothing
_______________________________________________
('the', 'chairman')  --->  40
('chairman', 'made')  --->  1
('made', 'the')  --->  4
('the', 'decision')  --->  3
('decision', 'to')  --->  8
('to', 'bring')  --->  2
('bring', 'in')  --->  1
('in', 'a')  --->  24
('a', 'new')  --->  21
('new', 'financial')  --->  1
('financial', 'planner')  --->  2
('planner', '.')  --->  1
_______________________________________________
Table 6 : Statement 2 - Biagram count - With smoothing
_______________________________________________
('the', 'profit')  --->  1
('profit', 'of')  --->  1
('of', 'the')  --->  267
('the', 'company')  --->  85
('company', 'was')  --->  2
('was', 'going')  --->  1
('going', 'down')  --->  1
('down', 'last')  --->  1
('last', 'year')  --->  5
('year', 'said')  --->  1
('said', 'by')  --->  1
('by', 'the')  --->  44
('the', 'chief')  --->  1
('chief', 'executive')  --->  165
('executive', '.')  --->  11
_______________________________________________
Table 7 : Statement 1 - Biagram Probability - With smoothing
_______________________________________________
('the', 'chairman')  --->  0.0058
('chairman', 'made')  --->  0.0003
('made', 'the')  --->  0.0009
('the', 'decision')  --->  0.0006
('decision', 'to')  --->  0.0016
('to', 'bring')  --->  0.0005
('bring', 'in')  --->  0.0004
('in', 'a')  --->  0.0042
('a', 'new')  --->  0.0036
('new', 'financial')  --->  0.0004
('financial', 'planner')  --->  0.0005
('planner', '.')  --->  0.0004
_______________________________________________
Table 8 : Statement 2 - Biagram Probability - With smoothing
_______________________________________________
('the', 'profit')  --->  0.0003
('profit', 'of')  --->  0.0004
('of', 'the')  --->  0.041
('the', 'company')  --->  0.0122
('company', 'was')  --->  0.0005
('was', 'going')  --->  0.0003
('going', 'down')  --->  0.0004
('down', 'last')  --->  0.0004
('last', 'year')  --->  0.0011
('year', 'said')  --->  0.0004
('said', 'by')  --->  0.0003
('by', 'the')  --->  0.0078
('the', 'chief')  --->  0.0003
('chief', 'executive')  --->  0.0286
('executive', '.')  --->  0.0021
_______________________________________________
Probability 3 : Statement 1 - Total Probability - smoothing
_______________________________________________
6.487564238316089e-41
_______________________________________________
Probability 3 : Statement 2 - Total Probability - smoothing
_______________________________________________
4.7671432036555106e-48
_______________________________________________
Final Conclusion
_______________________________________________
Statement 1 is more probable than Statement 2






Second way of execution using Java :

TO Execute Java Program :
Use command :

1) java Main.java "Corpus.txt"  "The chairman made the decision to bring in a new financial planner ." "The profit of the company was going down last year said by the chief executive . "

This will produce the following output :

NO_SMOOTHING
Sentance 1 Total Probability >> 0.951889795703708E-13
Sentance 2 Total Probability >> 2.359768385147851E-11
Conclusion : Sentence 2 is preferred
 
ADD_ONE_SMOOTHING
Sentance 1 Total Probability >> 1.6229124299273976E-38
Sentance 2 Total Probability >> 1.4669833409525048E-45
Conclusion : Sentence 1 is preferred
 

 Frequency Table for Sentence 1, No Smoothning

         	the	chairman	made	the	decision	to	bring	in	a	new	financial	planner	.

the      	0	42	0	0	3	0	0	0	0	36	1	0	0

chairman 	0	0	0	0	0	1	0	1	0	0	0	0	37

made     	3	0	0	3	0	0	0	3	1	0	0	0	0

the      	0	42	0	0	3	0	0	0	0	36	1	0	0

decision 	0	0	0	0	0	7	0	0	0	0	0	0	1

to       	86	0	0	86	0	0	1	0	12	0	0	0	0

bring    	0	0	0	0	0	0	0	0	0	0	0	0	0

in       	100	0	0	100	0	2	0	0	34	10	1	0	0

a        	0	0	0	0	1	0	0	0	1	22	1	0	0

new      	0	6	0	0	0	0	0	0	0	0	0	0	0

financial	0	0	0	0	0	0	0	0	0	0	0	1	0

planner  	0	0	0	0	0	0	0	0	0	0	0	0	0

.        	147	1	0	147	0	4	0	42	12	0	0	0	0

_________________________________________________________

 Frequency Table for Sentence 2, No Smoothning

         	the	profit	of	the	company	was	going	down	last	year	said	by	the	chief	executive	.

the      	0	0	0	0	92	0	0	0	4	3	0	0	0	1	4	0

profit   	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	2

of       	267	0	0	267	1	0	1	0	1	0	0	0	267	2	0	0

the      	0	0	0	0	92	0	0	0	4	3	0	0	0	1	4	0

company  	0	0	0	0	0	6	0	0	0	0	8	1	0	0	0	22

was      	5	0	0	5	0	0	0	0	0	0	0	0	5	0	0	0

going    	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0

down     	7	0	0	7	0	0	0	0	0	0	0	0	7	0	0	0

last     	0	0	0	0	0	0	0	0	0	4	0	0	0	0	0	0

year     	0	0	1	0	0	0	0	0	0	0	1	1	0	0	0	4

said     	33	0	1	33	0	1	0	0	0	0	0	0	33	1	0	18

by       	44	0	0	44	0	0	0	0	0	0	0	0	44	0	0	0

the      	0	0	0	0	92	0	0	0	4	3	0	0	0	1	4	0

chief    	0	0	1	0	0	0	0	0	0	0	1	0	0	0	165	0

executive	0	0	14	0	0	0	0	0	0	0	7	0	0	0	0	10

.        	147	0	2	147	0	0	0	0	0	0	0	1	147	0	0	0

_________________________________________________________

 Frequency Table for Sentence 1, with AddOne Smoothning

         	the	chairman	made	the	decision	to	bring	in	a	new	financial	planner	.

the      	1	43	1	1	4	1	1	1	1	37	2	1	1

chairman 	1	1	1	1	1	2	1	2	1	1	1	1	38

made     	4	1	1	4	1	1	1	4	2	1	1	1	1

the      	1	43	1	1	4	1	1	1	1	37	2	1	1

decision 	1	1	1	1	1	8	1	1	1	1	1	1	2

to       	87	1	1	87	1	1	2	1	13	1	1	1	1

bring    	1	1	1	1	1	1	1	1	1	1	1	1	1

in       	101	1	1	101	1	3	1	1	35	11	2	1	1

a        	1	1	1	1	2	1	1	1	2	23	2	1	1

new      	1	7	1	1	1	1	1	1	1	1	1	1	1

financial	1	1	1	1	1	1	1	1	1	1	1	2	1

planner  	1	1	1	1	1	1	1	1	1	1	1	1	1

.        	148	2	1	148	1	5	1	43	13	1	1	1	1

_________________________________________________________

 Frequency Table for Sentence 2, with AddOne Smoothning

         	the	profit	of	the	company	was	going	down	last	year	said	by	the	chief	executive	.

the      	1	1	1	1	93	1	1	1	5	4	1	1	1	2	5	1

profit   	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	3

of       	268	1	1	268	2	1	2	1	2	1	1	1	268	3	1	1

the      	1	1	1	1	93	1	1	1	5	4	1	1	1	2	5	1

company  	1	1	1	1	1	7	1	1	1	1	9	2	1	1	1	23

was      	6	1	1	6	1	1	1	1	1	1	1	1	6	1	1	1

going    	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1	1

down     	8	1	1	8	1	1	1	1	1	1	1	1	8	1	1	1

last     	1	1	1	1	1	1	1	1	1	5	1	1	1	1	1	1

year     	1	1	2	1	1	1	1	1	1	1	2	2	1	1	1	5

said     	34	1	2	34	1	2	1	1	1	1	1	1	34	2	1	19

by       	45	1	1	45	1	1	1	1	1	1	1	1	45	1	1	1

the      	1	1	1	1	93	1	1	1	5	4	1	1	1	2	5	1

chief    	1	1	2	1	1	1	1	1	1	1	2	1	1	1	166	1

executive	1	1	15	1	1	1	1	1	1	1	8	1	1	1	1	11

.        	148	1	3	148	1	1	1	1	1	1	1	2	148	1	1	1

_________________________________________________________

 Probability Table for Sentence 1, with No Smoothning

         	the	chairman	made	the	decision	to	bring	in	a	new	financial	planner	.

the      	0	0.074	0	0	0.176	0	0	0	0	0.364	0.04	0	0

chairman 	0	0	0	0	0	0.002	0	0.002	0	0	0	0	0.037

made     	0.002	0	0	0.002	0	0	0	0.007	0.002	0	0	0	0

the      	0	0.074	0	0	0.176	0	0	0	0	0.364	0.04	0	0

decision 	0	0	0	0	0	0.011	0	0	0	0	0	0	0.001

to       	0.054	0	0	0.054	0	0	0.333	0	0.02	0	0	0	0

bring    	0	0	0	0	0	0	0	0	0	0	0	0	0

in       	0.063	0	0	0.063	0	0.003	0	0	0.057	0.101	0.04	0	0

a        	0	0	0	0	0.059	0	0	0	0.002	0.222	0.04	0	0

new      	0	0.011	0	0	0	0	0	0	0	0	0	0	0

financial	0	0	0	0	0	0	0	0	0	0	0	1	0

planner  	0	0	0	0	0	0	0	0	0	0	0	0	0

.        	0.093	0.002	0	0.093	0	0.006	0	0.104	0.02	0	0	0	0

_________________________________________________________

 Probability Table for Sentence 2, with No Smoothning

         	the	profit	of	the	company	was	going	down	last	year	said	by	the	chief	executive	.

the      	0	0	0	0	0.626	0	0	0	0.121	0.094	0	0	0	0.005	0.021	0

profit   	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0.002

of       	0.169	0	0	0.169	0.007	0	0.143	0	0.03	0	0	0	0.169	0.01	0	0

the      	0	0	0	0	0.626	0	0	0	0.121	0.094	0	0	0	0.005	0.021	0

company  	0	0	0	0	0	0.034	0	0	0	0	0.028	0.007	0	0	0	0.022

was      	0.003	0	0	0.003	0	0	0	0	0	0	0	0	0.003	0	0	0

going    	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0

down     	0.004	0	0	0.004	0	0	0	0	0	0	0	0	0.004	0	0	0

last     	0	0	0	0	0	0	0	0	0	0.125	0	0	0	0	0	0

year     	0	0	0.001	0	0	0	0	0	0	0	0.004	0.007	0	0	0	0.004

said     	0.021	0	0.001	0.021	0	0.006	0	0	0	0	0	0	0.021	0.005	0	0.018

by       	0.028	0	0	0.028	0	0	0	0	0	0	0	0	0.028	0	0	0

the      	0	0	0	0	0.626	0	0	0	0.121	0.094	0	0	0	0.005	0.021	0

chief    	0	0	0.001	0	0	0	0	0	0	0	0.004	0	0	0	0.868	0

executive	0	0	0.015	0	0	0	0	0	0	0	0.025	0	0	0	0	0.01

.        	0.093	0	0.002	0.093	0	0	0	0	0	0	0	0.007	0.093	0	0	0

_________________________________________________________

 Probability Table for Sentence 1, with AddOne Smoothning

         	the	chairman	made	the	decision	to	bring	in	a	new	financial	planner	.

the      	0	0.007	0	0	0.001	0	0	0	0	0.007	0	0	0

chairman 	0	0	0	0	0	0	0	0	0	0	0	0	0.006

made     	0.001	0	0	0.001	0	0	0	0.001	0	0	0	0	0

the      	0	0.007	0	0	0.001	0	0	0	0	0.007	0	0	0

decision 	0	0	0	0	0	0.001	0	0	0	0	0	0	0

to       	0.013	0	0	0.013	0	0	0	0	0.002	0	0	0	0

bring    	0	0	0	0	0	0	0	0	0	0	0	0	0

in       	0.015	0	0	0.015	0	0.001	0	0	0.006	0.002	0	0	0

a        	0	0	0	0	0	0	0	0	0	0.004	0	0	0

new      	0	0.001	0	0	0	0	0	0	0	0	0	0	0

financial	0	0	0	0	0	0	0	0	0	0	0	0	0

planner  	0	0	0	0	0	0	0	0	0	0	0	0	0

.        	0.022	0	0	0.022	0	0.001	0	0.008	0.002	0	0	0	0

***********************

 Probability Table for Sentence 2, with AddOne Smoothning

         	the	profit	of	the	company	was	going	down	last	year	said	by	the	chief	executive	.

the      	0	0	0	0	0.017	0	0	0	0.001	0.001	0	0	0	0	0.001	0

profit   	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0

of       	0.039	0	0	0.039	0	0	0	0	0	0	0	0	0.039	0.001	0	0

the      	0	0	0	0	0.017	0	0	0	0.001	0.001	0	0	0	0	0.001	0

company  	0	0	0	0	0	0.001	0	0	0	0	0.002	0	0	0	0	0.004

was      	0.001	0	0	0.001	0	0	0	0	0	0	0	0	0.001	0	0	0

going    	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0

down     	0.001	0	0	0.001	0	0	0	0	0	0	0	0	0.001	0	0	0

last     	0	0	0	0	0	0	0	0	0	0.001	0	0	0	0	0	0

year     	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0.001

said     	0.005	0	0	0.005	0	0	0	0	0	0	0	0	0.005	0	0	0.003

by       	0.007	0	0	0.007	0	0	0	0	0	0	0	0	0.007	0	0	0

the      	0	0	0	0	0.017	0	0	0	0.001	0.001	0	0	0	0	0.001	0

chief    	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0.031	0

executive	0	0	0.002	0	0	0	0	0	0	0	0.001	0	0	0	0	0.002

.        	0.022	0	0	0.022	0	0	0	0	0	0	0	0	0.022	0	0	0

***********************
