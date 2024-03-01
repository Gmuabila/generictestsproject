package genericclasses.IOapi;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamClass {
    /**
     * Write With FileOutputStream
     * We can use FileOutputStream class to write binary data to a file.
     * The following code converts a String into bytes and writes the bytes to a file using FileOutputStream:
     */
    @Test
    public void testFileOutputStream() {
        String str = "Hello\n";
        try {
            FileOutputStream outputStream = new FileOutputStream("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt", true);
            byte[] strToBytes = str.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
