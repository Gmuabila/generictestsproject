package genericclasses.IOapi;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileClassDemo {
        /**
         * File Class
         * The File class provide the ability to work with files and directories on the file system. Java has several methods for creating,
         * reading, updating, and deleting files. The File class from the java.io package, allows us to work with files. To use the File class,
         * create an object of the class, and specify the filename or directory name.
         * The File class is a Java representation of a file or directory pathname. Because file and directory names have different formats on
         * different platforms, a simple string is not adequate to name them. Java File class contains several methods for working with the pathname,
         * deleting, renaming files, creating new directories, listing the contents of a directory, and determining several common attributes of
         * files and directories.
         * •	The File class is an abstract representation of files and directory pathnames.
         * •	A pathname, whether abstract or in string form can be either absolute or relative. The parent of an abstract pathname may be obtained by
         * invoking the getParent() method of this class.  A Java Path instance represents a path in the file system. A path can point to either a file or
         * a directory. A path can be absolute or relative. An absolute path contains the full path from the root of the file system down to the file or
         * directory it points to. A relative path contains the path to the file or directory relative to some other path.
         * •	First of all, we should create the File class object by passing the filename or directory name to it. A file system may
         * implement restrictions to certain operations on the actual file-system object, such as reading, writing, and executing.
         * These restrictions are collectively known as access permissions.
         * •	Instances of the File class are immutable; that is, once created, the abstract pathname represented by a File object will never change.
         * *****
         * A File object is created by passing in a string that represents the name of a file, a String, or another File object. The File class has a
         * number of methods that allow us to work with and manipulate files on the file system. It is important to note that the
         * File class cannot modify or access the contents of the file it represents.
         * Directories and files are created using the mkdir() and createNewFile() methods, respectively.
         * Directories and files are deleted using the delete() method. All these methods return a boolean value that is true when the
         * operation succeeds, and false otherwise.
         */
        //  /Users/ghislainmuabila/FileClassTemp  //My path to the folder created for this exercise.
        //  /Users/ghislainmuabila/IdeaProjects/generictestsproject/fileTest.txt   //When you don't specify a path, the created file goes to the project dir.
        @Test
        public void testFileClass() throws IOException {
            File file = new File("/Users/ghislainmuabila/FileClassTemp/ThirdJavaFile.txt");
            System.out.println(file.createNewFile());
        }

        @Test
        public void testFileClassB() {
            File file = new File("fileTest2.txt");   //The file will be created in the same directory as the project.
            try {
                assertTrue(file.createNewFile());                           //IOException extends the Exception class, and is the general class of
            } catch (IOException e) {                                       //exceptions produced by failed or interrupted I/O operations.
                fail("Could not create " + "fileTest.txt");
            }
            assertTrue(file.delete());
        }

        @Test
        public void testFileClassB2(){
            /** createNewFile() method                                                                                                  */
            try {
                File myFile = new File("/Users/ghislainmuabila/FileClassTemp/JavFile.txt");
                if (myFile.createNewFile()) {
                    System.out.println("File created: " + myFile.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        @Test
        public void testFileClassB3(){
            /** FileWriter class
             We use the FileWriter class together with its write() method to write some text to the file.
             Note that when you are done writing to the file, you should close it with the close() method.                                             */
            try {
                FileWriter myWriter = new FileWriter("/Users/ghislainmuabila/FileClassTemp/JavFile.txt");
                myWriter.write("Files in Java might be tricky, but it is fun enough!\nMore and more fun thanks");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        @Test
        public void testFileClassC() {
            File file = new File("fileTest.txt");
            System.out.println(file.delete());
        }

        @Test
        public void testFileClassD() {
            File file = new File("/Users/ghislainmuabila/FileClassTemp/Testo.txt");
            try {
                System.out.println("File created: " + file.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("File deleted: " + file.delete());
        }

        @Test
        public void testFileClassE() {
            File file = new File("/Users/ghislainmuabila/FileClassTemp/TestDIR");
            assertTrue(file.mkdir());
            System.out.println();
            File file1 = new File("/Users/ghislainmuabila/FileClassTemp/TestDIR/MyFile.txt");
            try {
                System.out.println("File created: " + file1.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("File deleted: " + file1.delete());
            file.deleteOnExit();
            //System.out.println("Directory deleted: " + file.delete());
        }

        @Test
        public void testFileClassF() {
            File file = new File("/Users/ghislainmuabila/FileClassTemp/TestDIRTwo");
            System.out.println("Directory created: " + file.mkdir());
            System.out.println("Is this a file: " + file.isFile());
            System.out.println("Is this a folder: " + file.isDirectory());
            System.out.println("Folder exist: " + file.exists());
            System.out.println("Folder hidden: " + file.isHidden());
            System.out.println("Folder total space: " + file.getTotalSpace());
            System.out.println("Folder absolute path: " + file.getAbsolutePath());
            System.out.println("Folder name: " + file.getName());
            System.out.println("Folder getParent()" + file.getParent());
            System.out.println("Folder canRead(): " + file.canRead());
            System.out.println("Folder canWrite(): " + file.canWrite());
            System.out.println("Folder canExecute(): " + file.canExecute());
            System.out.println("Folder list files: " + file.listFiles());
            System.out.println("Folder getPath(): " + file.getPath());
        }

        @Test
        public void testFileClassG() {
            File file = new File("/Users/ghislainmuabila/FileClassTemp/TestDIRTwo/myfileTwo");
            try {
                System.out.println("File created: " + file.createNewFile());
                System.out.println("Canonical path: " + file.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("File exist: " + file.exists());
            System.out.println("Is this a file: " + file.isFile());
            System.out.println("File canRead(): " + file.canRead());
            System.out.println("File canWrite(): " + file.canWrite());
            System.out.println("File hidden: " + file.isHidden());
            System.out.println("File absolute path: " + file.getAbsolutePath());
            System.out.println("File getParent(): " + file.getParent());
            System.out.println("File name: " + file.getName());
            System.out.println("File getPath() " + file.getPath());
        }

        @Test
        public void testFileClassH(){
            String sep = File.separator;
            File parentDir = new File ("/Users/ghislainmuabila/FileClassTemp/TestDIRThree");
            System.out.println("Directory created: " + parentDir.mkdir());
            File child = new File(parentDir, "childFile.txt");
            try {
                System.out.println("Child file created: " + child.createNewFile());
            }catch (IOException e){
                fail("Unable to create" + "childFile.txt");
            }
            assertEquals("childFile.txt", child.getName());
            assertEquals(parentDir.getName(), child.getParentFile().getName());
            assertEquals(parentDir.getPath() + sep + "childFile.txt", child.getPath());
            System.out.println("String separator: " + sep);   //Printing the separator to see what it looks like.
            parentDir.deleteOnExit();
        }

        @Test
        public void testFileClassI(){
            String sep = File.separator;
            File dirParent = new File("/Users/ghislainmuabila/FileClassTemp/DirParent");
            System.out.println("Folder created " + dirParent.mkdir());
            File childFile = new File(dirParent, "ChildFile");
            try {
                System.out.println("File created: " + childFile.createNewFile());
            }catch (IOException e){
                fail("Not created" + "ChildFile");
            }
            assertEquals("ChildFile", childFile.getName());
            assertEquals(dirParent.getName(), childFile.getParentFile().getName());
            assertEquals(dirParent.getPath() + sep + "ChildFile", childFile.getPath());
            System.out.println("Parent Pathname: " + childFile.getParent());
            System.out.println("File name: " + childFile.getName());
            System.out.println("Folder name: " + dirParent.getName());
        }

        @Test
        public void testFileClassJ() {
            /** Setting File and Directory Permissions
             The File class has methods that allow you to set permissions on a file or a directory: setWritable() and setReadable() methods.            */
            File parentDir = new File("/Users/ghislainmuabila/FileClassTemp/DirFolder");
            File child = new File(parentDir, "fileOne.txt");
            System.out.println("Folder created: " + parentDir.mkdir());
            try {
                System.out.println("File created: " + child.createNewFile());
            } catch (IOException e) {
                fail("Could not create " + "fileOne.txt");
            }
            child.setWritable(false);
            boolean writable = true;
            try (FileOutputStream fos = new FileOutputStream(child)) {
                fos.write("Hello World".getBytes()); // write operation
                fos.flush();
            } catch (IOException e) {
                writable = false;
                assertFalse(writable);
            }
        }

        @Test
        public void testFileClassK() {
            /** Setting File and Directory Permissions                                                                                  */
            File parentDir = new File("/Users/ghislainmuabila/FileClassTemp/DirFTwo");
            File child = new File(parentDir, "fileTwo.txt");
            System.out.println("Folder created: " + parentDir.mkdir());
            try {
                System.out.println("File created: " + child.createNewFile());
            } catch (IOException e) {
                fail("Could not create " + "fileOne.txt");
            }
            child.setReadable(false);
            int i = 0;
            try {
                FileInputStream inStream = new FileInputStream(child);
                while ((i = inStream.read()) != -1) {
                    System.out.println((char) i);
                }
                inStream.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        @Test
        public void testFileClassL(){
            /** Setting File and Directory Permissions                                                                                  */
            File parentDir = new File("/Users/ghislainmuabila/FileClassTemp/writeDir");
            File child = new File(parentDir, "fileRead.txt");
            System.out.println("Folder created: " + parentDir.mkdir());
            try {
                child.createNewFile();
            } catch (IOException e) {
                fail("Could not create " + "fileRead.txt");
            }
            child.setReadable(false);
            boolean readable = true;
            try (FileInputStream fis = new FileInputStream(child)) {
                fis.read(); // read operation
            } catch (IOException e) {
                readable = false;
            }
            finally {
                parentDir.delete();  //Does not delete the folder
            }
            assertFalse(readable);
        }

        @Test
        public void testFileClassM(){
            File parentDir = new File("/Users/ghislainmuabila/FileClassTemp/filterDir");
            System.out.println("Folder created: " + parentDir.mkdir());
            String[] files = {"file1.csv", "file2.txt", "file4.txt", "file3.csv", "file6.txt"};
            for (String file : files) {
                try {
                    new File(parentDir, file).createNewFile();
                } catch (IOException e) {
                    fail("Could not create " + file);
                }
            }
            //normal listing
            assertEquals(5, parentDir.list().length);
            //filtered listing
            FilenameFilter csvFilter = (dir, ext) -> ext.endsWith(".csv");
            FilenameFilter txtFilter = (dir, ext) -> ext.endsWith(".txt");
            assertEquals(2, parentDir.list(csvFilter).length);
            assertEquals(3, parentDir.list(txtFilter).length);
        }
}
