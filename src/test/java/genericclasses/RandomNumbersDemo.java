package genericclasses;

import net.bytebuddy.description.type.TypeDescription;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RandomNumbersDemo {
    // The java.util.Random class is used to generate pseudo-random numbers.
    // Java Random class objects are thread-safe. The instances of this class however are cryptographically insecure.
    // This class provides various methods to generate different random numbers of types such as float, double, int.
    @Test
    public void testingRandomNumber(){
        // doubles() method
        //The doubles() method returns an unlimited stream of pseudo random double values,
        // each between zero (inclusive) and one (exclusive).
        Random random = new Random();
        DoubleStream doubleStream = random.doubles();
        System.out.println("Count: " + doubleStream.count());
        //doubleStream.forEach(x -> System.out.println(x));   //Keeps printing unlimited random numbers of double type in the console.
    }

    @Test
    public void testingRandomNumberTwo(){
        // ints() method
        //The ints() method returns an unlimited stream of pseudo random int values.
        Random random = new Random();
        IntStream intStream = random.ints();
        intStream.limit(10).forEach(System.out::println);  //Restricting the unlimited stream to print 10 random numbers only.
    }

    @Test
    public void testingRandomNumberThree(){
        // longs() method
        //The longs() method returns an unlimited stream of pseudo random long values.
        Random random = new Random();
        LongStream longStream = random.longs();
        longStream.forEach(x -> System.out.println(x));  //Prints unlimited random numbers of long type.
    }

    @Test
    public void testingRandomNumberFour(){
        // nextInt()
        //The nextInt() generates the next pseudo random, uniformly distributed int value from this random number generator’s sequence.
        Random random = new Random();
        int num = random.nextInt();
        System.out.println(num);

        // nextInt(int bound)
        //The nextInt(int bound) returns a pseudo random, uniformly distributed int value between 0 (inclusive) and
        // the specified value (exclusive), drawn from this random number generator’s sequence.
        //bound - the upper bound (exclusive). Must be positive.
        //It returns the next pseudo random, uniformly distributed int value between zero (inclusive) and
        //bound (exclusive) from this random number generator's sequence.
        //The method throws IllegalArgumentException - if bound is not positive.
        System.out.println();
        int num2 = random.nextInt(99999);
        System.out.println("Random number with bound set to 99999: " + num2);
        System.out.println();
        System.out.print("Bound 2: ");
        int num3 = random.nextInt(2);
        System.out.println(num3);
        System.out.println();
        int num4 = (1 + random.nextInt(2)) * 10000;
        System.out.println("1+random.nextInt(2) * 10000: " + num4);
    }

    @Test
    public void testingRandomNumberFive(){
        //Pseudo Random Number Generator (PRNG)
        //Pseudo Random Number Generator(PRNG) refers to an algorithm that uses mathematical formulas to
        //produce sequences of random numbers. PRNGs generate a sequence of numbers approximating the properties of random numbers.
        //A PRNG starts from an arbitrary starting state using a seed state. Many numbers are generated in
        //a short time and can also be reproduced later, if the starting point in the sequence is known.
        //Hence, the numbers are deterministic and efficient.
        //It is not possible to generate truly random numbers from deterministic things like computers, so PRNG is a technique developed to generate random numbers using a computer.
        //We generate the next random integer using the previous random integer, the integer constants,
        //and the integer modulus. To get started, the algorithm requires an initial Seed, which must be provided by some means.

        Random random = new Random(11);  //One way of setting up a Seed.
        IntStream intStream = random.ints(23, 26);  //Prints unlimited stream of random int between 23 and 26 exclusive.
        System.out.println(intStream.count());
        int seed = 10;
        random.setSeed(seed);   //Setting up a Seed.
        System.out.println(random.nextInt());
    }

    @Test
    public void testingRandomNumberSix(){
        Random random = new Random();
        //Display 10 random numbers of type int.
        for (int i = 0; i < 10; i++){
            System.out.println("Random number: " + random.nextInt(6));  //Random numbers between 0 and 6 exclusive.
        }
    }

    @Test
    public void testingRandomNumberSeven(){
        //ints(long streamSize, int randomNumberOrigin, int randomNumberBound)
        //This method is used to generate a stream of pseudorandom integer values, which is of the specified size.
        //The specified size is bounded by a lower bound (inclusive) and an upper bound (exclusive).
        //Parameters *******
        //streamSize: This is the size of the stream that needs to be generated.
        //randomNumberOrigin: This is the lower bound (inclusive) for each generated value.
        //randomNumberBound: This is the upper bound (exclusive) for each generated value.
        Random random = new Random();
        IntStream intStream = random.ints(10, 500, 600);
        intStream.forEach(System.out::println);
    }

    @Test
    public void testingRandomNumberEight(){
        //ints(int randomNumberOrigin, int randomNumberBound)
        //This method is used to generate an infinite stream of pseudorandom integer values,
        //each of which adheres to the provided lower bound (inclusive) and upper bound (exclusive).
        //Parameters ******
        //randomNumberOrigin: This is the lower bound (inclusive) for each generated value.
        //randomNumberBound: This is the upper bound (exclusive) for each generated value.
        Random random = new Random();
        IntStream intStream = random.ints(300, 350);
        intStream.limit(10).forEach(x -> System.out.print(x + " "));
    }

    @Test
    public void testingRandomNumberGenerator(){
        Random rdn = new Random(System.currentTimeMillis());  //Setting the Seed to the current system time.

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
        // from 0 to 999999 exclusive
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

    @Test
    public void testSecureRandom(){
        SecureRandom rands = new SecureRandom();
        //For generating int values we can pass an "upper bound" as a parameter:
        // Generate random integers in range 0 to 999
        int randomNumber1 = rands.nextInt(1000);
        int randomNumber2 = rands.nextInt(1000);

        System.out.println("Random number 1 is: " + randomNumber1);
        System.out.println("Random number 2 is: " + randomNumber2);
        System.out.println();

        //The most common way of using SecureRandom is to generate int, long, float, double or boolean values:
        SecureRandom secureRandom = new SecureRandom();

        int randomInt = secureRandom.nextInt();
        double randomDouble = secureRandom.nextDouble();
        long randomLong = secureRandom.nextLong();
        float randomFloat = secureRandom.nextFloat();
        boolean randomBoolean = secureRandom.nextBoolean();

        System.out.println("integer Random number is: " + randomInt);
        System.out.println("double Random number is: " + randomDouble);
        System.out.println("long Random number is: " + randomLong);
        System.out.println("float Random number is: " + randomFloat);
        System.out.println("boolean Random number is " + randomBoolean);
        System.out.println();

        //In addition, we can generate a stream of values for int, double and long:
        //for all the streams we can explicitly set the size, if we do not we get endless random numbers.
        IntStream randomIntStream = secureRandom.ints(10);
        randomIntStream.forEach(number -> System.out.println(number));
    }

    @Test
    public void moreSecureRandomTests(){
        //For all streams we can explicitly set the stream size, and the origin (inclusive) and bound (exclusive) values as well
        SecureRandom secureRandom = new SecureRandom();
        int streamSize = 10;
        int originValue = 311;
        int boundValue = 333;
        IntStream intStream = secureRandom.ints(streamSize, originValue, boundValue);
        System.out.println("intStream with Stream size, origin value, and bound value : ");
        intStream.forEach(number -> System.out.println(number));

        //We can change the seed by passing it as a constructor parameter:
    }


}
