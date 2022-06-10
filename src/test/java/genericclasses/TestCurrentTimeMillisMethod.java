package genericclasses;

import org.junit.Test;

import static java.lang.constant.ConstantDescs.NULL;

public class TestCurrentTimeMillisMethod {

    @Test
    public void testingCurrentTimeMillisMethod(){
        //The java.lang.System.currentTimeMillis() method returns the current time in milliseconds.
        // The unit of time of the return value is a millisecond, the granularity of the value depends on
        // the underlying operating system and may be larger.

        System.out.println(System.currentTimeMillis());
    }
}
