package genericclasses.IOapi;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterClass {
    /** FileWriter class
     FileWriter class is a specialized OutputStreamWriter for writing character files.
     It doesn’t expose any new operations but works with the operations inherited from the OutputStreamWriter and Writer classes.
     Until Java 11, the FileWriter worked with the default character encoding and default byte buffer size.
     However, Java 11 introduced four new constructors that accept a Charset, thereby allowing user-specified Charset.
     Unfortunately, we still cannot modify the byte buffer size, and it’s set to 8192.
     There are five constructors in the FileWriter class if we’re using a Java version before Java 11:
     public FileWriter(String fileName) throws IOException {
     super(new FileOutputStream(fileName));
     }
     public FileWriter(String fileName, boolean append) throws IOException {
     super(new FileOutputStream(fileName, append));
     }
     public FileWriter(File file) throws IOException {
     super(new FileOutputStream(file));
     }
     public FileWriter(File file, boolean append) throws IOException {
     super(new FileOutputStream(file, append));
     }
     public FileWriter(FileDescriptor fd) {
     super(new FileOutputStream(fd));
     }
     Java 11 introduced four additional constructors:
     public FileWriter(String fileName, Charset charset) throws IOException {
     super(new FileOutputStream(fileName), charset);
     }
     public FileWriter(String fileName, Charset charset, boolean append) throws IOException {
     super(new FileOutputStream(fileName, append), charset);
     }
     public FileWriter(File file, Charset charset) throws IOException {
     super(new FileOutputStream(file), charset);
     }
     public FileWriter(File file, Charset charset, boolean append) throws IOException {
     super(new FileOutputStream(file, append), charset);
     }                                                                                                                                              */
    @Test
    public void testFileWriter() {
        /** Let’s now use one of the FileWriter constructors to create an instance of FileWriter and then write to a file:                          */
        try (FileWriter fileWriter = new FileWriter("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile.txt", true)) {
            fileWriter.write(System.lineSeparator());  //Print a new line where the new text will be added.  append "true" allows text to be appended and not to override existing text.
            fileWriter.write("Hello Folks!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileWriterB(){
        /** A new file will be created if the file does not exist.
         The FileWriter does not guarantee whether the FileWriterTest.txt file will be available or be created.
         It is dependent on the underlying platform. We must also make a note that certain platforms may allow only a
         single FileWriter instance to open the file. In that case, the other constructors of the FileWriter class will
         fail if the file involved is already open.                                                                                                 */
        try {
            FileWriter myWriter = new FileWriter("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile2.txt", true);
            myWriter.write(System.lineSeparator());
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
