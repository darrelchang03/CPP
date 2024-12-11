Author: Darrel Chang
Design and Analysis of Algorithms
3310 Yunsheng Wang
California Polytechnic University of Pomona
11/3/23

Anagram Detector

Command Line Usage:
-------------------------------------------------------------------------------------------------------------------------------------------------------

To run the program, use the following command line syntax in a terminal:
java -jar <file_path_to_anagram-1.0> <file_path_to_input_file.txt>
The file path to the jar exe is Chang_Darrel_3310_Assignment2\anagram\target\anagram-1.0.jar, 
so depending on where terminal was opened, use the relative path to the executable.

Input File Format:
-------------------------------------------------------------------------------------------------------------------------------------------------------
This program reads input from a text file where each line represents a word to be check against other words to see if they are anagrams of each other.
Format:
<word1>
<word2>
<word3>
...
<wordn>

word: Represents a string to be checked against the other strings in the file. The string will not distinguish between strings with and without space, accents, or capitalization
For example, "D óg" will be an anagram of "dog" because they contain the same alphabetical characters

Example input:
--------------------------------------------------------------------------------------------------------------------------------------------------------
innings
sinning
drugging
grudging

Example output:

[innings, sinnings]
[drugging, grudging]
