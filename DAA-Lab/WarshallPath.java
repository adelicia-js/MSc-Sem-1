/*-------------------------------------------------------------------------
                                FloydPath.java
This program computes the transitive closure of a given directed graph using
Warshall's algorithm
            
@author Adelicia
@date   11/11/22
-------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;

public class WarshallPath {

    private void transClose(int[][] mat) {
        int num = mat.length;
        int[][] reach = mat;
    
        for(int k = 0; k < num ; k++)
            for(int i = 0; i < num ; i++)
                for(int j = 0; j < num ; j++)
                    if(reach[i][j]!=0 || reach[i][k]!=0 && reach[k][j]!=0)
                        reach[i][j] = 1;
    
    
    
        System.out.println("Transitive closure: ");
        for(int i = 0; i < num ; i++) {
            for(int j = 0; j < num ; j++) {
                if(i==j)
                    System.out.print("1 ");
                else
                    System.out.print(reach[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int ver = sc.nextInt();
        
        int[][] edgeMat = new int[ver][ver];
        for(int i = 0; i<ver; i++)
            for(int j = 0; j < ver; j++)
                edgeMat[i][j] = sc.nextInt();

        
        WarshallPath obj = new WarshallPath();

        obj.transClose(edgeMat);

        sc.close();
    }
}

// Sample input/output

// Enter the number of vertices
// 4

// Graph

// 1 1 0 1
// 0 1 1 0
// 0 0 1 1
// 0 0 0 1

// Transitive Closure

// 1 1 1 1
// 0 1 1 1
// 0 0 1 1
// 0 0 0 1