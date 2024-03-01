package genericclasses.tryWithResources;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResources {
    /** Try with Resources
     -----------------------------------------
     Support for try-with-resources introduced in Java 7 allows us to declare resources to be used in a try block with the
     assurance that the resources will be closed after the execution of that block. The resources declared need to implement the AutoCloseable interface.
     Simply put, to be auto-closed, a resource has to be both declared and initialized inside the try block.                                        */
    @Test
    public void testTryWithResources(){
        try (PrintWriter writer = new PrintWriter(new File("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile.txt"))) {
            writer.println("Hello World");
           // writer.println(System.lineSeparator());
            writer.println("Hello World two");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testTryWithResourcesB(){
        /** Replacing try–catch-finally With try-with-resources
         The simple and obvious way to use the new try-with-resources functionality is to replace the traditional and verbose try-catch-finally block.
         Let’s compare the following code samples. The first is a typical try-catch-finally block:                                              */
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //System.out.println("Process done");  //To test if the code in the finally block gets executed, it has executed last.
            if (scanner != null) {
                scanner.close();
            }
        }
        System.out.println();
        System.out.println();
        /** And here’s the new super succinct solution using try-with-resources:                                                                */
        try (Scanner scan = new Scanner(new File("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile.txt"))) {
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    @Test
    public void testTryWithResourcesC(){
        /** try-with-resources With Multiple Resources
         We can declare multiple resources just fine in a try-with-resources block by separating them with a semicolon.                         */
        try (Scanner scanner = new Scanner(new File("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile.txt"));
             PrintWriter writer = new PrintWriter("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile.txt")) {
            while (scanner.hasNext()) {
                writer.println(scanner.nextLine());  //To figure out what is happening here.  It's deleting the two lines of text in this file.
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }



    }

    @Test
    public void testTryWithResourcesD() {
        /** A Custom Resource With AutoCloseable
         To construct a custom resource that will be correctly handled by a try-with-resources block,
         the class should implement the Closeable or AutoCloseable interfaces and override the close method.                                    */
        try (MyResource myResource = new MyResource()) {
            System.out.println(myResource);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
