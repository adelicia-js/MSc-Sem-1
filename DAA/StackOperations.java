/*----------------------------------------------------------------------------
                                StackOperations.java
        This program implements push and pop operations on a stack.
                    
@author Adelicia
@date   10/11/22
-----------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.ArrayList;

public class StackOperations {

    public static ArrayList<Integer> stack = new ArrayList<>();
    // An array list is used to store values of stack

    public static String spacingLine = "*****************************";

    private static void pushOp(int ele) {
        // Function/Method to perform a Push operation on a stack,
        // i.e., appending an element to the stack

        System.out.println("\nPush Operation\n");

        stack.add(ele);
        // Using ArrayList.add() to push an element to the stack

        printStack();

    }

    private static void popOp() throws Exception {
        // Function/Method to perform a Pop operation,
        // i.e, removing an element to the stack

        int popElement = 0;
        // Initializing element to be popped from the stack

        if (stack.isEmpty()) { // If the stack is empty, an exception is thrown

            throw new Exception("Stack is empty!\n");

        }

        System.out.println("Pop Operation\n");

        popElement = stack.get(stack.size() - 1);
        // Using ArrayList.get, element at the last position of stack is assigned to
        // popElement
        stack.remove(stack.size() - 1);
        // Using ArrayList.remove, last element is popped from the stack (LIFO)

        System.out.println("Popped element is " + popElement + "!\n");

        printStack();

    }

    private static void printStack() {
        // Function/Method to print the stack after every push/pop operation

        System.out.println("The current stack is\n");
        System.out.println(stack.toString());

    }

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        int choice = 0;

        do {
            System.out.println(spacingLine + "\nStack Operations");
            System.out.println("\n1. Push");
            System.out.println("\n2. Pop");
            System.out.println("\n3. Exit");
            System.out.println("\nEnter your choice(1/2/3):");
            choice = scan.nextInt();

            System.out.println(spacingLine);

            if (choice == 1) {
                System.out.println("Enter number to push to stack:");
                pushOp(scan.nextInt());
            }

            else if (choice == 2) {
                popOp();
            }

            else if (choice == 3) {
                System.out.println("Thank you. Exiting...\n" + spacingLine);
            }

            else {
                System.out.println("Invalid input. Please only enter 1/2/3.");
            }

        } while (choice != 3);

        scan.close();

    }

}