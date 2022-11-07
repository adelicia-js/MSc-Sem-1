/* ******************************************************************************************
                                    StringOps2.java
This program carries out the string operations of:
(a) Checking if a string is an anagram
(b) Checking if a string is a pangram

@author Adelicia
@date 05/11/22
******************************************************************************************** */
package JavaLab;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;

public final class StringOps2 {
    
    private static void anagramStr(String sen1, String sen2) {
        // Function/method to check if a string 2 is an anagram of string 1

        if(sen1.length()==sen2.length()) {

            //converting both strings to character arrays and sorting both arrays
            char array1[] = sen1.toCharArray();
            Arrays.sort(array1); 

            char array2[] = sen2.toCharArray();
            Arrays.sort(array2);

            //comparing if the two character arrays are equivalent
            boolean result = Arrays.equals(array1, array2);

            if(result) {
                System.out.println("\""+sen1+"\" and \""+sen2+"\" are anagrams.");
            }
            else {
                System.out.println("\""+sen1+"\" and \""+sen2+"\" are not anagrams.");
            }
        }        
        else {
            System.out.println("\""+sen1+"\" and \""+sen2+"\" are not anagrams.");
        }
    }

    private static void pangramStr(String sen1) {
        // Function/Method to check if string 1 is a pangram
        // In-built methods of 'char charAt()' and 'int length()' used

        // A counter is initialized to check if there is an occurence of every character 
        //from the English Alphabet in the string
        int count=0;
        
        // In terms of ASCII values, 97 is the character 'a' and 122 is the character 'z'
        for (int i=7; i<=122; i++) { 
            for(int j=0; j<sen1.length(); j++) {
                if(sen1.charAt(j)==(char)i) {
                    count++; // The counter increments every time a character from the Alphabet
                            // is found in the string
                    break;
                }
            }
        }
        if(count==26) {
            System.out.println("\""+sen1+"\" is a pangram.");
        }
        else {
            System.out.println("\""+sen1+"\" is not a pangram.");
        }
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
        System.out.println("Checking if \""+str2+"\" is an anagram of \""+str1+"\"\n");
        anagramStr(str1,str2);

        System.out.println("*************************");
        System.out.println("Checking if \""+str1+"\" is a pangram\n");
        pangramStr(str1);

        System.out.println("*************************");
        System.out.println("Thank you. Exiting...\n");

        scan.close();
    }
}