/*----------------------------------------------------------------------------
                                MergeSort.java
            This program implements Merge Sort on an input array,
                    using Divide and Conquer technique.
                    
@author Adelicia
@date   10/11/22
-----------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {

    private static int[] sortOp(int[] arr, int low, int high) {
        // Function/Method to perform Merge Sort
        // arr[] is the input array to be sorted
        // low is the lowest index of arr[], i.e., 0 initially
        // high is the highest index of arr[], i.e., arr.length - 1 initially

        int mid = 0; // mid element is used to partition the array into 2 subarrays

        if (low < high) {

            mid = (low + high) / 2;

            sortOp(arr, low, mid); // Subarray 1
            sortOp(arr, mid + 1, high); // Subarray 2

            mergeOp(arr, low, high, mid);

        }

        return arr; // Returns the sorted array

    }

    private static void mergeOp(int[] arr, int low, int high, int mid) {
        // Function/Method used to merge and sort the partitioned subarrays

        int size1 = mid - low + 1; // Size of temporary subarray, leftArray[]
        int size2 = high - mid; // Size of temporary subarray, rightArray[]

        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        int ind1 = 0; // Index of leftArray[]
        int ind2 = 0; // Index of rightArray[]

        int newInd = low; // Index of input array, arr[]

        for (ind1 = 0; ind1 < size1; ind1++) {
            // Copying elements from arr[] to leftArray[]
            leftArray[ind1] = arr[low + ind1];
        }

        for (ind2 = 0; ind2 < size2; ind2++) {
            // Copying elements from arr[] to rightArray[]
            rightArray[ind2] = arr[mid + ind2 + 1];
        }

        // Initalizing indices
        ind1 = 0;
        ind2 = 0;

        while ((ind1 < size1) && (ind2 < size2)) {

            if (leftArray[ind1] <= rightArray[ind2]) { 
                arr[newInd] = leftArray[ind1]; 
                //Copying elements into arr[]
                ind1++;
            }

            else {
                arr[newInd] = rightArray[ind2];
                //Copying elements into arr[]
                ind2++;
            }

            newInd++;
        }

        // If all elements are sorted in leftArray[] and rightArray[]
        // Any remaining elements are copied to arr[]

        while (ind1 < size1) {
            arr[newInd] = leftArray[ind1];
            ind1++;
            newInd++;
        }

        while (ind2 < size2) {
            arr[newInd] = rightArray[ind2];
            ind2++;
            newInd++;
        }

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

        System.out.println("\nEnter " + size + " elements:");
        int[] array = new int[size];
        for (int ind = 0; ind < size; ind++) {
            array[ind] = scan.nextInt();
        }

        System.out.println("\nThe array you inputted is:");
        System.out.println(Arrays.toString(array));

        System.out.println("\n" + spacingLine);
        System.out.println("Performing Merge Sort now!");
        System.out.println(spacingLine);
        System.out.println("The sorted array is:\n");

        printResult(sortOp(array, 0, array.length - 1));

        scan.close();

    }

}