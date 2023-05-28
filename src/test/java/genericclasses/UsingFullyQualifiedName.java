package genericclasses;

import org.junit.Test;

public class UsingFullyQualifiedName {

    @Test
    public void UsingFullyQualifiedNameDemo(){
        /*Using fully qualified name
        If you use fully qualified name then only declared class of this package will be accessible.
        Now there is no need to import. But you need to use fully qualified name every time when you are accessing the class or interface.
        It is generally used when two packages have same class name e.g., java.util and java.sql packages contain Date class. */

        com.gettingstarted.domain.animal.Cat cat1 = new com.gettingstarted.domain.animal.Cat();
        cat1.setName("Yocat");
        cat1.setAge(2);
        cat1.setOwner("Joe Mike");

        System.out.println("Printing Cat Yocat: " + cat1);

    }
}
