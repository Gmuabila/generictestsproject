package genericclasses.mutableobjectdemo;

import org.junit.Test;

public class MutableObjectDemo {

    @Test
    public void testMutableObject(){
        CourseExample obj = new CourseExample("Training Day");
        System.out.println(obj.getCourse());
        System.out.println(obj.hashCode()); //Hashcode of the object
        System.out.println();

        //Setting the name of the Course after the String object has already been initialised using the set method
        obj.setCourse("Due day");  //Note: The String is reset but another string will be created in Heap memory as Strings are immutable.
        System.out.println("After setting string: ");
        System.out.println(obj.getCourse());
        System.out.println(obj.hashCode()); // Hashcode of the object not the String hashcode
    }

    @Test
    public void testImmutableObject(){
        CourseExampleTwo obj2 = new CourseExampleTwo("Core Training");
        System.out.println(obj2.getCourse());  //Object obj2 is immutable, cannot be changed.  You cannot set values of the fields.
    }

    @Test
    public void testImmutablePrimitiveTypes(){
        int x = 21;
        long l = 333;
        float f = 45.19f;
        double d = 388.48d;

        System.out.println("int x = " + x);
        System.out.println("long l = " + l);
        System.out.println("float x = " + f);
        System.out.println("double x = " + d);

        x = 10;
        l = 444;
        f = 11.11f;
        d = 555.01d;

        System.out.println("\nAfter assigning new values to promitive variables: ");
        System.out.println("int x = " + x);
        System.out.println("long l = " + l);
        System.out.println("float x = " + f);
        System.out.println("double x = " + d);

        //Values of all primitive variable have been changed to new values assigned,
        // but unable to confirm whether the values have changed in memory location or
        // new values and new memory location has been created.
        // Unable to confirm this with hascode method as only object get hashcode value.
    }

    @Test
    public void testImmutableWrapperClasses(){
        Integer i = 20;
        Long j = 777L;
        Float fl = 299.7F;
        Double db = 5777.44D;
        Character ch = 'a';

        System.out.println("Integer wrapper value is: " + i + "\tHascode is: " + i.hashCode());
        System.out.println("Long wrapper value is: " + j + "\tHascode is: " + j.hashCode());
        System.out.println("Float wrapper value is: " + fl + "\tHascode is: " + fl.hashCode());
        System.out.println("Double wrapper value is: " + db + "\tHascode is: " + db.hashCode());
        System.out.println("Character wrapper value is: " + ch + "\tHascode is: " + ch.hashCode());
        System.out.println();

        i = 177;
        j = 19990L;
        fl = 111.10F;
        db = 887.23D;
        ch = 'b';

        System.out.println("After changing the values of all wrapper classes objects:");
        System.out.println("Integer value becomes: " + i + "\tHashcode is: " + i.hashCode());
        System.out.println("Long value becomes: " + j + "\tHashcode is: " + j.hashCode());
        System.out.println("Float value becomes: " + fl + "\tHashcode is: " + fl.hashCode());
        System.out.println("Double value becomes: " + db + "\tHashcode is: " + db.hashCode());
        System.out.println("Character value becomes: " + ch + "\tHashcode is: " + ch.hashCode());

        //Test confirms hascodes are not the same, meaning that new objects have been created
        //Values in wrapper objects cannot be changed
        //Wrapper class objects are immutable
    }


}
