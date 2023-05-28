package genericclasses.hashcodedemo;

public class Geek {
    // Java program to illustrate
    // overriding of equals and
    // hashcode methods
    String name;
    int id;

    Geek(String name, int id) {

        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {

        // if both the object references are
        // referring to the same object.
        if (this == obj)
            return true;

        // it checks if the argument is of the
        // type Geek by comparing the classes
        // of the passed argument and the class of this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        // type casting of the argument.
        Geek geek = (Geek) obj;

        // comparing the state of the argument with
        // the state of 'this' Object.
        return (geek.name.equals(this.name) && geek.id == this.id);
    }

    @Override
    public int hashCode() {

        // We are returning the Geek_id
        // as a hashcode value.
        // we can also return some
        // other calculated value or may
        // be memory address of the
        // Object on which it is invoked.
        // it depends on how you implement
        // hashCode() method.
        return this.id;
    }

}

