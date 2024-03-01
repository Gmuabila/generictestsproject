package genericclasses.NIO2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadWithFilesClass {
    /** Read with Files class
     The Files utility class provides several variations of methods to read the contents of a file.
     Types of Encoding
     -------------------
     Following are the different types of encoding used before the Unicode system.
     •	ASCII (American Standard Code for Information Interchange): used for the United States
     •	ISO8859-1 used for the Western European Languages
     •	KOI8 used for Russian.
     •	GB18030 and BIG-5 used for Chinese and so on.
     •	Base64 used for binary to text encoding.                                                                                                    */
    @Test
    public void testReadWithFilesClass(){
       /** readAllBytes() method
        -------------------------
        The readAllBytes() method reads all the bytes from a file. The method ensures that the file is closed when all bytes have been read or
        an I/O error, or other runtime exception, is thrown. Note that this method is intended for simple cases where it is convenient to
        read all bytes into a byte array. It is not intended for reading in large files.
        Syntax: public static byte[] readAllBytes(Path path) throws java.io.IOException
        Params: path – the path to the file
        Returns: a byte array containing the bytes read from the file
        Throws: java.io.IOException if an I/O error occurs reading from the stream
        OutOfMemoryError – if an array of the required size cannot be allocated, for example the file is larger than 2GB.
        SecurityException – In the case of the default provider, and a security manager is installed,
        the checkRead method is invoked to check read access to the file.                                                                       */
        try{
            Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile6.txt");
            byte[] contents = Files.readAllBytes(path);
            String str = new String(contents, "UTF8");
            System.out.println(str);
        }catch(IOException ex){
            System.err.println(ex);
        }
        /** One of the disadvantages of using an array to read contents of a file is that there is a limitation on its size.
        If a file is of, say, more than 2GB, it is ridiculous to read its contents in an array.                                                 */
    }

    @Test
    public void testReadWithFilesClassA(){
        /** readAllLines() method
         ---------------------------
         The readAllLines() method of the Files class reads all lines from a file. Bytes from the file are decoded into characters using
         the UTF-8 charset. This method works as if invoking it were equivalent to evaluating the expression:
         Files.readAllLines(path, StandardCharsets.UTF_8)
         Params: path – the path to the file
         Returns: the lines from the file as a List; whether the List is modifiable or not is implementation dependent and therefore not specified
         Throws: java.io.IOException – if an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read.
         SecurityException – In the case of the default provider, and a security manager is installed, the checkRead method is invoked to
         check read access to the file.                                                                                                         */
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile6.txt");
        try {
            String read = Files.readAllLines(path).get(1);  //Reading texts from a file using the readAllLines() method of the Files class
            System.out.println(read);
            System.out.println();
            List<String> testList = Files.readAllLines(path, Charset.forName("UTF8"));
            testList.stream().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadWithFilesClassB(){
        Path sourceFile = Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile6.txt");
        Path targetFile = Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRTwo/childFile6Copy.txt");
        try {
            System.out.println("File created: " + Files.createFile(targetFile));
        }catch (IOException e){
            System.err.println("I/O Error when creating File");
        }
        try {
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ex) {
            System.err.format("I/O Error when copying file");
        }
        Charset charset = Charset.forName("ISO-8859-1");
        try {
            List<String> lines = Files.readAllLines(targetFile, charset);
            for (String line : lines) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testReadWithFilesClassC(){
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRTwo/readWriteFile.txt");
        String question = "What is the most beautiful thing in life?";
        Charset charset = Charset.forName("ISO-8859-1");
        try {
            Files.write(path, question.getBytes());
            List<String> lines = Files.readAllLines(path, charset);
            lines.stream().forEach(System.out::println);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
