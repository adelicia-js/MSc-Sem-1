/*-----------------------------------------------------------------------
                            SelectionSort.java
        This program implements Selection Sort on an input array, 
                        using a user-defined package
                    
@author Adelicia
@date   11/11/22
------------------------------------------------------------------------*/
package JavaLab;

import java.util.Arrays;

public class SelectionSort {
    public String spacingLine = "*****************************";
    public int[] sortOp(int[] arr) {
        // Function/Method to perform Selection Sort
        // arr[] is the input array to be sorted

        int minPos = 0; // minPos stores the index of minimum element of the array
        int temp = 0; // temp is used during a swapping operation

        for (int ind1 = 0; ind1 < arr.length - 1; ind1++) { // Traversal iteration

            minPos = ind1; // minPos is initialized as the value at index ind1

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

    public void printResult(int[] arr) {
        // Function/Method to print the sorted array
        System.out.println("\n" + spacingLine);
        System.out.println("Performing Selection Sort now!");
        System.out.println(spacingLine);
        System.out.println("The sorted array is:\n");
        System.out.println(Arrays.toString(arr) + "\n" + spacingLine);

    }

}
