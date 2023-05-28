package genericclasses;

import org.junit.Test;

import java.util.Optional;

public class TryCatchDemo {

    @Test
    public void testingTryCatch() {

        try {
            String[] str = new String[10];
            String word = str[5].toLowerCase();
            System.out.println(word);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void testingTryCatchTwo(){
        //Resolving null pointer exception using null check
        try {
            String[] str = new String[10];
            if(str[5] != null) {
                String word = str[5].toLowerCase();
                System.out.println(word);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
