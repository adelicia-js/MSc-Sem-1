/*-------------------------------------------------------------------------
MaxMin.java
This program finds the minimum and maximum elements in an array of elements multiple inheritance and interfaces
                    
@author Adelicia Sequeira
@date   10/11/22
-------------------------------------------------------------------------*/

package JavaLab;

import java.util.Scanner;
import java.util.Arrays;

interface MaxMinSearch {
    public static int[] searchOp(int[] arr, int low, int high) {
        return arr;
    }
}

interface ResultPrint {
    public static void printResult(int[] resultArr) {
    };
}

public class MaxMin implements MaxMinSearch, ResultPrint {
    // Implementing interfaces

    public static String spacingLine = "**********************************";

    public static int[] searchOp(int[] arr, int low, int high) {
        // Defining the method declared in interface MaxMinSearch
        // Function/Method to find the minimum and maximum elements of an array

        int resultArray[] = new int[2];
        // resultArray[] stores the minimum and maximum elements

        Arrays.sort(arr);
        // Sorting the array before any searching

        int mid = 0;
        // mid is the middle element used to partition the array in the case of
        // arr.length > 2

        int ind1 = low;
        // Index of first element
        int ind2 = high;
        // Index of last element

        if (ind1 == ind2) { // arr.length = 1
            resultArray[0] = resultArray[1] = arr[ind1];
            // Minimum and Maximum element are equal
            return resultArray;
        }

        else if (ind1 == ind2 - 1) { // arr.length = 2
            if (arr[ind1] < arr[ind2]) {
                resultArray[0] = arr[ind1];
                resultArray[1] = arr[ind2];
                return resultArray;
            }

            else {
                resultArray[0] = arr[ind2];
                resultArray[1] = arr[ind1];
                return resultArray;
            }
        }

        else { // arr.length > 2
            mid = (ind1 + ind2) / 2;

            int[] leftArray = searchOp(arr, low, mid);
            // Subarray 1
            int[] rightArray = searchOp(arr, mid + 1, high);
            // Subarray 2

            if (leftArray[0] < rightArray[0]) {
                // Comparing minimum elements of the 2 subarrays
                resultArray[0] = leftArray[0];
            } else {
                resultArray[0] = rightArray[0];
            }
            if (leftArray[1] > rightArray[1]) {
                // Comparing maximum elements of the 2 subarrays
                resultArray[1] = leftArray[1];
            }

            else {
                resultArray[1] = rightArray[1];
            }
            return resultArray;
        }
    }

    public static void printResult(int[] resultArr) {
        // Defining the method declared in interface ResultPrint
        // Function/Method to print the results of the search operation

        if (resultArr[0] == resultArr[1]) {
            System.out.println("The minimum and maximum element of the array are equal and the value is " + resultArr[0]
                    + "!\n" + spacingLine);
        } else {
            System.out.println("The minimum element of the array is " +
                    resultArr[0] + "!\n");
            System.out.println("The maximum element of the array is " +
                    resultArr[1] + "!\n" + spacingLine);
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter the size of the array to be inputted:");
        int size = scan.nextInt();
        System.out.println("\nEnter " + size + " numbers:");
        int[] array = new int[size];
        for (int ind = 0; ind < size; ind++) {
            array[ind] = scan.nextInt();
        }
        System.out.println("\nThe array you inputted is:");
        System.out.println(Arrays.toString(array));
        System.out.println("\n" + spacingLine + "\nPerforming a Max-Min Operation now\n" + spacingLine);
        printResult(searchOp(array, 0, array.length - 1));

        scan.close();

    }

}
