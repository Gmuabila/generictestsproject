package genericclasses.IOapi;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderClass {
    /** FileReader class
     ------------------------------------------
     As the name suggests, FileReader is a class that makes it easy to read the contents of a file.  We can use FileReader class for
     doing read operations on a character stream. The FileReader class can be found in java.io.FileReader.
     Syntax: public class FileReader extends InputStreamReader
     Reader Basics
     If we look at the code of the FileReader class, then we’ll notice that the class contains minimal code for creating a FileReader object and
     no other methods. This raises questions like “Who does the heavy lifting behind this class?”. To answer this question, we must understand the
     concept and hierarchy of the Reader class in Java. The Reader class is an abstract base class that makes reading characters possible through one
     of its concrete implementations. It defines the following basic operations of reading characters from any medium such as memory or the filesystem:
     •	Read a single character.
     •	Read an array of characters.
     •	Mark and reset a given position in a stream of characters.
     •	Skip position while reading a character stream.
     •	Close the input stream.
     Naturally, all the implementations of the Reader class must implement all the abstract methods, namely read() and close(). Moreover,
     most implementations also override other inherited methods to give additional functionality or better performance.
     When to Use a FileReader
     Now that we’ve some understanding about a Reader, we’re ready to bring our focus back to the FileReader class. The FileReader inherits its
     functionality from InputStreamReader, which is a Reader implementation designed to read bytes from an input stream as characters.
     Let’s see this hierarchy in the class definitions:
     public class InputStreamReader extends Reader {
     }

     public class FileReader extends InputStreamReader {
     }
     We can use a FileReader when we want to read text from a file using the system’s default character set. For any other advanced functionality,
     it’d be ideal for making use of InputStreamReader class directly.
     public FileReader(String fileName) throws FileNotFoundException {
     super(new FileInputStream(fileName));
     }

     public FileReader(File file) throws FileNotFoundException {
     super(new FileInputStream(file));
     }

     public FileReader(FileDescriptor fd) {
     super(new FileInputStream(fd));
     }                                                                                                                                              */
    @Test
    public void testFileReaderClass() throws FileNotFoundException {
        //Reading characters from a file one at a time
       // Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirFolder/ChildFile");
        FileReader fileReader = new FileReader("/Users/ghislainmuabila/FileClassTemp/DirFolder/ChildFile");
        try {
            String strResult = readAllCharactersOneByOne(fileReader);
            System.out.println(strResult);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String readAllCharactersOneByOne(Reader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        int nextChar;
        while ((nextChar = reader.read()) != -1) {
            content.append((char) nextChar);
        }
        return String.valueOf(content);
    }

    @Test
    public void testFileReaderClassB() {
        String expectedText = "Welcome to GfG";
        File file = new File("/Users/ghislainmuabila/FileClassTemp/DirParent/flush.txt");
        try (FileReader fileReader = new FileReader(file)) {
            String content = readAllCharactersOneByOne(fileReader);
            Assert.assertEquals(expectedText, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
