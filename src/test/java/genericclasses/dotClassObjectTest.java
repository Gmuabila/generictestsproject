package genericclasses;

import com.gettingstarted.domain.modernaccount.ModernAccount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class dotClassObjectTest {

    @Test
    public void testingDotClass(){

        ModernAccount firstAccount = new ModernAccount("77599228881", "James Anton", new BigDecimal(5550000));

        assertEquals( new BigDecimal(5550000), firstAccount.getBalance());
        assertEquals("James Anton", firstAccount.getName());
        assertEquals("77599228881", firstAccount.getId());

        //When you write .class after a class name, it references the
        // class literal - "java.lang.Class" object that represents information about given class.
        //For example, if your class is Print, then Print.class is an object that represents the class Print at runtime.
        // It is the same object that is returned by the getClass() method of any (direct) instance of Print.
        System.out.println("The getClass method prints: " + firstAccount.getClass());
        System.out.println("The getClass dot getName prints: " + firstAccount.getClass().getName());
        System.out.println("The CLASSNAME dot class dot getName prints: " + ModernAccount.class.getName());

        String string = "Hello World";
        System.out.println("The String object dot getClass prints: " + string.getClass());
        System.out.println("The String object dot getClass dot getName prints: " + string.getClass().getName());
        System.out.println("String.class.getName prints: " + String.class.getName());
        System.out.println("String.class prints: " + String.class);
    }
}
