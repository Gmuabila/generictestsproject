package genericclasses.assertionjunitdemo;

public class Assertion {
    String name;
    String postcode;

    public Assertion() {
    }

    public Assertion(String name, String postcode) {
        this.name = name;
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString(){
        return "name is: " + name + " " + "\nPostcode is: " + postcode;
    }
}
