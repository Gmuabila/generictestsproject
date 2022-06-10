package genericclasses.loosecouplingdemo;

import org.junit.Test;

public class looseCouplingTests {

    @Test
    public void looseCouplingTestings(){
        Topic t1 = new Topic1();
        t1.understand();

        Topic t2 = new Topic2();
        t2.understand();

    }
}
