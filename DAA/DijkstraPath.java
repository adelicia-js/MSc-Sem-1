/*-------------------------------------------------------------------------
                                DijkstraPath.java
This program finds the single source shortest path for a given vertex in a
weighted connected graph using Dijkstra's Algorithm
                    
@author Adelicia
@date   11/11/22
-------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.Arrays;

public class DijkstraPath {

    public static String spacingLine = "******************************************";

    public static int infinity = 999;
    // infinity is the value of an edge when a vertex paths to itself

    public static void dijkstraSolve(int[][] graph, int source) {
        // Function/Method to find the shortest path of a single source

        int numVer = graph.length;
        // numVer is the number of vertices, i.e., size of the graph
        boolean[] visitedVertices = new boolean[numVer];
        // Boolean array to store visited vertices, true if visited, false if unvisited
        int[] distance = new int[numVer];
        // Array to store minimum distances from source to vertices

        Arrays.fill(visitedVertices, false);
        // Marking all vertices as unvisited initially
        Arrays.fill(distance, infinity);
        // Marking all minimum distances as infinity

        distance[source] = 0;
        // Distance of source to itself is zero

        for (int ind = 0; ind < numVer; ind++) {

            int vertex1 = findMinDistance(distance, visitedVertices);
            visitedVertices[vertex1] = true;
            // Updating the distances between source vertex and neighbouring vertices

            for (int vertex2 = 0; vertex2 < numVer; vertex2++) {

                if (!visitedVertices[vertex2] && graph[vertex1][vertex2] != 0
                        && (distance[vertex1] + graph[vertex1][vertex2] < distance[vertex2])) {
                    distance[vertex2] = distance[vertex1] + graph[vertex1][vertex2];
                    // Updating all the neighbouring vertices distances
                }
            }
        }

        for (int ind = 0; ind < distance.length; ind++) {
            System.out.format(spacingLine + "\nShortest distance from %s to %s is %s", source + 1, ind + 1,
                    distance[ind] + "\n" + spacingLine);
        }

    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertices) {
        // Function/Method to find the minimum distance vertex from unvisited vertices

        int minDistance = infinity;
        // Initializing minimum distance as infinity
        int minDistanceVertex = -1;
        // Initializing minimum distance vertex as -1

        for (int ind = 0; ind < distance.length; ind++) {
            if (!visitedVertices[ind] && distance[ind] < minDistance) {
                minDistance = distance[ind];
                minDistanceVertex = ind;
            }
        }

        return minDistanceVertex;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println(spacingLine + "\nEnter the number of vertices:");
        int numVertex = scan.nextInt();

        int[][] costMatrix = new int[numVertex][numVertex];
        // Cost adjacency matrix, stores edges

        System.out.println("\nEnter the cost adjacency matrix:");
        System.out.println("[Enter " + numVertex + " values for each vertex]");
        for (int ind1 = 0; ind1 < numVertex; ind1++) {

            for (int ind2 = 0; ind2 < numVertex; ind2++) {

                costMatrix[ind1][ind2] = scan.nextInt();

                if (ind1 == ind2) { // If the vertex paths to itself
                    costMatrix[ind1][ind2] = infinity;
                }
            }
        }

        dijkstraSolve(costMatrix, 0);
        // Source is the first vertex

        scan.close();

    }

}

// Sample input/output

// Enter the number of vertices
// 5

// Enter the cost adjacency matrix
// 999 1 999 3 10
// 999 999 5 999 999
// 999 999 999 999 1
// 999 999 2 999 6
// 999 999 999 999 999

// Shortest distance from 1 to 1 is 0

// Shortest distance from 1 to 2 is 1

// Shortest distance from 1 to 3 is 5

// Shortest distance from 1 to 4 is 3

// Shortest distance from 1 to 5 is 6