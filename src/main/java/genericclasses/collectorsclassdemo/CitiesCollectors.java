package genericclasses.collectorsclassdemo;


/*Let’s consider a City class, which has attributes like name and temperature which are being initialized with the
parameterized constructor. We will observe the different methods available in the collectors class using this example.
 */

import java.util.ArrayList;
import java.util.List;

// Java program to implement a
// City class
// Defining a city class
public class CitiesCollectors {
        // Initializing the properties
        // of the city class
        private String name;
        private double temperature;
        // Parameterized constructor to
        // initialize the city class
        public CitiesCollectors(String name, double temperature){
            this.name = name;
            this.temperature = temperature;
        }
        // Getters to get the name and
        // temperature
        public String getName(){
            return name;
        }
        public double getTemperature(){
            return temperature;
        }
        // Overriding the toString method
        // to return the name and temperature
        @Override
        public String toString(){
            return name + " --> " + temperature;
        }
}
