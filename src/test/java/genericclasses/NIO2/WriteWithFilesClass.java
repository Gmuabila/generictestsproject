package genericclasses.NIO2;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WriteWithFilesClass {
    /** Write With Files Class
     --------------------------
     Java 7 introduces a new way of working with the filesystem, along with a new utility class: Files.
     Using the Files class, we can create, move, copy, and delete files and directories. It can also be used to read and write to a file.
     readAllLines() method
     ------------------------
     The readAllLines() method of the Files class reads all lines from a file. Bytes from the file are decoded into characters using
     the UTF-8 charset. This method works as if invoking it were equivalent to evaluating the expression:
     Files.readAllLines(path, StandardCharsets.UTF_8)
     Params: path – the path to the file
     Returns: the lines from the file as a List; whether the List is modifiable or not is implementation dependent and therefore not specified
     Throws: java.io.IOException – if an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read.
     SecurityException – In the case of the default provider, and a security manager is installed, the checkRead method is invoked to
     check read access to the file.                                                                                                             */
     @Test
    public void testWriteWithFilesClass() {
        String str = "Using the Files class, we can create, move, copy, and delete files and directories. It can also be used to read and write to a file.";
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt");
        byte[] strToBytes = str.getBytes();
        try {
            Files.write(path, strToBytes);  //Writing text to the file using the Files class
            String read = Files.readAllLines(path).get(0);  //Reading texts from the file using the Files class
            assertEquals(str, read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteWithFilesClassB() {
        String str = "Using the Files class, we can create, move, copy, and delete files and directories.";
        String strTwo = "It can also be used to read and write to a file.";
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile6.txt");
        byte[] strToBytes = str.getBytes();
        byte[] strTwoBytes = strTwo.getBytes();
        try {
            Files.write(path, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
            Files.write(path, strToBytes, StandardOpenOption.APPEND);  //Writing text to the file using the Files class
            Files.write(path, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
            Files.write(path, strTwoBytes, StandardOpenOption.APPEND);
            String read = Files.readAllLines(path).get(10);//Reading texts from the file.  Reading line of text at index 0 of the List.
            //assertEquals(str, read);
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteWithFilesClassC(){
        try{
            Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/writeDir/writeFile.txt");
            Files.createFile(path);
            Charset charSet = Charset.forName("UTF-8");
            List<String> list = new ArrayList<>();
            list.add("nThis is second line");
            list.add("This is third line");
            list.add("This is fourth line");
            Files.write(path, list, charSet, StandardOpenOption.APPEND);
        }catch(IOException e){
            System.err.println(e);
        }
    }
}
