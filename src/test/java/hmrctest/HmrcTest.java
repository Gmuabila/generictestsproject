package hmrctest;

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
}
