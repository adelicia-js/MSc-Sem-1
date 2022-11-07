/* ************************************************************************************************
                                    PwdValid.java
This program validates an inputted password, based on the conditions:
(a) Length >= 8
(b) At least one uppercase letter
(c) At least one lowercase letter
(d) At least one digit
(e) At least one special character (@/#/$/*)

(?)Skeleton for a registration form

@author Adelicia
@date 06/11/22
*********************************************************************************************** */
package JavaLab;

import java.util.Scanner;

public class PwdValid {

    private static boolean validatorPwd(String pwd) {
    // Function/Method to validate the entered password
    // Uses in-built methods of 'char isUpperCase()', 'char isLowerCase()', 'char isDigit()' & 'char charAt()'

        int length=pwd.length();
        int minLength=8; // Minimum length has to be of 8 characters
        
        int upperCase=0; // uppercase = 1 if there is at least one uppercase letter

        int lowerCase=0; // lowercase = 1 if there is at least one lowercase letter
        
        int digit=0; // digit = 1 if there is at least one digit

        int specialChar=0; // specialCh = 1 if there is at least one special character (@/#/$/*)

        int ind; // stores indices of the password string, used to iteratively check for the above conditions
        boolean result=false; // result = true if password satisfies all the above mentioned conditions

        if(length>=minLength) { //Directly returns 'false' if length condition itself is not satisfied

            for(ind=0;ind<length;ind++) {

                char ch = pwd.charAt(ind);

                if(Character.isUpperCase(ch)) {
                    upperCase = 1;
                }

                if(Character.isLowerCase(ch)) {
                    lowerCase = 1;
                }

                if(Character.isDigit(ch)) {
                    digit = 1;
                }

                if(ch=='@'||ch=='#'||ch=='$'||ch=='*') {
                    specialChar = 1;
                }
            }

            if(upperCase==1 && lowerCase==1 && digit==1 && specialChar==1) {
                result = true; // Password has satisfied all conditions
            }

            else {
                result = false; // Password did not satisfy at least one condition
            }
        }

        else { // Length of password is < 8
            result = false; 
        }
        return result;
    }

    private static void regSuccess(String uName, String pwd) {
        System.out.println("Registration successful, "+uName+"!"+"\nThank you for registering.");
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        System.out.println("***********************");
        System.out.println("Registration Form");
        System.out.println("***********************\n");

        System.out.println("Enter your user name:\n");
        String name = scan.nextLine();
        System.out.println("***********************\n");

        System.out.println("Enter your password:");
        System.out.println("Please note your password should follow these conditions:\n");
        System.out.println("1. At least 8 characters");
        System.out.println("2. At least 1 uppercase letter");
        System.out.println("3. At least one lowercase letter");
        System.out.println("4. At least one digit");
        System.out.println("5. At least one special character (@/#/$/*)\n");

        String pass = scan.nextLine();
        System.out.println("***********************");

        if(validatorPwd(pass)) {
            regSuccess(name,pass);
            System.out.println("***********************");
        }
        else {
            System.out.println("\nPlease enter a valid password and try again.");
            System.out.println("***********************");
        }
        scan.close();
    }
}
