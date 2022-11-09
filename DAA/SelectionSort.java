/*----------------------------------------------------------------------------
                                SelectionSort.java
            This program implements Selection Sort on an input array.
                    
@author Adelicia Sequeira
@date   09/11/22
-----------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.Arrays;

public class SelectionSort {

    private static int[] sortOp(int[] arr) {
        // Function/Method to perform Selection Sort
        // arr[] is the input array to be sorted

        int minPos = 0; // minPos stores the index of minimum element of the array
        int temp = 0; // temp is used during a swapping operation

        for (int ind1 = 0; ind1 < arr.length - 1; ind1++) { // Traversal iteration

            minPos = ind1; // minPos is initialized as the value at index = 0

            for (int ind2 = ind1 + 1; ind2 < arr.length; ind2++) {
                // Traversing from the index immediately after ind1

                if (arr[ind2] < arr[minPos]) { // Comparing elements with element at minPos
                    minPos = ind2;
                    // Value at ind2 is assigned to minPos,
                    // i.e., arr[ind2] is now the minimum element
                }
            }
            // Swapping element at ind1 with new minimum element, i.e., arr[ind2] or
            // arr[minPos]
            temp = arr[ind1];
            arr[ind1] = arr[minPos];
            arr[minPos] = temp; // Element at minPos is pushed to the front of the array

        }

        return arr; // Returns the sorted array

    }

    private static void printResult(int[] arr) {
        // Function/Method to print the sorted array
        System.out.println(Arrays.toString(arr) + "\n");

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String spacingLine = "*****************************";

        System.out.println("\nEnter the size of the array to be inputted:");
        int size = scan.nextInt();

        System.out.println("\nEnter the elements of the array:");
        int[] array = new int[size];
        for (int ind = 0; ind < size; ind++) {
            array[ind] = scan.nextInt();
        }

        System.out.println("\nThe array you inputted is:");
        System.out.println(Arrays.toString(array));

        System.out.println("\n" + spacingLine);
        System.out.println("Performing Selection Sort now!");
        System.out.println(spacingLine);
        System.out.println("The sorted array is:");

        printResult(sortOp(array));

        scan.close();
    }
}
