package genericclasses;

import org.junit.Test;

public class PolymorphismDemo {
    class Animal {
        String address = "123 Common Place";
        public void animalSound() {
            System.out.println("The animal makes a sound");
        }
        public void animalColour(){
            System.out.println("All animal are in blue colour");
        }
    }

    class Pig extends Animal {
        public void animalSound() {
            System.out.println("The pig says: wee wee");
        }
    }

    class Dog extends Animal {
        public void animalSound() {
            System.out.println("The dog says: bow wow");
        }
    }

    @Test
    public void testPolymorphism(){
        Animal myAnimal = new Animal();  // Create a Animal object
        Animal myPig = new Pig();  // Create a Pig object
        Animal myDog = new Dog();  // Create a Dog object
        myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound();
        System.out.println();

        Dog dog2 = new Dog();
        System.out.println("Instance of Dog Class:");
        dog2.animalSound();
        System.out.println();
        System.out.println("Super Class method not implemented in subclass");
        dog2.animalColour();
        System.out.println();
        System.out.println("Accessing Superclass attribute from subclass object");
        System.out.println(dog2.address);

    }

}
