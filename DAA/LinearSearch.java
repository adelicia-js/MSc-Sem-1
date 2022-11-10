/*----------------------------------------------------------------------------
                                LinearSearch.java
This program implements Linear Search to search an element from an input array

@author Adelicia
@date   06/11/22
-----------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.Arrays;

public class LinearSearch {

    private static void searchOp(int[] arr, int ele) {
        // Function/Method to perform a Linear Search operation

        String spacingLine = "*****************************";

        boolean flag = false; // initializing flag to 'false'

        for (int pos = 0; pos < arr.length; pos++) {
            // pos is the range of indices from starting index to last index

            if (arr[pos] == ele) { // Comparing each array element with the element to be found
                flag = true; // flag is assigned 'true' if element is found
                System.out.println("The element " + ele + " was found at the index" + pos + "!");
                // printing indices at which the element was found
            }
        }

        if (flag == false) { // flag is assigned 'false' if element is not found
            System.out.println("The element " + ele + " was not found! Possible invalid input.");
        }

        System.out.println(spacingLine);
        
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String spacingLine = "*****************************";

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

        System.out.println("\n" + spacingLine);
        System.out.println("Performing Linear Search!");
        System.out.println(spacingLine);

        searchOp(array, element);

        scan.close();
        
    }

}
