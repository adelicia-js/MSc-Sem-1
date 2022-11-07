/* ******************************************************************************************
                                    StringOps1.java
This program carries out the string operations of:
(a) Concatenation of two strings
(b) Trimming a string
(c) Counting the number of vowels in a string

@author Adelicia
@date 31/10/22
******************************************************************************************** */

package JavaLab;

import java.util.Scanner;
import java.lang.String;

public final class StringOps1 {

    private static void concatStr(String sen1, String sen2) {
        // function/method to concatenate two strings
        // in-built method 'String concat()' used
        System.out.println(
                "\nThe concatenation of \"" + sen1 + "\" and \"" + sen2 + "\" is \"" + sen1.concat(sen2) + "\".\n");

    }

    private static void trimStr(String sen1, int pos) {
        // function/method to trim a string of its whitespaces and up till an input
        // position
        // in-built methods 'String trim()' & 'String substring()' used
        System.out.println("\nThe original string is \"" + sen1 + "\",\n");

        System.out.println("The trimmed string after removing whitespaces is \"" + sen1.trim() + "\".\n");

        System.out.println("The trimmed string up till index " + pos + " is \"" + sen1.substring(0, pos) + "\".\n");
    }

    private static void vowelStr(String sen1) {
        // function/method to count the number of vowels in a string
        // in-built method 'char charAt()' and 'int length()' used
        int count = 0;

        for (int pos = 0; pos < sen1.length(); pos++) {
            char ch = sen1.charAt(pos);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println("\nThe number of vowels in the string \"" + sen1 + "\" is " + count + ".\n");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n*************************");
        System.out.println("String Operations");
        System.out.println("*************************");

        System.out.println("Enter string 1:");
        String str1 = scan.nextLine();

        System.out.println("Enter string 2:");
        String str2 = scan.nextLine();

        System.out.println("*************************");
        System.out.println("Concatenation of \"" + str1 + "\" and \"" + str2 + "\"");
        concatStr(str1, str2);

        System.out.println("*************************");
        System.out.println("Trimming of \"" + str1 + "\"\n");

        System.out.println("Enter position to trim until:");
        int position = scan.nextInt();
        trimStr(str1, position);

        System.out.println("*************************");
        System.out.println("Counting the number of vowels in \"" + str1 + "\"");
        vowelStr(str1);

        System.out.println("*************************");
        System.out.println("Thank you. Exiting...\n");

        scan.close();
    }
}