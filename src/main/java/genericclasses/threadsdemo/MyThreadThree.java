package genericclasses.threadsdemo;

public class MyThreadThree extends Thread {
    public static int amount = 0;

    @Override
    public void run() {
        amount++;
        System.out.println("Amount in thread is: " + amount);
    }

    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        MyThreadThree.amount = amount;
    }
}
