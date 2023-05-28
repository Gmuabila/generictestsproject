package genericclasses.SpringIoc;

import genericclasses.SpringIoc.generic.Company;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;

public class SpingIocContainerTests {

   // Since we defined beans in a configuration class, we'll need an instance of the AnnotationConfigApplicationContext class to build up a container:

    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

  //  A quick test verifies the existence and the property values of our beans:
    Company company = context.getBean("company", Company.class);

    @Test
public void testingSpringIocContainer() {

    assertEquals("High Street", company.getAddress().getStreet());
    assertEquals(1000, company.getAddress().getNumber());
    //The result proves that the IoC container has created and initialized beans correctly.
}

}
