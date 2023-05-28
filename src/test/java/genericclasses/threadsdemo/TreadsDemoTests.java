package genericclasses.threadsdemo;

import org.junit.Test;

import static genericclasses.threadsdemo.MyThreadThree.amount;

public class TreadsDemoTests {
    //Threads
    //A thread in Java is the direction or path that is taken while a program is being executed. Generally,
    //all the programs have at least one thread, known as the main thread, that is provided by the JVM or
    //Java Virtual Machine at the starting of the program’s execution. At this point, when the main thread is provided,
    //the main() method is invoked by the main thread.  Threads allows a program to operate more efficiently by doing
    //multiple things at the same time.  Threads can be used to perform complicated tasks in the background without interrupting the main program.
    //
    //A thread is an execution thread in a program. Multiple threads of execution can be run concurrently by an
    //application running on the Java Virtual Machine. The priority of each thread varies. Higher priority threads are
    //executed before lower priority threads.  Thread is critical in the program because it enables multiple operations to
    //take place within a single method. Each thread in the program often has its own program counter, stack, and local variable.

    //There are two ways to creating a Thread
    //
    //Threads can be created by extending the Thread class and overriding its run() method.
    //In this case, a thread is created by a new class that extends the Thread class, creating an instance of that class.
    //The run() method includes the functionality that is supposed to be implemented by the Thread.
    @Test
    public void threadsTestOne(){
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("This code is running outside the Thread");
    }

    //Threads can be created by Implementing Runnable interface
    //Another way to create a thread is to implement the Runnable interface.
    //This is the easy method to create a thread among the two. In this case, a class is created to implement the runnable interface and
    //then the run() method.  The code for executing the Thread should always be written inside the run() method.
    @Test
    public void threadsTestTwo(){
        Thread myThreadTwo = new Thread(new MyThreadTwo());
        myThreadTwo.start();
        System.out.println("This code is running outside the thread");
    }

    //Concurrency Problems
    //Because threads run at the same time as other parts of the program, there is no way to know in which order the code will run.
    //When the threads and main program are reading and writing the same variables, the values are unpredictable.
    //The problems that result from this are called concurrency problems.
    @Test
    public void threadsTestThree(){
        //A code example where the value of the variable amount is unpredictable:
        MyThreadThree myThreadThree = new MyThreadThree();
        myThreadThree.start();
        System.out.println(myThreadThree.getAmount());
        myThreadThree.setAmount(myThreadThree.getAmount() + 1);
        System.out.println(myThreadThree.getAmount());
    }


}
