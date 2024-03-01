package genericclasses.IOapi;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedWriterClass {
    /** Writer to File
    There are different ways to write to a file using Java, this includes BufferedWriter, PrintWriter, FileOutputStream, DataOutputStream,
     RandomAccessFile, FileChannel, and the Java 7 Files utility class.
     Write With BufferedWriter class
     ---------------------------------
     BufferedWriter class Writes text to a character-output stream, buffering characters so as to provide for the efficient writing of single characters,
     arrays, and strings. The buffer size may be specified, or the default size may be accepted. The default is large enough for most purposes.
     Syntax: public class BufferedWriter extends Writer
     newLine() method:
     A newLine() method is provided, which uses the platform's own notion of line separator as defined by the system property line.separator.
     Not all platforms use the newline character ('\n') to terminate lines. Calling this method to terminate each output line is therefore preferred to
     writing a newline character directly.                                                                                                          */
    @Test
    public void testBufferedWriterClass() {
        String str = "BufferedWriter class Writes text to a character-output stream, \nbuffering characters so as to provide for the efficient writing of single characters,\n" +
                "arrays, and strings. The buffer size may be specified, \nor the default size may be accepted. The default is large enough for most purposes.";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/ghislainmuabila/FileClassTemp/TestDIRTwo/myfileTwo"));
            writer.write(str);
            writer.close();
            System.out.println("Files has been written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferedWriterClassB() {
        String str = "BufferedWriter class Writes text to a character-output stream. buffering characters so as to provide for the efficient writing of single characters," +
                "arrays, and strings. The buffer size may be specified, or the default size may be accepted. The default is large enough for most purposes.";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/ghislainmuabila/FileClassTemp/TestDIRTwo/myfileThree", true));
            writer.newLine();
            writer.write(str);
            writer.close();
            System.out.println("Files has been written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferedWriterClassC(){
        /** We can then append a String to the existing file.                                                                                       */
        String str = "We can then append a String to the existing file.";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/ghislainmuabila/FileClassTemp/TestDIRTwo/myfileTwo", true))) {
           // writer.append(System.lineSeparator());  //System.lineSeparator is behaving the same as the newline() method.
            writer.newLine();
            writer.append(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferedWriterClassD(){
                //initializing FileWriter
                FileWriter geek_file;
                try
                {
                    geek_file = new FileWriter("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile3.txt", true);
                    // Initializing BufferedWriter
                    BufferedWriter writer = new BufferedWriter(geek_file);
                    System.out.println("Buffered Writer start writing :)");
                    // Use of write() method to write the value in 'ABC' file
                    writer.newLine();
                    writer.write("GEEKS");
                    // For next line
                    writer.newLine();
                    writer.write("FOR");
                    // For next line
                    writer.newLine();
                    writer.write("Geeks");
                    // Closing BufferWriter to end operation
                    writer.close();
                    System.out.println("Written successfully");
                }
                catch (IOException except)
                {
                    except.printStackTrace();
                }
    }

    @Test
    public void testBufferedWriterClassE(){
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRTwo/writeFile.txt");
        String str = "This is the First line.";
        String str2 = "This is the second line";
        String str3 = "This is the last line";
        try{
            Files.createFile(path);
        }catch (IOException e){
            System.err.println("IO Error while creating the file");
        }
        try(BufferedWriter writer= Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND))
        {
            writer.newLine();
            writer.write(str);
            writer.newLine();
            writer.write(str2);
            writer.newLine();
            writer.write(str3);
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}
