Author: Darrel Chang
Design and Analysis of Algorithms
3310 Yunsheng Wang
California Polytechnic University of Pomona
9/29/23

Connected Components Finder

Input File Format:
-------------------------------------------------------------------------------------------------------------------------------------------------------
This program reads input from a text file where each line represents a graph. The format of the line is:

<Number of Verticies> (Vertex1, Vertex2) (Vertex2, Vertex3)

- <Number of Vertices>: An integer specifying the number of vertices in the graph.
- (<Vertex1,Vertex2> ...): Pairs of vertices enclosed in parentheses, denoting the edges in the graph. Vertices are separated by commas.

Example Input File:

5 (1,2) (3,4) (3,5) (4,5)
4 (1,2) (2,3) (1,4)

MUST HAVE SPACES BETWEEN ALL PARAMETERS (# of verticies and between ALL ordered pairs)

Command Line Usage:
-------------------------------------------------------------------------------------------------------------------------------------------------------

To run the program, use the following command line syntax in a terminal:
java -jar <file_path_to_Prog-1.jar> <file_path_to_input_file.txt>
The file path to the jar exe is Chang_Darrel_3310_Assignment1\connectedislands\target\Prog-1.jar, 
so depending on where terminal was opened, use relative path to the executable.


Expected Output:
-------------------------------------------------------------------------------------------------------------------------------------------------------
Y connected components(s):
{1, 3, 5}
{2,4}

Important Notes:
-------------------------------------------------------------------------------------------------------------------------------------------------------
- Make sure to replace `<input_file>` with the actual filename containing your graph data.
- The program assumes that vertices are represented using zero-based indexing.