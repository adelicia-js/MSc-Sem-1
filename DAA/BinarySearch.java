/*----------------------------------------------------------------------------
                                BinarySearch.java
This program implements Binary Search to search an element from an input array
                    using the Divide and Conquer technique.
                    
@author Adelicia Sequeira
@date   05/11/22
-----------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {

    private static void searchOp(int[] arr, int length, int ele) {
        // function/method to perform a Binary Search operation
        // arr[] is the input array
        // ele is the element to be found using Binary Search

        int low = 0;
        // low is the lowest index of the array

        int high = length - 1;
        // high is highest index of the array

        int mid = (low + high) / 2;
        // mid is the index of the element in the middle of the array

        while (low <= high) { // array has one or more than one element
            if (arr[mid] < ele) {
                low = mid + 1;
            } else if (arr[mid] == ele) {
                System.out.println("The element " + ele + " was found at the index " + mid);
                break;
            } else { // arr[mid]>ele
                high = mid - 1;
            }
            mid = low + high / 2;
        }

        if (low > high) {
            System.out.println("The element " + ele + " was not found. Possible invalid input.");
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter the size of the array to be inputted:");
        int size = scan.nextInt();

        System.out.println("Enter the elements of the array:");
        int[] array = new int[size];
        for (int ind = 0; ind < size; ind++) {
            array[ind] = scan.nextInt();
        }

        System.out.println("The array you inputted is:");
        System.out.println(Arrays.toString(array));

        System.out.println("Enter the element to be searched:");
        int element = scan.nextInt();

        System.out.println("\nPerforming Binary Search now!\n");
        searchOp(array, size, element);

        scan.close();
    }
}