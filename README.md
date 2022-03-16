# Java-Project-Four
In this program, we are instructed to write a method called wordCount that takes a string as input and prints out all of the words encountered in that input along with their number of occurrences. We used a hashtable with separate chaining to implement the method.

NOTE: Given the vagueness of the directions, there are multiple helper methods that implement this single method. A general procedure is outlined below.

# General Procedure 
1. Split the input string into a list of strings based on non-alphabetical characters. To do 
this, we use the method String.split(“\\P{Alpha}+”). 
 
2. For each word, search if it is already in the hash table or not. If it is not, add a new entry 
with an initial frequency of 1. If it is, update the frequency. 
 
3. If a new entry is added, check if the table needs to be expanded. 
 
4. After scanning the entire list of words, loop through the hash table and print out the list 
of words and their frequencies. 
