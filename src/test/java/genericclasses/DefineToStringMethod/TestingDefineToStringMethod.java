package genericclasses.DefineToStringMethod;

import org.junit.Test;

public class TestingDefineToStringMethod {
    @Test
    public void testDefineToStringMethod(){
            Student s1=new Student("John Taylor",770987,"London");
            Student s2=new Student("Calvin Fox",355559,"Manchester");

            System.out.println(s1);//compiler writes here s1.toString()
            System.out.println(s2);//compiler writes here s2.toString()
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());
        }
    }
