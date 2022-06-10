package genericclasses.superkeyworddemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
//@NoArgsConstructor  								//Removed Lombok Constructor to define below Constructor.

 abstract class Animal {

	String color = "'White'...In Super Class";

	public Animal(){								//Defining a Constructor with no arguments.
		System.out.println("Animal is created");
	}

	public void eat(){
		System.out.println("Eating...From eat() Method in Super class");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract int getLegs();
}


