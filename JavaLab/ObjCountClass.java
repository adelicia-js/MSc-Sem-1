/* ************************************************************************************************
                                    ObjCountClass.java
This program counts the number of objects created in a class, and also passes objects as arguments.
Also implements constructor overloading.

(?)Skeleton for a UI to input employee details into

@author Adelicia
@date 06/11/22
*********************************************************************************************** */
package JavaLab;

public final class ObjCountClass {

    String name = "urmom"; // Employee Name
    String empID; // Employee ID
    int exp; // Employee's year of experience in company

    static int counter = 0; // Initializing a counter to count the number of times an object is created

    ObjCountClass() { // No argument/Default constructor

        counter++;

        System.out.println("\nInvalid inputs, please provide details");
        System.out.println("***********************************");
    }

    ObjCountClass(String name) { // Parametrized Constructor (single argument)

        this.name = name; // this.name refers to the argument passed through object e2
        counter++;

        // System.out.println(name); - to test out the functionality of 'this'
        System.out.println("\nNot enough details! Please also provide employee ID and years of experience.");
        System.out.println("***********************************");
    }

    ObjCountClass(String name, String empID) { // Parametrized Constructor (double arguments)

        this.name = name;
        this.empID = empID;
        counter++;

        System.out.println("\nNot enough details! Please also provide years of experience.");
        System.out.println("***********************************");
    }

    ObjCountClass(String name, String empID, int exp) { // Parametrized Constructor (triple arguments)

        this.name = name;
        this.empID = empID;
        this.exp = exp;
        counter++;

        System.out.println("\nDetails are valid.");
        System.out.println("***********************************");
    }

    ObjCountClass(ObjCountClass obj) { // Parametrized Constructor (single object argument)

        counter++;

        System.out.println("\nSuccessfully input details");
        System.out.println("***********************************");
    }

    ObjCountClass(boolean choice) { // Parametrized Constructor which accepts a boolean argument

        counter++;

        System.out.println("\nThe count of objects created in this program are: " + counter);
        System.out.println("***********************************");
    }

    private void endCount(ObjCountClass obj1, ObjCountClass obj2, ObjCountClass obj3, ObjCountClass obj4,
            ObjCountClass obj5, ObjCountClass obj6) {
        // Function/Method which accepts multiple objects as arguments
        System.out.println("\nThank you. Exiting....");
        System.out.println("***********************************\n");
    }

    public static void main(String[] args) {

        System.out.println("\nPlease provide employee details");
        System.out.println("***********************************");

        ObjCountClass e1 = new ObjCountClass();

        ObjCountClass e2 = new ObjCountClass("Adelicia Sequeira");

        ObjCountClass e3 = new ObjCountClass("Adelicia Sequeira", "103041203679");

        ObjCountClass e4 = new ObjCountClass("Adelicia Sequeira", "103041203679", 2);

        ObjCountClass e5 = new ObjCountClass(e4);

        ObjCountClass e6 = new ObjCountClass(true);

        e6.endCount(e1, e2, e3, e4, e5, e6);
    }
}