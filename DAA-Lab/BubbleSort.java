/*----------------------------------------------------------------------------
                                BubbleSort.java
            This program implements Bubble Sort on an input array.
                    
@author Adelicia
@date   09/11/22
-----------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.Arrays;

public class BubbleSort {

    private static int[] sortOp(int[] arr) {
        // Function/Method to perform Bubble Sort
        // arr[] is the input array to be sorted

        int temp = 0;
        // temp is used during a swapping operation

        boolean swapChecker = false; // swapChecker is used to check if elements are already swapped (sorted)

        for (int ind1 = 0; ind1 < arr.length - 1; ind1++) { // Sorting iteration

            swapChecker = false;

            for (int ind2 = 0; ind2 < arr.length - ind1 - 1; ind2++) { // Swapping iteration

                if (arr[ind2] > arr[ind2 + 1]) {

                    temp = arr[ind2];
                    arr[ind2] = arr[ind2 + 1];
                    arr[ind2 + 1] = temp;

                    swapChecker = true;
                    // Once swapChecker is true, next sorting iteration is performed or
                    // The sorted array is printed if all elements are sorted
                }
            }

            if (swapChecker != true) { // Sorting iteration will continue as long as swapChecker is false
                break;
            }
        }

        return arr; // Returns the sorted array

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
        System.out.println("Performing Bubble Sort now!");
        System.out.println(spacingLine);
        System.out.println("The sorted array is:\n");

        printResult(sortOp(array));

        scan.close();

    }

}
