/* ******************************************************************************************
                                    StatsOps.java
This program calculates the mean, median and mode of the elements of an array
using Command Line Arguments. 

@author Adelicia
@date 01/11/22
******************************************************************************************** */

package JavaLab;

import java.util.Arrays;

public final class StatsOps {

    private static void meanCalc(int[] arr) {
        // Function/Method to calculate the mean of an array
        int size = arr.length;

        double mean = 0.0;
        double sum = 0.0;

        for (int i = 0; i < size; i++) {
            sum = sum + arr[i];
        }

        mean = sum / size;

        System.out.println("The sum of " + size + " numbers is: " + sum + ".\n");
        System.out.println("The mean of " + size + " numbers is: " + mean + ".\n");
    }

    private static void medianCalc(int[] arr) {
        // Function/Method to calculate the median of an array
        int size = arr.length;

        double median = 0.0;

        // If the array contains an even number of elements
        if (size % 2 == 0) {
            median = (arr[size / 2 - 1] + arr[size / 2]) / 2;
        }

        // If the array contains an odd number of elements
        else {
            median = arr[size / 2];
        }

        System.out.println("The median of " + size + " numbers is: " + median + ".\n");
    }

    private static void modeCalc(int[] arr) {
        // Function/Method to calculate the mode of an array

        int size = arr.length;

        Arrays.sort(arr);

        int mode = 0;

        // A counter that is iterated every time an element is repeated in the array
        int count;

        // A counter storing the maximum number of times an element was repeated
        int maxCount = 1; // Initializing maxCount to 1

        for (int ind1 = 0; ind1 < size; ind1++) { // Index1 starts at the first element, ends at the last
            count = 1; // Setting counter to 1 for every comparison loop
            for (int ind2 = ind1 + 1; ind2 < size; ind2++) {
                // Index 2 starts at the (index1 + 1, i.e., second) element, ends at the last
                if (arr[ind2] == arr[ind1]) {
                    count += 1; // Counter is incremented every time the 2 comparisons match
                }
            }
            // If the count of an element > Max recorded count
            if (count > maxCount) {
                // This count is now assigned to maxCount
                maxCount = count;
                // Element with maxCount is assigned to mode
                mode = arr[ind1];
            }
        }
        System.out.println(
                "The mode of " + size + " numbers is: " + mode + ". It was repeated " + maxCount + " times.\n");
    }

    public static void main(String[] args) {

        final int length = 5;
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            // parseInt() parses string arguments passed in the command line and returns
            // integer values
            array[i] = Integer.parseInt(args[i]);
        }

        System.out.println("\nThe array you inputted is:");
        System.out.println(Arrays.toString(array) + "\n");

        meanCalc(array);
        medianCalc(array);
        modeCalc(array);
    }
}