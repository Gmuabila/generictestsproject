package genericclasses.tostringdemo;

import com.gettingstarted.domain.modernanimal.ModernCat;
import org.junit.Test;

public class TestModernCatToStringMethod {

    @Test
    public void testingCatToStringMethod(){
        ModernCat catTony = ModernCat.builder()
                .name("TonyCat")
                .age(5)
                .owner("TonyCatOwner")
                .build();

        System.out.println(catTony);
        System.out.println("Object catTony Hashcode is: " + catTony.hashCode());

    }
}
