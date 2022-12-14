/*--------------------------------------------------------------------
                        KnapsackProblem.java
This program implements 0/1 Knapsack Problem using Dynamic Programming
                    
@author Adelicia
@date   11/11/22
---------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.Arrays;

public class KnapsackProblem {

    public static String spacingLine = "******************************************";

    private static Double knapsackSolve(SackObject[] objArray, Double max_cap) {
        // Function/Method to find the feasible solutions for the knapsack problem

        for (int i = 0; i < objArray.length; i++) {

            if (objArray[i].weight <= max_cap) { // If the weight of the ith object < max capacity
                                                 // Entire fraction, i.e., 1 is added to solution set
                objArray[i].fraction = 1.0;
                max_cap -= objArray[i].weight;
            } else { // Else, no fraction is added, i.e., 0 is added to the solution set
                objArray[i].fraction = 0.0;
                break;
            }
        }

        double totalProfit = 0.0; // Total Profit is initialized to 0

        System.out.println(spacingLine + "\nThe feasible solutions are ");

        for (SackObject obj : objArray) { // For each object in the object array
            System.out.printf("%.2f, ", obj.fraction);
            totalProfit += obj.fraction * obj.profit;
        }

        System.out.println("\n");

        return totalProfit;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter the number of objects");
        int size = scan.nextInt();

        SackObject[] ObjArray = new SackObject[size];

        for (int ind = 0; ind < size; ind++) {

            ObjArray[ind] = new SackObject();

            System.out.println("\nEnter the weight and profit of object " + (ind + 1));

            ObjArray[ind].weight = scan.nextInt();
            ObjArray[ind].profit = scan.nextInt();

            ObjArray[ind].objInd = ind;

            ObjArray[ind].ratio = (double) (ObjArray[ind].profit / ObjArray[ind].weight);

            ObjArray[ind].fraction = 0.0;

        }

        System.out.println("\nEnter the max capacity of the knapsack");
        Double maxCap = scan.nextDouble();
        Double maxProfit = 0.0;

        // According to Weight
        Arrays.sort(ObjArray, (a, b) -> a.weight.compareTo(b.weight));

        // int flag = 0;
        System.out.println("\nAccording to weight");
        maxProfit = knapsackSolve(ObjArray, maxCap);
        // flag = 1;

        // According to Profit
        Arrays.sort(ObjArray, (a, b) -> a.profit.compareTo(b.profit));

        System.out.println("\nAccording to profit");
        if (knapsackSolve(ObjArray, maxCap) > maxProfit) {
            maxProfit = knapsackSolve(ObjArray, maxCap);
            // flag = 2;
        }

        // According to Profit/Weight ratio
        Arrays.sort(ObjArray, (a, b) -> a.ratio.compareTo(b.ratio));

        System.out.println("\nAccording to profit/weight ratio");
        if (knapsackSolve(ObjArray, maxCap) > maxProfit) {
            maxProfit = knapsackSolve(ObjArray, maxCap);
            // flag = 3;
        }

        // if (flag == 3) {
        // System.out.println("\nOptimal solution set is obtained when arranged acc to
        // ratio!\n");
        // }
        // if (flag == 2) {
        // System.out.println("\nOptimal solution set is obtained when arranged acc to
        // profit!\n");
        // }
        // if (flag == 1) {
        // System.out.println("\nOptimal solution set is obtained when arranged acc to
        // weight!\n");
        // }

        System.out.printf("\nThe maximum profit possible is %.2f\n", maxProfit);

        scan.close();

    }
}

class SackObject {
    // A class to store the properties of sack objects

    Integer weight; // Weight of each object

    Integer profit; // Profit of each object

    Integer objInd; // ID of each object

    Double ratio; // Profit divided by weight

    Double fraction; // Fraction of object in knapsack, can be either 0 or 1
}