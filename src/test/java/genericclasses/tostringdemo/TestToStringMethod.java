package genericclasses.tostringdemo;

import com.gettingstarted.domain.modernaccount.ModernAccount;
import genericclasses.extendskeyworddemo.City;
import genericclasses.extendskeyworddemo.Country;
import genericclasses.superkeyworddemo.Dog;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TestToStringMethod {

    @Test
    public void testingWithoutToStringMethod(){

        Dog tony = new Dog();
        tony.setColor("Blue");
        Dog rambo = Dog.builder().color("Red").build();

        ModernAccount firstAccount = ModernAccount.builder()
                .id("99700127")
                .name("Mark Toy")
                .balance(new BigDecimal(1900))
                .build();

//        ModernAccount firstAccount = new ModernAccount("359966", "Johnny", new BigDecimal(600500));

        System.out.println("Dog 'Tony' Superclass colour is: " + tony.getSuperColorValue());
        System.out.println("Dog Rambo Superclass colour is: " + rambo.getSuperColorValue());
        System.out.println("Rambo colour is: " + rambo.getColor());
        System.out.println("Tony colour is: " + tony.getColor());
        System.out.println("\nPrinting object Tony without ToString Method: " + tony);
        System.out.println("\nPrinting object Rambo without ToString Method: " + rambo);

        System.out.println(firstAccount);
        System.out.println("firstAccount object Hash value is: " + firstAccount.hashCode());
    }

    @Test
    public void testPrintObjectWithDefinedToStringMethod(){

        Dog rifle = new Dog();
        rifle.setColor("Orange");
        Dog king = Dog.builder().color("Pink").build();

        ModernAccount secondAccount = ModernAccount.builder()
                .id("997111335")
                .name("Denise Blond")
                .balance(new BigDecimal(250000))
                .build();

       // ModernAccount secondAccount = new ModernAccount("555988909", "John Watts", new BigDecimal(1000090));

        System.out.println("Dog 'Rifle' Superclass colour is: " + rifle.getSuperColorValue());
        System.out.println("Dog Rambo Superclass colour is: " + king.getSuperColorValue());
        System.out.println("Rifle colour is: " + rifle.getColor());
        System.out.println("King colour is: " + king.getColor());
        System.out.println("\nPrinting object Rifle without ToString Method: " + rifle);
        System.out.println("\nPrinting object King without ToString Method: " + king);

        System.out.println(secondAccount);
        System.out.println("SecondAccount object Hash value is: " + secondAccount.hashCode());


    }

    @Test
    public void testDisplayObjectWithoutToStringMethod(){
        Country country = new Country();
        country.setName("John Taylor");
        System.out.println(country);


    }
}
