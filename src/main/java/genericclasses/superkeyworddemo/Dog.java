package genericclasses.superkeyworddemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Builder
    @Data
    @AllArgsConstructor
   //@NoArgsConstructor                                    //Removed Lombok Constructor to define below Constructor.
    public class Dog extends Animal {

                String color ="Black...for Subclass";

       public Dog() {                                       //Defining a Constructor with no arguments.  No need to call
            // super();                                     //Parent Class Constructor as it is called implicitly when
            System.out.println("Dog is created");           //Child class Constructor is called.  Both Parent and Child Objects will be created.
        }                                                   //Note: As we know well that default constructor is provided by compiler automatically if
                                                            //there is no constructor. But, it also adds super() as the first statement.
        public void printColor(){
            	System.out.println("Colour for Dog (Child Class) is: " + color);//prints color of Dog class
            	System.out.println("Colour for Animal (Parent Class) is: " + super.color);//prints color of Animal class.
                                                                // We can use "super" keyword to access the data member or field of parent class.
                                                                //It is used if parent class and child class have same fields.
            	}

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void eat() {
           System.out.println("Eating bread...From eat() Method in Subclass");
        }

        @Override
        public int getLegs() {
           return 4;
        }

        public void bark() {
           System.out.println("Barking...in Subclass");
        }

        public void work() {
            super.eat();   //The super keyword can also be used to invoke parent class method.
            bark();        // It should be used if subclass contains the same method as parent class.
            eat();         // In other words, it is used if method is overridden.
        }

        public String getSuperColorValue(){
           return super.getColor();
        }
	}


