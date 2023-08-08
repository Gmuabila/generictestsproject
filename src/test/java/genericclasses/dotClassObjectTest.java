package genericclasses;

import com.gettingstarted.domain.modernaccount.ModernAccount;
import genericclasses.streamdemo.City;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class dotClassObjectTest {

    @Test
    public void testingDotClass(){
        //getClass()
        //The getClass method returns the class object of “this” object and is used to get the actual runtime class of the object.
        //It can also be used to get metadata of this class. The returned Class object is the object that is locked by
        //static synchronized methods of the represented class. As it is final so we don’t override it.
        //
        //Class getName() Method
        //The getName() method of java Class class is used to get the name of the entity,
        //and that entity can be class, interface, array, enum, method, etc. of the class object.

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

    @Test
    public void testingDotClassTwo(){
        ModernAccount modernAccount = new ModernAccount();
        Class modernAccClass = modernAccount.getClass();
        String className = modernAccClass.getSimpleName();
        System.out.println("The class name is: " + className);
        System.out.println();
        String packageName = modernAccClass.getPackageName();
        System.out.println("The Package name is: " + packageName);
        System.out.println();

        City city = new City();
        Class cityClass = city.getClass();
        String classCity = cityClass.getSimpleName();
        System.out.println("The City class name is: " + classCity);
    }

    public Object createNewInstanceOf(Object obj) throws InstantiationException, IllegalAccessException {
        return obj.getClass().newInstance();
    }

    @Test
    public void testingDotClassThree() throws InstantiationException, IllegalAccessException {
        //One handy use of the getClass method is to create a new instance of a class without knowing what the class is at compile time.
        //This sample method creates a new instance of the same class as obj which can be any class that inherits from
        //Object (which means that it could be any class):
        Object objTwo = new String("ClassTime");
        Object newObj = createNewInstanceOf(objTwo);
        System.out.println("The class of the new Object is: " + newObj.getClass().getName());
        System.out.println("The new instance value is: " + newObj);
    }
}
