package genericclasses.tightcouplingDemo;

import org.junit.Test;

public class TightCouplingDemoTest {

    @Test
    public void testTightCoupling(){
//        Topic topic = new Topic();
//        topic.understand();
        Subject s = new Subject();
        s.startReading();
    }
}
