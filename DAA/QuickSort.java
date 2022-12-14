/*----------------------------------------------------------------------------
                                QuickSort.java
            This program implements Quick Sort on an input array,
                    using Divide and Conquer technique.
                    
@author Adelicia
@date   10/11/22
-----------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {

    private static int[] sortOp(int[] arr, int low, int high) {
        // Function/Method to perform Merge Sort
        // arr[] is the input array to be sorted
        // low is the lowest index of arr[], i.e., 0 initially
        // high is the highest index of arr[], i.e., arr.length - 1 initially

        int pivot = 0; // Pivot element which is used to partition the array into 2 subarrays

        if (low < high) {
            pivot = partitionOp(arr, low, high); // pivot is the value returned by partitionOp
            sortOp(arr, low, pivot - 1); // Subarray 1
            sortOp(arr, pivot + 1, high); // Subarray 2
        }

        return arr; // Returns the sorted array

    }

    private static int partitionOp(int[] arr, int low, int high) {
        // Function/Method used to partition the input array, arr[]
        // Elements greater than the pivot element are moved to the right side of the array
        // Elements smaller than the pivot element are moved to the left side of the array

        int ind1 = low; // Initializing an index, ind1 = low
        int ind2 = high; // Initializing an index, ind2 = high

        int key = arr[low]; // key is the pivot element
                            // It is used for comparisons and subsequent swapping when ind1 < ind2
                            // key is initialized as the first element of the array

        int temp1 = 0; // temp1 used for swapping if ind2 > ind1
        int temp2 = 0; // temp2 used for assigning a new key

        while (ind1 < ind2) {
            while (arr[ind1] < key && ind1 < high) {
                ind1++;
            }

            while (arr[ind2] > key && ind2 >= low) {
                ind2--;
            }


            if (ind1 < ind2) {
                temp1 = arr[ind1];
                arr[ind1] = arr[ind2];
                arr[ind2] = temp1;
            }
        }

        if (ind1 > ind2) {
            temp2 =  arr[ind2];
            arr[ind2] = key;
            key = temp2;
        }

        return ind2;

    }

    private static void printResult(int[] arr) {
        // Function/Method to print the sorted array
        System.out.println(Arrays.toString(arr) + "\n" + "*****************************");
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
        System.out.println("Performing Quick Sort now!");
        System.out.println(spacingLine);
        System.out.println("The sorted array is:\n");

        printResult(sortOp(array, 0, array.length - 1));

        scan.close();

    }

}
