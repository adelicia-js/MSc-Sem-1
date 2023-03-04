/*-------------------------------------------------------------------------------
                                QueueOperations.java
        This program implements insertion and deletion operations on a queue.
                    
@author Adelicia
@date   10/11/22
-------------------------------------------------------------------------------*/

package DAA;

import java.util.Scanner;
import java.util.ArrayList;

public class QueueOperations {

    public static ArrayList<Integer> queue = new ArrayList<>();
    // An array list is used to store values of queue

    public static String spacingLine = "*****************************";

    private static void insertOp(int element) {
        // Function/Method to perform an Enqueue operation on a stack,
        // i.e., inserting an element into the queue

        System.out.println("\nEnqueueing/Insertion Operation\n");

        queue.add(element);
        // Using ArrayList.add() to enqueue an element

        printQueue();
    }

    private static void deleteOp() throws Exception {
        // Function/Method to perform a Dequeue operation,
        // i.e, deleting an element from the queue
        System.out.println("Dequeueing/Deletion Operation\n");

        int delElement = 0;
        // Initializing element to be dequeued

        if (queue.isEmpty()) { // If the queue is empty, an exception is thrown
            throw new Exception("Queue is empty!\n");
        }
        else {
            delElement = queue.get(0);
            // Using ArrayList.get, element at the first position of stack is assigned to
            // delElement
            queue.remove(0);
            // Using ArrayList.remove, first element is dequeued (FIFO)

            System.out.println("The dequeued/deleted element is " + delElement + "!\n");
        }

        printQueue();
    }

    private static void peekOp() throws Exception {
        // Function/Method to print the first element of the queue

        if (queue.isEmpty()) { // If the queue is empty, an exception is thrown
            throw new Exception("Queue is empty!\n");
        }
        else {
            System.out.println("Peeking Operation\n");
            System.out.println("The first element of the queue is " + queue.get(0) + "!");
        }

    }

    private static void printQueue() {
        // Function/Method to print the queue after every enqueue/dequeue operation

        System.out.println("The current queue is\n");
        System.out.println(queue.toString());

    }

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        int choice = 0;

        do {

            System.out.println(spacingLine + "\nQueue Operations");

            System.out.println("\n1. Insert");
            System.out.println("\n2. Delete");
            System.out.println("\n3. Peek");
            System.out.println("\n4. Exit");

            System.out.println("\nEnter your choice(1/2/3/4):");
            choice = scan.nextInt();

            System.out.println(spacingLine);

            if (choice == 1) {
                System.out.println("Enter number to insert in the queue:");
                insertOp(scan.nextInt());
            }

            else if (choice == 2) {
                deleteOp();
            }

            else if (choice == 3) {
                peekOp();
            }

            else if (choice == 4) {
                System.out.println("Thank you. Exiting...\n" + spacingLine);
            }

            else {
                System.out.println("Invalid input. Please only enter 1/2/3.");
            }

        } while (choice != 4);

        scan.close();
    }

}