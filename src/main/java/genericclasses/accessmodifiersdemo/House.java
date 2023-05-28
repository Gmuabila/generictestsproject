package genericclasses.accessmodifiersdemo;

public class House {

    private int streetNumber;
    protected int postcode;
    String road;
    String city;

    public House() {
    }

    public House(int streetNumber, String road, String city) {
        this.streetNumber = streetNumber;
        this.road = road;
        this.city = city;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //**** Access Modifiers *******//
    //Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
    private void houseDisplay(){
        System.out.println("Testing Private Modifier");
    }

    //Protected: The access level of a protected modifier is within the package and outside the package through child class.
    // If you do not make the child class, it cannot be accessed from outside the package.
    protected void houseDisplayTwo(){
        System.out.println("Testing Protected Modifier");
    }

    //Default: The access level of a default modifier is only within the package.
    //It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.
    void displayHouse(){
        System.out.println("Testing Default Modifier");
    }

    //Public: The access level of a public modifier is everywhere. It can be accessed from within the class,
    //outside the class, within the package and outside the package.
    public void displayHousePublic(){
        System.out.println("Testing Public Modifier");
    }
}
