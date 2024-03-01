package genericclasses.IOapi;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterClass {
    /** Write With PrintWriter class
     The PrintWriter class prints formatted representations of objects to a text-output stream.
     This class implements all of the print methods found in PrintStream. It does not contain methods for writing raw bytes,
     for which a program should use unencoded byte streams. Unlike the PrintStream class, if automatic flushing is enabled it will
     be done only when one of the println, printf, or format methods is invoked, rather than whenever a newline character happens to be output.
     These methods use the platform's own notion of line separator rather than the newline character.
     Methods in this class never throw I/O exceptions, although some of its constructors may. The client may inquire as to
     whether any errors have occurred by invoking checkError().
     Syntax: public class PrintWriter extends Writer                                                                                                */
    @Test
    public void testPrintWriter() throws IOException {
        FileWriter fileWriter = new FileWriter("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("The PrintWriter class prints formatted representations of objects to a text-output stream.\n" +
                "This class implements all of the print methods found in PrintStream. \nIt does not contain methods for writing raw bytes,\n" +
                "for which a program should use unencoded byte streams.\n");
        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();
    }

    @Test
    public void testPrintWriterB() throws IOException {
        FileWriter fileWriter = new FileWriter("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile5.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(System.lineSeparator());  //write() method also works: printWriter.write(System.lineSeparator());
        printWriter.print("The PrintWriter class prints formatted representations of objects to a text-output stream.\n" +
                "This class implements all of the print methods found in PrintStream. \nIt does not contain methods for writing raw bytes,\n" +
                "for which a program should use unencoded byte streams.\n");
        printWriter.print(System.lineSeparator());
        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();
    }

}
