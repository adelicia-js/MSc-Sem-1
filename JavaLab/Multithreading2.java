/*-------------------------------------------------------------------------
Multithreading.java
This program implements multithreading. 
First thread generates a random number.
Second thread prints the square of the even number if the integer is even.
Third thread prints the cube of that number if the number is odd.
           
@author Adelicia Sequeira
@date   11/11/22
-------------------------------------------------------------------------*/

package JavaLab;

import java.util.Random;

// Class for creating a random number
class RdmThd implements Runnable {
    Thread t;
    Random rdmGen;
    public static int value;

    RdmThd() {
        // creates a thread when a RdmThd object is created, aka, thread in new state
        t = new Thread(this);
        rdmGen = new Random();
    }

    public void run() {
        value = rdmGen.nextInt();
        System.out.println("The random number is: " + value);
    }
}

// Class for creating thread for determining if the number is even or not 
// and if so printing it's square
class Even implements Runnable {
    Thread t;

    Even() {
        // creates a thread when a Even object is created, i.e., thread in new state
        t = new Thread(this);
    }

    public void run() {
        if (RdmThd.value % 2 == 0) {
            System.out.println("The random number is even and it's square is " + Math.pow(RdmThd.value, 2));
        }
    }
}

// Class for creating thread for determining if the number is odd,
// and if odd, it prints its cube
class Odd implements Runnable {
    Thread t;

    Odd() {
        // creates a thread when a Odd object is created, i.e., thread in new state
        t = new Thread(this);
    }

    public void run() {
        if (RdmThd.value % 2 != 0) {
            System.out.println("The random number is odd and it's cube is " + Math.pow(RdmThd.value, 3));
        }
    }
}

// Driver class
class MultiThreading2 {
    public static void main(String[] args) {
        RdmThd thread1 = new RdmThd();
        Even thread2 = new Even();
        Odd thread3 = new Odd();
        thread1.t.start();
        thread2.t.start();
        thread3.t.start();
    }
}