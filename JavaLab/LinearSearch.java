/*--------------------------------------------------------------------------------------
                                LinearSearch.java
This program implements Linear Search to search an element from an input array.
Using method overloading and a conditional flag, 2 cases of the search are carried out -
(a) Solely printing the first position the element is found at
(b) Printing every position the element is found at

@author Adelicia Sequeira
@date   07/11/22
--------------------------------------------------------------------------------------*/

package JavaLab;

import java.util.Scanner;
import java.util.Arrays;

public class LinearSearch {

    private static void searchOp(int[] arr, int ele) {
        // Function/Method to perform case (a) of Linear Search
        // arr[] is the input array
        // ele is the element to be found using Linear Search

        boolean flag = false; // initializing flag to 'false'

        System.out.println("Case 1 - Solely printing the first position the element is found at\n");

        for (int pos = 0; pos < arr.length; pos++) { // pos is the range of indices from starting index to last index

            if (arr[pos] == ele) { // Comparing each array element with the element to be found
                flag = true; // flag is assigned 'true' if element is found
                System.out.println("The element " + ele + " was found at " + pos + "!");

                // printing first index at which the element was found
                break;
            }
        }

        if (flag == false) { // flag is assigned 'false' if element is not found
            System.out.println("The element " + ele + " was not found! Possible invalid input.");
        }

        System.out.println("*************************");
    }

    private static void searchOp(int[] arr, int ele, boolean caseTwo) {
        // Function/Method to perform case (b) of Linear Search
        boolean flag = false;

        System.out.println("Case 2 - Printing every position the element is found at\n");

        for (int pos = 0; pos < arr.length; pos++) {
            // pos is the range of indices from starting index to last index

            if (arr[pos] == ele) { // Comparing each array element with the element to be found
                flag = true; // flag is assigned 'true' if element is found
                System.out.println("The element " + ele + " was found at " + pos + "!");
                // printing indices at which the element was found
            }
        }

        if (flag == false) { // flag is assigned 'false' if element is not found
            System.out.println("The element " + ele + " was not found! Possible invalid input.");
        }

        System.out.println("*************************\n");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter the size of the array to be inputted:");
        int size = scan.nextInt();

        int[] array = new int[size];
        System.out.println("\nEnter " + size + " elements:");
        for (int ind = 0; ind < size; ind++) {
            array[ind] = scan.nextInt();
        }

        System.out.println("\nThe inputted array is:");
        System.out.println(Arrays.toString(array));

        System.out.println("\nEnter the element to be searched:");
        int element = scan.nextInt();

        System.out.println("\n*************************");
        System.out.println("Performing Linear Search!");
        System.out.println("**************************");

        searchOp(array, element); // Case (a)
        searchOp(array, element, true); // Case b)

        scan.close();
    }
}
