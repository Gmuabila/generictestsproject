package genericclasses.singletonclassdemo;

//Singleton Class
//In object-oriented programming, a singleton class is a class that can have only one
//object (an instance of the class) at a time. After the first time, if we try to
//instantiate the Singleton class, the new variable also points to the first instance created.
//So whatever modifications we do to any variable inside the class through any instance,
//affects the variable of the single instance created and is visible if we access that
// variable through any variable of that class type defined.

// Java program implementing Singleton class
// with using getInstance() method
// Class 1
// Helper class
public class Singleton {
        // Static variable reference of single_instance
        // of type Singleton
        private static Singleton single_instance;  //If made non-static we get an error: Non-static field cannot be referenced from a static context.
        // Declaring a variable of type String
        public String s;
        // Constructor
        // Here we will be creating private constructor
        // restricted to this class itself
        private Singleton(){
            s = "Hello I am a string part of Singleton class";
        }
        // Static method
        // Static method to create instance of Singleton class
        public static Singleton getInstance(){
            // To ensure only one instance is created
            if (single_instance == null)           //The error above comes from this code as the variable inside a static method should be static as well.
                single_instance = new Singleton(); //hence, the error: Non-static field cannot be referenced from a static context.
            return single_instance;
        }
        //To instantiate a singleton class, we use the getInstance() method as we did above.
        //In general, we may also use the class name as method name while defining this method.
        //Implementing Singleton class with method name as that of the class name.
    public static Singleton Singleton() {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }

}


