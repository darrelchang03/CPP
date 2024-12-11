
/**************************************************************/
/* Darrel Chang */
/* Bronco ID: 015612623 */
/* CS 3310, Fall 2023 */
/* Programming Assignment 3 */
/* Optimal Canoe Renting: Computes the most cost effective rental path to get to each post*/
/**************************************************************/

package com.canoe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CanoeRental {

    public static void main(String[] args) {

        if(args.length != 1) {
            System.err.println("Usage: java ConnectedComponents inputFileName.txt");
            return;
        }

        String fileName = args[0];

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            // Read the number of posts
            int n = Integer.parseInt(br.readLine().trim());

            // Initialize the cost matrix
            int[][] C = new int[n][n];

            // Read the cost matrix from the file
            for (int i = 0; i < n - 1; i++) {
                String[] values = br.readLine().trim().split("\\s+");
                for (int j = i + 1; j < n; j++) {
                    C[i][j] = Integer.parseInt(values[j - i - 1]);
                }
            }
            // Print input matrix
            System.out.println("Input Matrix:");
            printMatrix(C);
            // Calculate optimal costs and print the matrix
            int[][] optimalCosts = calculateOptimalCosts(C);
            System.out.println("Optimal Cost Matrix:");
            printMatrix(optimalCosts);

            // Print the optimal sequence of rentals
            System.out.println("Optimal Sequence of Rentals:");
            printOptimalSequence(optimalCosts);

            //close buffered reader
            br.close();

            // catch block if cmd line file cannot be found
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/**************************************************************/
/* Method: calculateOptimalCosts */
/* Purpose: Takes in 2D matrix which represents the cost of getting from post in row to post in column, to find the optimal cost matrix */
/* Parameters: int[][] costMatrix*/
/* Returns: String: Lines from the input file */
/**************************************************************/

    private static int[][] calculateOptimalCosts(int[][] costMatrix) {

        // Copy input matrix to new matrix
        int n = costMatrix.length;
        int [][]optMatrix = new int[n][];
        for(int i = 0; i < n; i++) {
            optMatrix[i] = costMatrix[i].clone();
        }

        // Floyd-Warshall's algorithm to calculate optimal costs to all post shortest path
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (optMatrix[i][k] + optMatrix[k][j] < optMatrix[i][j]) {
                        optMatrix[i][j] = optMatrix[i][k] + optMatrix[k][j];
                    }
                }
            }
        }

        return optMatrix;
    }

/**************************************************************/
/* Method: printMatrix */
/* Purpose: Prints matrix into terminal*/
/* Parameters: int[][]matrix*/
/* Returns: void */
/**************************************************************/

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

/**************************************************************/
/* Method: printOptimalSequence */
/* Purpose: prints the sequence of canoe rentals used to get to the last post*/
/* Parameters: int[][]costMatrix*/
/* Returns: void */
/**************************************************************/

    private static void printOptimalSequence(int[][] costMatrix) {
        int i = 0;
        int j = costMatrix.length - 1;

        // System.out.println("Rent canoe at post " + i + " for 0");

        while (i < j) {
            int nextPost = -1;
            int minCost = 99999999;

            // Find the next post with minimum cost using part of floyd-warshall algorithm
            for (int k = i + 1; k <= j; k++) {
                if (costMatrix[i][k] + costMatrix[k][j] < minCost) {
                    minCost = costMatrix[i][k] + costMatrix[k][j];
                    nextPost = k;
                }
            }

            // Print the rental information
            System.out.println("Rent canoe at post " + nextPost + " for " + costMatrix[i][nextPost]);
            i = nextPost;
        }
        
        System.out.println("Total cost: " + costMatrix[0][costMatrix.length - 1]);
    }
}
