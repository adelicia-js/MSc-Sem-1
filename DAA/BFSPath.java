/*-------------------------------------------------------------------------
                                BFSPath.java
This program prints all reachable nodes from a given starting
node in a digraph using BFS Algorithm.
                    
@author Adelicia
@date   11/11/22
-------------------------------------------------------------------------*/

package DAA;

import java.util.ArrayList;
import java.util.Scanner;

public class BFSPath {
    int n;
    boolean[] visited;

    BFSPath(int n) {
        visited = new boolean[n];
    }

    ArrayList<Integer> traversal_arr = new ArrayList<>();

    int front = 0;

    void rBFS(int[][] cost_matrix, int start_node) {
        n = cost_matrix.length;
        this.visited[start_node] = true;
        if (!traversal_arr.contains(start_node))
            traversal_arr.add(start_node);

        for (int i = 0; i < n; i++) {
            if (cost_matrix[start_node][i] != 999 && !visited[i]) {
                if (!traversal_arr.contains(i))
                    traversal_arr.add(i);
            }
        }
        if (traversal_arr.size() > front + 1)
            rBFS(cost_matrix, traversal_arr.get(++front));
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the number of vertices:");
        int n = sc.nextInt();

        int[][] cost_matrix = new int[n][n];

        System.out.println("\nEnter the edge matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost_matrix[i][j] = sc.nextInt();
                if (i == j) {
                    cost_matrix[i][j] = 999;
                }
            }
        }

        System.out.println("\nEnter starting node:");
        int s_node = sc.nextInt();

        BFSPath gs1 = new BFSPath(cost_matrix.length);
        gs1.rBFS(cost_matrix, s_node);
        System.out.println("\nTraversal order in breadth first search is " + (gs1.traversal_arr));
        
        sc.close();
    }
}

// Sample input/output

// Enter the number of vertices
// 7

// Enter the edge matrix
// 999 1 999 999 999 999 999
// 1 999 1 1 999 999 999
// 999 1 999 999 1 999 999
// 1 1 999 999 999 999 999
// 999 999 1 999 999 999 999
// 999 999 999 999 999 999 1
// 999 999 999 999 999 1 999

// Enter starting node
// 0

// Traversal order in breadth first search is [0, 1, 2, 3, 4]
