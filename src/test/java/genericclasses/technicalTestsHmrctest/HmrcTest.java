package genericclasses.technicalTestsHmrctest;

import org.junit.Test;

public class HmrcTest {

    @Test
    public void testHmrc() throws Exception {
        Thread t = new Thread(new Question2());
        t.start();
        System.out.println("Started");
        t.join();
        System.out.println("Complete");
    }

    @Test
    public void testHmrcTwo(){
        Question3 q1 = new Question3();
        Question3 q2 = new Question3();
        Question3 q3 = q1.go(q2);
        q1 = null;

        System.out.println("q3 value: " + q3);
        System.out.println("q1 value: " + q1);
        System.out.println("q2 value: " + q2);
    }
}
