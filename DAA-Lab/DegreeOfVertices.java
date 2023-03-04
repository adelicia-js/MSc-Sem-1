/*-------------------------------------------------------------------------
                            DegreeOfVertices.java
This program displays the Degree of Vertices of a Cost
Adjacency Matrix for a particular graph G.
  
@author Adelicia
@date   11/11/22
-------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;

public class DegreeOfVertices {

    public static String spacingLine = "**********************************";

    final static int infinity = 999;
    // infinity is the value of an edge when a vertex paths to itself

    private static void getDegreeArray(int[][] edge_matrix) {
        // Function/Method to print the degree array of vertices

        int size = edge_matrix.length;
        // Array to store the degree of each vertex

        int[] degreeArray = new int[size];

        for (int ind1 = 0; ind1 < size; ind1++) {

            int degreeCount = 0; // Count of degrees is initialized to 0

            for (int ind2 = 0; ind2 < size; ind2++) {

                if (edge_matrix[ind1][ind2] != infinity && edge_matrix[ind1][ind2] > 0) {
                    // If the vertex paths to another vertex

                    // (Edge = infinity when a vertex paths to itself)
                    // (Edge = 0 when a vertex is unreachable from another vertex)

                    degreeCount++;
                }

            }

            degreeArray[ind1] = degreeCount;

        }

        printResult(degreeArray);

    }

    private static void printResult(int[] degree_array) {

        int size = degree_array.length;

        for (int ind = 0; ind < size; ind++) {
            System.out.println("The degree of the vertex " + (ind + 1) + " is " + degree_array[ind]);
            System.out.println(spacingLine);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println(spacingLine + "\nEnter the number of vertices:");
        int numVer = scan.nextInt();

        int[][] edgeMatrix = new int[numVer][numVer];
        // Edge matrix to store the edges, i.e., if a vertex paths to another vertex

        System.out.println("\nEnter the edge adjacency matrix\n");

        System.out.println("[Enter 0 if there is no path, 1 if a path exists]");
        System.out.println("[Enter " + numVer + " values for each vertex]\n");
        
        for (int ind1 = 0; ind1 < numVer; ind1++) {

            for (int ind2 = 0; ind2 < numVer; ind2++) {

                edgeMatrix[ind1][ind2] = scan.nextInt();

                if (ind1 == ind2) { // If the vertex paths to itself
                    edgeMatrix[ind1][ind2] = infinity;
                }
            }
        }

        System.out.println(spacingLine);

        getDegreeArray(edgeMatrix);

        scan.close();

    }

}

// Sample input/output

// **********************************
// Enter the number of vertices:
// 3

// Enter the edge adjacency matrix
// [Enter 0 if there is no path, 1 if a path exists]

// 0 1 0
// 0 0 1
// 1 0 0
// **********************************
// The degree of the vertex 1 is 1
// **********************************
// The degree of the vertex 2 is 1
// **********************************
// The degree of the vertex 3 is 1
// **********************************