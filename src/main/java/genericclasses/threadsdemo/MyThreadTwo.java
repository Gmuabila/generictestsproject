package genericclasses.threadsdemo;

public class MyThreadTwo implements Runnable{
    @Override
    public void run() {
        System.out.println("This code is also running in a thread...");
    }
}
