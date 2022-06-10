package genericclasses;

import org.junit.Test;

import java.util.Random;

public class RandomNumbersDemo {

    @Test
    public void testingRandomNumberGenerator(){
        Random rdn = new Random(System.currentTimeMillis());

        // The idea is that 1 + nextInt(2) shall always give 1 or 2.
        // You then multiply it by 10000 to satisfy your requirement and
        // then add a number between [0..9999].
        System.out.println((1 + rdn.nextInt(2)) * 10000 + rdn.nextInt(10000));
    }
    @Test
    public void testingRandomNumberGeneratorTwo(){
        Random random = new Random();
        //It generates boolean value
        System.out.println(random.nextBoolean());
        //It generates double value
        System.out.println(random.nextDouble());
        //It generates float value
        System.out.println(random.nextFloat());
        //It generates int value
        System.out.println(random.nextInt());
        //It generates int value within specific limit
        System.out.println(random.nextInt(50));
    }

    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        //But you will get numbers such as 000127.
        return String.format("%06d", number);
    }
    @Test
    public void testingTheAbove(){
        System.out.println(getRandomNumberString());
    }
}
