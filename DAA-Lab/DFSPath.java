/*-------------------------------------------------------------------------
                                DFSPath.java
This program checks whether a given graph is connected or is not
connected using DFS Algorithm.
       
@author Adelicia
@date   11/11/22
-------------------------------------------------------------------------*/

package DAA;

import java.util.ArrayList;
import java.util.Scanner;

public class DFSPath {

    int n;
    boolean[] visited;

    DFSPath(int n) {
        visited = new boolean[n];
    }

    ArrayList<Integer> traversal_arr = new ArrayList<>();

    int front = 0;

    void DFS(int[][] cost_matrix, int start_node) {
        n = cost_matrix.length;
        this.visited[start_node] = true;
        traversal_arr.add(start_node);
        if (isUnvisted(visited)) {
            for (int i = 0; i < n; i++) {
                if (cost_matrix[start_node][i] != 999 && !visited[i]) {
                    DFS(cost_matrix, i);
                }
            }
        }
    }

    private static boolean isUnvisted(boolean[] arr) {
        for (boolean x : arr) {
            if (x == false) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();

        int[][] cost_matrix = new int[n][n];

        System.out.println("Enter the edge matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost_matrix[i][j] = sc.nextInt();
                if (i == j) {
                    cost_matrix[i][j] = 999;
                }
            }
        }

        System.out.println("Enter starting node");
        int s_node = sc.nextInt();

        DFSPath gs1 = new DFSPath(cost_matrix.length);
        gs1.DFS(cost_matrix, s_node);
        System.out.println("Traversal order in depth first search is " + (gs1.traversal_arr));
        
        if (isUnvisted(gs1.visited)) {
            System.out.println("The graph is disjoint");
        } else
            System.out.println("All nodes are reachable");
        
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

// Traversal order in depth first search is [0, 1, 2, 4, 3]

// The graph is disjoint