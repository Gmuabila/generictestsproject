package genericclasses.hashcodeAndEqualsMethodsDemo;

public class House {
    private String street;
    private int number;

    public House() {
    }

    public House(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //Let's override both hashCode() and equals() methods below
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        House house = (House) obj;
        return (this.getStreet().equals(house.getStreet()) && this.getNumber() == house.getNumber());
    }
    @Override
    public int hashCode(){
        return this.street.hashCode() * this.number;
       // return this.getStreet().hashCode() * this.number * 2;
    }
}
