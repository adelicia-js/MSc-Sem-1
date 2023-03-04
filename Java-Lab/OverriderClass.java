/*-------------------------------------------------------------------------------
                                InsertionSort.java
            This program implements Insertion Sort on an input array, 
                    using the 'super' keyword and method overriding
                    
@author Adelicia
@date   09/11/22
--------------------------------------------------------------------------------*/

package JavaLab;

import java.util.Scanner;
import java.util.Arrays;

class InsertionSort {

    public void sortOp(int[] arr) {
        // Function/Method to perform Insertion Sort
        // arr[] is the input array to be sorted

        int ind1 = 0;
        int key = 0; // Element used for comparisons and subsequent swapping
        int ind2 = 0;

        for (ind1 = 1; ind1 < arr.length; ind1++) { // Sorting iteration

            key = arr[ind1]; // key is initialized to element at index ind1
            ind2 = ind1 - 1;

            while (ind2 >= 0 && key < arr[ind2]) { // Comparing arr[ind2] & key
                arr[ind2 + 1] = arr[ind2]; // arr[ind2] is swapped with element on the immediate right
                ind2--; // ind2 is decremented
            }
            arr[ind2 + 1] = key; // Now, smaller element is the key
        }

        printResult(arr);

    }

    public void printResult(int[] arr) {
        // Function/Method to print the sorted array
        System.out.println(Arrays.toString(arr) + "\n" + "*****************************");

    }
}
public class OverriderClass extends InsertionSort{

    public void sortOp(int[] array1) {
        System.out.println("After method overriding\n");
        System.out.println("The sorted array is:\n");
        super.sortOp(array1); // Accessing the super class's method
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
    
        OverriderClass result = new OverriderClass();

        result.sortOp(array);

        scan.close();
            
    }
}
