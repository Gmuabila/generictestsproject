package genericclasses.hashcodeAndEqualsMethodsDemo;

public class Geek {
    // Java program to illustrate overriding of equals and hashcode methods
    String name;
    int id;

    Geek(String name, int id) {
        this.name = name;
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        // Checking if both object references are referring to the same object.
        if (this == obj)
            return true;
        // Checking if the argument is of type Geek by comparing the class
        // of the passed argument and the class of 'this' object.
        // if(!(obj instanceof Geek)) return false; ---> avoid using 'instanceOf' operator as it does not
        // return false if it finds that the passed argument is a subclass of the class Geek.
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        // Type casting of the argument.
        Geek geek = (Geek) obj;
        // Comparing the state of the argument with the state of 'this' Object.
        return (geek.name.equals(this.name) && geek.id == this.id);
        //return (geek.getName().equals(this.getName()) && geek.getId() == this.getId());  //Same as above
    }
//    @Override
//    public int hashCode() {
//        // We can return the Geek_id as a hashcode value if we wish to do so. we can also return some
//        // other calculated value or maybe memory address of the Object on which it is invoked.
//        // it depends on how you implement hashCode() method.
//        // The best way to implement hashCode() is to perform an operation on all the data members of
//        // the class and compute the hashCode.  In thi way objects of the class will have their data members
//        // Calculated as specified in the hashcode method, and if they contain the same value, their hashcode will be equal. See below.
//        return this.id + this.name.hashCode() * 2;
//    }

}

