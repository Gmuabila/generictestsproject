package storm;

import org.junit.Test;

public class StormTwoTest {
    @Test
    public void testSnowStorm(){
        //Testing class before any changes made
        SnowStorm snowStorm = new SnowStorm(2.1, 3.2, 4.1, 3.5);
        System.out.println(snowStorm);
        System.out.println();
        boolean boo = snowStorm.isInEyeOfTheStorm(2, 3);
        System.out.println("isInEyeOfTheStorm returns: " + boo);
        //Output:
        //SnowStorm{eyeRadius=2.1, eyePositionX=3.2, eyePositionY=4.1, amountOfSnow=3.5}
        //isInEyeOfTheStorm returns: true

        System.out.println();
        SnowStorm snowStorm1 = new SnowStorm(1.1, 2.4, 1.2, 3.1);
        System.out.println(snowStorm1);
        System.out.println();
        boolean boo2 = snowStorm1.isInEyeOfTheStorm(2.3, 1.4);
        System.out.println("isInEyeOfTheStorm returns: " + boo2);
        //Output:
        //SnowStorm{eyeRadius=1.1, eyePositionX=2.4, eyePositionY=1.2, amountOfSnow=3.1}
        //isInEyeOfTheStorm returns: true

        ////// Test After changes //////////////////////////////////////////////////////////////////////////////////////

        //Output:
        //SnowStorm{eyeRadius=2.1, eyePositionX=3.2, eyePositionY=4.1, amountOfSnow=3.5}
        //isInEyeOfTheStorm returns: true
        //
        //SnowStorm{eyeRadius=1.1, eyePositionX=2.4, eyePositionY=1.2, amountOfSnow=3.1}
        //isInEyeOfTheStorm returns: true
    }

    @Test
    public void testRainStorm(){
        RainStorm rainStorm = new RainStorm(2.1, 1.4, 2.1);
        System.out.println(rainStorm);
        System.out.println();
        boolean boo = rainStorm.isInEyeOfTheStorm(2.3, 1.5);
        System.out.println("isInEyeOfTheStorm returns: " + boo);
        System.out.println();
        //Output:
        //RainStorm{eyeRadius=2.1, eyePositionX=1.4, eyePositionY=2.1}
        //isInEyeOfTheStorm returns: true

        RainStorm rainStorm1 = new RainStorm(3.3, 2.7, 5.1);
        System.out.println(rainStorm1);
        System.out.println();
        boolean boo2 = rainStorm.isInEyeOfTheStorm(4.4, 3.6);
        System.out.println("isInEyeOfTheStorm returns: " + boo2);
        //Output:
        //RainStorm{eyeRadius=3.3, eyePositionX=2.7, eyePositionY=5.1}
        //isInEyeOfTheStorm returns: false

        ////// Test After changes //////////////////////////////////////////////////////////////////////////////////////

        //Output:
        //RainStorm{eyeRadius=2.1, eyePositionX=1.4, eyePositionY=2.1}
        //isInEyeOfTheStorm returns: true
        //
        //RainStorm{eyeRadius=3.3, eyePositionX=2.7, eyePositionY=5.1}
        //isInEyeOfTheStorm returns: false

    }
}
