Author: Darrel Chang
Design and Analysis of Algorithms
3310 Yunsheng Wang
California Polytechnic University of Pomona
9/29/23

Smallest Cost Canoe Renting Algorithms

Input File Format:
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
This program reads from an input file, where each file represents a single cost matrix. The format of the file is:

<Number of Posts>
<Cost of traveling from post 0 to post 1> <Cost of travelling from post 0 to post 2> ... <Cost of travelling from post 0 to post n-1>
<Cost of travelling from post 1 to post 2> Cost of travelling from post 1 to post 3> ... <Cost of travelling from post 1 to post m-1>
...
<Cost of travelling from post n-2 to post n-1>


- <Number of Posts>: An integer specifying the number of posts along the river.
- <Cost of travelling>: An integer representing the cost of travelling from post(row) to post (column)

Ex.
4
10 15 50
40 20
35
(Note that white space is not significant in the file since you can only travel from a to b where a < b)

Command Line Usage:
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

To run the program, use the following command line syntax in a terminal:
java -jar <file_to_canoe-1.jar> <file_path_to_input_file>
The file path to the jar executable is Chang_Darrel_3310_Assignment3\canoe\target\canoe-1.jar,
so depending on where the terminal was openned, use the relative path to the executable

