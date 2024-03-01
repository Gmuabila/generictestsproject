package genericclasses.NIO2;

import com.google.common.base.Utf8;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.springframework.boot.loader.PropertiesLauncher.HOME;

public class NewInputOutputAPI {
    /**
     * Java NIO (New I/O)
     * -------------------------------------------
     * Java has provided a second I/O system called NIO (New I/O). Java NIO provides the different way of working with I/O than the standard I/O API's.
     * It is an alternate I/O API for Java (from Java 1.4). Java NIO supports a buffer-oriented, channel based approach for I/O operations.
     * With the introduction of JDK 7, the NIO system is expanded, providing the enhanced support for file system features and file-handling.
     * Due to the capabilities supported by the NIO file classes, NIO is widely used in file handling.
     * NIO was developed to allow Java programmers to implement high-speed I/O without using the custom native code.
     * NIO moves the time-taking I/O activities like filling, namely and draining buffers, etc back into the operating system,
     * thus allows for great increase in operational speed.
     * <p>
     * Input and Output
     * ------------------
     * Java IO basically provides a mechanism to read data from a source and write data to a destination.
     * Input represents the source while output represents the destination.
     * These sources and destinations can be anything from Files,Pipes to Network Connections.
     * OutputStream:
     * Java application uses an output stream to write data to a destination; it may be a file, an array, peripheral device, or socket.
     * InputStream:
     * Java application uses an input stream to read data from a source; it may be a file, an array, peripheral device, or socket.
     * <p>
     * Path and File
     * Path and File are classes responsible for file I/O operations. They perform the same functions but belong to different packages.
     * java.io.File Class
     * The File class is an abstract representation of file and directory pathnames. Since the very first versions, Java has delivered its own java.io package, which contains nearly every class we might ever need to
     * perform input and output operations:
     * File file = new File("baeldung/tutorial.txt");
     * Instances of the File class are immutable – once created, the abstract pathname represented by this object will never change.
     * java.nio.file.Path interface
     * Path is an interface and is the representation of a location in particular file system. We can have a Path instance representing a
     * file or a directory on the file system. Whether that file or directory it’s pointing to exists or not, is accessible or not can be
     * confirmed by a file operation. The Path class forms part of the NIO2 update, which came to Java with version 7.
     * It delivers an entirely new API to work with I/O. As Path interface is in Java NIO package, so it gets its qualified name as java.nio.file.Path.
     * Like the legacy File class,the Path interface creates an object that can be used to locate a file in a file system. Likewise,
     * it can perform all the operations that can be done with the File class. In order to get the instance of Path we use a static method of
     * java.nio.file.Paths class get(). This method converts a path string, or a sequence of strings that when joined form a path string,
     * to a Path instance.
     * Path path = Paths.get("baeldung/tutorial.txt");
     */
    @Test
    public void testPathInterface() {
        Path relative = Paths.get("JavFile.txt");
        System.out.println("Relative path: " + relative);
        Path absolute = relative.toAbsolutePath();
        System.out.println("Absolute path: " + absolute);
    }

    @Test
    public void testPathInterfaceB() {
        /** resolve() method
         * We can resolve complex paths using multiple arguments:
         And we can achieve the same result by chaining the resolve() method:                                                                   */
        File file = new File("baeldung", "tutorial.txt");
        Path path = Paths.get("baeldung", "tutorial.txt");
        Path path2 = Paths.get("baeldung").resolve("tutorial.txt");
        System.out.println(path2.toString());
    }

    @Test
    public void testPathInterfaceC() {
        /** toPath() and toFile() methods
         * Moreover, we can convert objects between APIs using toPath() and toFile() methods:                                                  */
        File file = new File("tutorial.txt").getAbsoluteFile();
        // Path path = Paths.get("baeldung", "tutorial.txt");
        Path pathFromFile = file.toPath();
        File fileFromPath = pathFromFile.toFile();
        System.out.println(pathFromFile);
        System.out.println(fileFromPath);
    }

    @Test
    public void testPathInterfaceD() {
        /** exists() and notExists() methods
         We can have a Path instance representing a file or a directory on the file system.
         Whether that file or directory it’s pointing to exists or not, is accessible or not, can be confirmed by a file operation.
         To check if a file exists, we use the exists() API.                                                                                    */
        Path p = Paths.get("/Users/ghislainmuabila/FileClassTemp/JavFile.txt");
        assertTrue(Files.exists(p));
        System.out.println();
        /** notExists() method
         To check that a file does not exist, we use the notExists() API:                                                                      */
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/inexistent_file.txt");
        assertTrue(Files.notExists(path));
        System.out.println(path);
    }

    @Test
    public void testPathInterfaceE() {
        /** isRegularFile() method
         We can also check if a file is a regular file like myfile.txt or is just a directory, we use the isRegularFile() API:                      */
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp");
        assertFalse(Files.isRegularFile(path));
    }

    @Test
    public void testPathInterfaceF() {
        /** isReadable() and isWritable() methods
         There are also static methods to check for file permissions. To check if a file is readable, we use the isReadable() API:                  */
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/JavFile.txt");
        assertTrue(Files.isReadable(path));
        System.out.println();
        //fileTwo.txt below is not set to readable
        Path p = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirFTwo/fileTwo.txt");
        assertFalse(Files.isReadable(p));
        System.out.println();
        /** isWritable() method
         To check if it is writable, we use the isWritable() API:                                                                                   */
        Path path1 = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirFTwo/fileTwo.txt");
        assertTrue(Files.isWritable(path1));
    }

    @Test
    public void testPathInterfaceG() {
        /** isExecutable() method
         Similarly, to check if a file is executable:                                                                                               */
        Path p = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirParent"); //a file is not executable? It seems only folders are executable.
        assertTrue(Files.isExecutable(p));
    }

    @Test
    public void testPathInterfaceH() {
        /** isSameFile() method
         When we have two paths, we can use isSameFile(Path p1, Path p2) to check if they both point to the same file on the underlying file system:                                    */
        Path p1 = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirFTwo/fileTwo.txt");
        Path p2 = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirFTwo/" + "/fileTwo.txt");
        try {
            assertTrue(Files.isSameFile(p1, p2));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testPathInterfaceI() {
        /** createFile() method
         The file system API provides single line operations for creating files.
         To create a regular file, we use the createFile() API and pass to it a Path object representing the file we want to create.
         All the name elements in the path must exist, apart from the file name, otherwise, we will get an IOException.                            */
        String fileName = "myfile_" + UUID.randomUUID() + ".txt";
        System.out.println("Filename: " + fileName);
        Path p = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/" + fileName);
        assertFalse(Files.exists(p));
        try {
            Files.createFile(p);
        } catch (IOException e) {
            fail("File not created " + "An exception occurred ");
        }
        assertTrue(Files.exists(p));
        System.out.println(p);
    }

    @Test
    public void testPathInterfaceI1(){
        /** createFile() method                                                                                                             */
        //initialize Path object
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirFTwo/createFile.txt");
        //create file
        try {
            Path createdFilePath = Files.createFile(path);
            System.out.println("Created a file at : " + createdFilePath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPathInterfaceI2() {
        /** createDirectory() method
         To create a directory, we use the createDirectory() API.                                                                               */
        String dirName = "myDir_" + UUID.randomUUID().toString();
        System.out.println(dirName);
        Path p = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/" + dirName);
        assertFalse(Files.exists(p));
        try {
            Files.createDirectory(p);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(Files.exists(p));
        assertFalse(Files.isRegularFile(p));
        assertTrue(Files.isDirectory(p));
        System.out.println(p.toAbsolutePath());
    }

    @Test
    public void testPathInterfaceI3() {
        /** createDirectory() method
         This operation requires that all name elements in the path exist, if not, we get an IOException:                                        */
        String dirName = "myDir_" + UUID.randomUUID().toString() + "/subdir";//"Users/ghislainmuabila/FileClassTemp/myDir_9b5a3491-177b-44fd-879b-2bfc8b98c75a/subdir" does not exist, causing an Exception.
        Path p = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/" + dirName);
        System.out.println(p);
        assertFalse(Files.exists(p));
        try {
            Files.createDirectory(p);
        } catch (IOException e) {
            fail("File not created " + "Due to an error");
        }
        //An Exception is thrown. An element in the path does not exist.  The forward slash in "/subbir" turns the dirName into a directory that
        //does not exist ""myDir_" + UUID.randomUUID().toString()".  When the code is run, we get one of the following path:
        //"Users/ghislainmuabila/FileClassTemp/myDir_9b5a3491-177b-44fd-879b-2bfc8b98c75a/subdir".
        //Therefore, /myDir_9b5a3491-177b-44fd-879b-2bfc8b98c75a/, is not an existing Directory and an Exception is thrown.
    }

    @Test
    public void testPathInterfaceI4() {
        /** createDirectories() method
         If we desire to create a hierarchy of directories with a single call, we use the createDirectories() method.
         Unlike the previous operation, when it encounters any missing name elements in the path, it does not throw an IOException,
         it creates them recursively leading up to the last element.                                                                              */
        Path dir = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/myDirTwo_" + UUID.randomUUID().toString());
        Path subdir = dir.resolve("subdir");
        System.out.println(subdir);
        assertFalse(Files.exists(dir));
        assertFalse(Files.exists(subdir));
        try {
            Files.createDirectories(subdir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(Files.exists(dir));
        assertTrue(Files.exists(subdir));
        System.out.println(subdir);
    }

    @Test
    public void testPathInterfaceJ() {
        /** delete() method
         To delete a file, we use the delete() API.
         For clarity purpose, the following test first ensures that the file does not already exist,
         then creates it and confirms that it now exists and finally deletes it and confirms that it’s no longer existent.
         However, if a file is not existent in the file system, the delete operation will fail with an IOException                              */
        Path p = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/fileToDelete.txt");
        assertFalse(Files.exists(p));
        System.out.println(p);
        try {
            Files.createFile(p);
            assertTrue(Files.exists(p));
            Files.delete(p);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertFalse(Files.exists(p));
    }

    @Test
    public void testPathInterfaceJ2() {
        /** delete() method
         If a file is not existent in the file system, the delete operation will fail with an IOException                               */
        Path p = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/inexistentFile.txt");
        System.out.println(p);
        assertFalse(Files.exists(p));
        try {
            Files.delete(p);
        } catch (IOException e) {
            fail("An error occurred " + "File does not exist");
        }
    }

    @Test
    public void testPathInterfaceJ3() {
        /** deleteIfExists() method
         We can avoid the above scenario by using deleteIfExists() method which fails silently in case the file does not exist.
         This is important when multiple threads are performing this operation, and we don’t want a failure message simply because a
         thread performed the operation earlier than the current thread which has failed.                                                       */
        Path p = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/inexistentFile.txt");
        assertFalse(Files.exists(p));
        try {
            Files.deleteIfExists(p);
        } catch (IOException e) {
            fail("An error occurred " + "File not found");
        }
    }

    @Test
    public void testPathInterfaceJ4() {
        /** deleting a Directory
         When dealing with directories and not regular files, we should remember that the delete operation does not work recursively by default.
         So, if a directory is not empty it will fail with an IOException.                                                                      */
        Path dir = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/emptyDir" + UUID.randomUUID());
        try {
            Files.createDirectory(dir);
        } catch (IOException e) {
            fail("An error occurred " + "Cannot create a Directory");
        }
        assertTrue(Files.exists(dir));
        Path file = dir.resolve("file.txt");
        try {
            Files.createFile(file);
            Files.delete(dir);
        } catch (IOException e) {
            System.err.println("I/O Error when copying file");  //Try: System.err.format("I/O Error when copying file");
        }
        assertTrue(Files.exists(dir));
    }

    @Test
    public void testPathInterfaceK() {
        /** copy() method
         You can copy a file or directory by using the copy() API.                                                                          */
        Path dir1 = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/firstdir_" + UUID.randomUUID().toString());
        Path dir2 = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/otherdir_" + UUID.randomUUID().toString());
        try {
            Files.createDirectory(dir1);
            Files.createDirectory(dir2);
        } catch (IOException e) {
            fail("An error occurred while " + "trying to create a Directory");
        }
        Path file1 = dir1.resolve("filetocopy.txt");
        Path file2 = dir2.resolve("filetocopy.txt");
        try {
            Files.createFile(file1);
            assertTrue(Files.exists(file1));
            assertFalse(Files.exists(file2));
            Files.copy(file1, file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(Files.exists(file2));
    }

    @Test(expected = FileAlreadyExistsException.class)
    public void testPathInterfaceL() {
        /** copy() method
         The copy() method fails if the target file exists unless the REPLACE_EXISTING option is specified.
         However, when copying directories, the contents are not copied recursively.
         This means that if /baeldung contains /articles.db and /authors.db files,
         copying /baeldung to a new location will create an empty directory.                                                                    */
        Path dir1 = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/firstdir_" + UUID.randomUUID().toString());
        Path dir2 = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/otherdir_" + UUID.randomUUID().toString());
        try {
            Files.createDirectory(dir1);
            Files.createDirectory(dir2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path file1 = dir1.resolve("filetocopy.txt");
        Path file2 = dir2.resolve("filetocopy.txt");
        try {
            Files.createFile(file1);
            Files.createFile(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(Files.exists(file1));
        assertTrue(Files.exists(file2));
        try {
            Files.copy(file1, file2);
            Files.copy(file1, file2, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file2);
    }

    @Test
    public void testPathInterfaceM() {
        /** move() method
         You can move a file or directory by using the move() API. It is in most ways similar to the copy() operation.
         If the copy() operation is analogous to a copy and paste operation in GUI based systems, then move() is analogous to
         a cut and paste operation.                                                                                                         */
        Path dir1 = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/firstdir_" + UUID.randomUUID());
        Path dir2 = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/otherdir_" + UUID.randomUUID());
        try {
            Files.createDirectory(dir1);
            Files.createDirectory(dir2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path file1 = dir1.resolve("filetocopy.txt");
        Path file2 = dir2.resolve("filetocopy.txt");
        try {
            Files.createFile(file1);
            assertTrue(Files.exists(file1));
            assertFalse(Files.exists(file2));
            Files.move(file1, file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(Files.exists(file2));
        assertFalse(Files.exists(file1));
    }

    @Test
    public void testPathInterfaceN() {
        /** move() method
         The move() operation fails if the target file exists unless the REPLACE_EXISTING option is
         specified just like we did with the copy() operation.                                                                                 */
        Path dir1 = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/ftDir_" + UUID.randomUUID());
        Path dir2 = Paths.get("/Users/ghislainmuabila/FileClassTemp/" + "/otDir_" + UUID.randomUUID());
        try {
            Files.createDirectory(dir1);
            Files.createDirectory(dir2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path file1 = dir1.resolve("filetocopy.txt");
        Path file2 = dir2.resolve("filetocopy.txt");
        try {
            Files.createFile(file1);
            Files.createFile(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(Files.exists(file1));
        assertTrue(Files.exists(file2));
        try {
            Files.move(file1, file2);
            Files.move(file1, file2, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(Files.exists(file2));
        assertFalse(Files.exists(file1));
    }

    @Test
    public void testPathInterfaceO() {
        /** Important methods of Path Interface                                                                                         */
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile");
        FileSystem fs = path.getFileSystem();
        System.out.println("File System: " + fs);
        System.out.println("path.isAbsolute(): " + path.isAbsolute());
        System.out.println("getFileName: " + path.getFileName());
        System.out.println("Absolute Path: " + path.toAbsolutePath());
        System.out.println("getRoot(): " + path.getRoot());
        System.out.println("getParent(): " + path.getParent());
        System.out.println("getNameCount(): " + path.getNameCount());
        System.out.println("getName(1): " + path.getName(1));
        System.out.println("path.subpath(0, 2): " + path.subpath(0, 2));
        System.out.println("Path: " + path);
        try {
            Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            System.out.println("realPath: " + realPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String originalPath = "/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile2.json";
        Path path1 = Paths.get(originalPath);
        Path path2 = path1.normalize();
        System.out.println("path2 = " + path2);
    }

    @Test
    public void testPathInterfaceP() {
        Path sourceFile = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile");
        Path targetFile = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirFolder/ChildFile");
        try {
            Files.copy(sourceFile, targetFile,
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.err.format("I/O Error when copying file");
        }
        Path wiki_path = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirFolder/ChildFile");
        Charset charset = Charset.forName("ISO-8859-1");
        try {
            List<String> lines = Files.readAllLines(wiki_path, charset);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testPathInterfaceQ(){
        /** We may get the file attribute metadata as follows:                                                                                     */
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile6.txt");
        BasicFileAttributes a = null;
        try {
            a = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException e) {
            System.err.println(e);
        }
        System.out.println(path.getFileName() + " created at " + a.creationTime());
        System.out.println(path.getFileName() + " size is " + a.size() + " bytes.");
        System.out.println(path.getFileName() + " last accessed at " + a.lastAccessTime());
        System.out.println(path.getFileName() + " last modified at " + a.lastModifiedTime());
        System.out.println(path.getFileName() + " is a " + (a.isDirectory() ? "directory" : "file"));
        System.out.println(path.getFileName() + " " + (a.isRegularFile() ? "is a regular File" : "is not a regular file"));
        System.out.println(path.getFileName() + " " + (a.isSymbolicLink() ? "is a symbolic link" : "is not a symbolic link"));
    }

}




