package genericclasses.gsondemo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;

public class GsonTester {
    //Google Gson class
    //Gson is the main actor class of Google Gson library.
    //It provides functionalities to convert Java objects to matching JSON constructs and vice versa.
    //Gson is a Java library that can be used to convert Java Objects into their JSON representation.
    //It can also be used to convert a JSON string to an equivalent Java object.

    @Test
    public void gsonTesterOne(){
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        Gson gson = new Gson();
        System.out.println("Printing the original Json");
        System.out.println(jsonString);
        //Converting Json construct(String or Json representation to Java Object)
        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println("\nPrinting the converted Student");
        System.out.println(student);
        //Converting Java Object to Json construct
        String cjsonString = gson.toJson(student);
        System.out.println("\nPrinting the converted Json");
        System.out.println(cjsonString);
    }


}
