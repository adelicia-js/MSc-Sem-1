/*-------------------------------------------------------------------------
                                FloydPath.java
This program implements the all pair shortest path’s problem using
Floyd’s Algorithm.
            
@author Adelicia
@date   11/11/22
-------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;

public class FloydPath {

    public static String spacingLine = "*****************************";

    private static void floydSolve(int graph[][], int num) {
        // Function/Method to find the all pair shortest path matrix for the input graph

        int distMatrix[][] = new int[num][num];
        // A matrix to store shortest distances between nodes

        for (int ind1 = 0; ind1 < num; ind1++)
            for (int ind2 = 0; ind2 < num; ind2++)
                distMatrix[ind1][ind2] = graph[ind1][ind2];

        for (int newInd = 0; newInd < num; newInd++) {

            for (int ind1 = 0; ind1 < num; ind1++) {

                for (int ind2 = 0; ind2 < num; ind2++) {

                    if (distMatrix[ind1][newInd] + distMatrix[newInd][ind2] < distMatrix[ind1][ind2]) {

                        distMatrix[ind1][ind2] = distMatrix[ind1][newInd] + distMatrix[newInd][ind2];

                    }
                }
            }
        }

        printResult(distMatrix, num);

    }

    private static void printResult(int dist_matrix[][], int num) {
        // Function/Method to print results of the shortest path search operation

        System.out.println(spacingLine + "\nSHORTEST PATH MATRIX:-");

        for (int ind1 = 0; ind1 < num; ++ind1) {

            for (int ind2 = 0; ind2 < num; ++ind2) {

                if (dist_matrix[ind1][ind2] == 999) {
                    System.out.print("infinity ");
                } else {
                    System.out.print(dist_matrix[ind1][ind2] + " ");
                }
            }
            System.out.println();
        }
        System.out.println(spacingLine);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println(spacingLine + "\nEnter the number of vertices: ");
        int numVer = scan.nextInt();

        int[][] costMatrix = new int[numVer][numVer];
        // Costs/Distances, i.e., the edges are stored in this matrix

        System.out.println("\nEnter the cost matrix: ");
        System.out.println("[Enter " + numVer + " edges for each vertex.]\n");

        for (int ind1 = 0; ind1 < numVer; ind1++) {

            for (int ind2 = 0; ind2 < numVer; ind2++) {

                costMatrix[ind1][ind2] = scan.nextInt();

                if (ind1 == ind2) { // If a vertex paths to itself
                    costMatrix[ind1][ind2] = 0;
                }

            }
        }

        floydSolve(costMatrix, numVer);

        scan.close();
    }
}

// Sample input/output

// *****************************
// Enter the number of vertices:
// 3

// Enter the cost matrix:
// [Enter 3 edges for each vertex.]

// 0 4 11
// 6 0 2
// 3 7 0
// *****************************
// SHORTEST PATH MATRIX:-
// 0 4 6
// 5 0 2
// 3 7 0
// *****************************