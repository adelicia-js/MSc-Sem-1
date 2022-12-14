/*Driver Class*/
package JavaLab.DriverPackage;

import java.util.Scanner;
import java.util.Arrays;
import JavaLab.SelectionSort;

public class DriverClass {
    public static void main(String[] args) {

        SelectionSort obj = new SelectionSort();

        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter the size of the array to be inputted:");
        int size = scan.nextInt();

        System.out.println("\nEnter the elements of the array:");
        int[] array = new int[size];
        for (int ind = 0; ind < size; ind++) {
            array[ind] = scan.nextInt();
        }

        System.out.println("\nThe array you inputted is:");
        System.out.println(Arrays.toString(array));

        obj.printResult(obj.sortOp(array));

        scan.close();
        
    }
    
}