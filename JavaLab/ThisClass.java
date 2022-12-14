/*-------------------------------------------------------------------------------
                                ThisClass.java
This program calculates GCD and LCM using 'this' keyword and multiple inheritance  
                    
@author Adelicia
@date   11/11/22
-------------------------------------------------------------------------------*/
package JavaLab;

import java.util.Scanner;

class NumericalValues {
    int num1 = 0;
    int num2 = 1;
}

public class ThisClass extends NumericalValues {
    
    private void mathOp(int num1, int num2) {

        this.num1 = num1;
        this.num2 = num2;

        int gcd = 1;

        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }

        int lcm=0;

        lcm=(num1*num2)/gcd;

        System.out.println("Finding the GCD of " + num1 + " and " + num2 + "!\n");
        System.out.println("The GCD is: " + gcd);
        System.out.println("\nFinding the LCM of " + num1 + " and " + num2 + "!\n");
        System.out.println("The LCM is: " + lcm);
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 2 numbers:\n");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        ThisClass result = new ThisClass();
        result.mathOp(num1, num2);
        scan.close();
    }
}