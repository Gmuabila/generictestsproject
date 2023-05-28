package genericclasses;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapCollectionDemo {

    @Test
    public void mapTesting(){
        Map<String, String> mapTest = new HashMap<>();
        mapTest.put("John", "Kawasaki");
        mapTest.put("George", "LeBlanc");
        mapTest.put("Mut", "Tumami");
        mapTest.put("Dandy", "MyBaby");
        mapTest.put("Ross", "Mummy");
        mapTest.put("Dorine", "Jenkins");

        Map<String, String> testMap = new HashMap<>();
        testMap.put("firstMan", "Monday");  //
        testMap.put("secondMan", "Tuesday");
        testMap.put("thirdMan", "Wednesday");

        Set<String> theKeys = mapTest.keySet();
        System.out.println("Username" + "\t" + "Password");
        for (String item: theKeys) //iterate through the set of keys
        {
            String password = mapTest.get(item);  //retrieve password value
            System.out.println (item + "\t" + password);  //format output, notice the tab in the output.
        }
        System.out.println();
        System.out.println();
        System.out.println(mapTest);

        System.out.println();
        Set<String> loginKeys = testMap.keySet();
        System.out.println("User Login Name" + "\t\t" + "Password");
        for(String key: loginKeys){
            System.out.println(key + "\t\t\t\t" + testMap.get(key));
        }

        System.out.println();
        System.out.println(testMap);


    }
}
