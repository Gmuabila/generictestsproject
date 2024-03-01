package genericclasses.IOapi;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class FilenameFilterDemo {
    /** FilenameFilter interface
     Many times, we need to traverse and find all files with a certain name pattern to do some operations on those files,
     for example deleting those files. This is more often required when we want to delete all .log or .tmp files from the
     server after a certain time using the application. Java has had functional interfaces before the addition of the
     informative annotation, @FunctionalInterface.  FilenameFilter is one such interface.
     ** The FilenameFilter interface is used to list all files that satisfy the specified filter inside a directory.
     The overloaded list(..) and listFiles(..) methods in java.io.File take an instance of FilenameFilter and return an array of
     all files that satisfy the filter. FilenameFilter is a Functional Interface and has only one abstract method, the accept() method.
     We can use FilenameFilter to tests if a specified file should be included in a file list. To use FilenameFilter,
     override the accept(dir, name) method that contains the logic to check if the file has to be included in the filtered list.
     Syntax: boolean accept(File dir, String name);
     The accept() method takes two parameters:
     •	dir: directory in which the file was found
     •	name: the file name                                                                                                                 */
    @Test
    public void testFilenameFilter() {
        FilenameFilter filter = (dir, name) -> name.endsWith(".json");
        File directory = new File("/Users/ghislainmuabila/FileClassTemp/DirParent");
        String[] actualFiles = directory.list(filter);
        Arrays.stream(actualFiles).forEach(System.out::println);
    }

    @Test
    public void testFilenameFilterB(){
        /** FilenameFilter interface                                                                                                    */
        FilenameFilter filter = (dir, name) -> name.endsWith(".json");
        String[] expectedFiles = { "ChildFile2.json", "flush2.json", "TestFile.json" };
        File directory = new File("/Users/ghislainmuabila/FileClassTemp/DirParent");
        String[] actualFiles = directory.list(filter);
        assertArrayEquals(expectedFiles, actualFiles);
    }

    @Test
    public void testFilenameFilterC1(){
        //Create a folder with logfiles for the test below
        String[] filesArr = {"fileOne.txt", "fileTwo.log", "fileSeven.log", "testOne.txt", "testFour.log"};
        File dirLog = new File("/Users/ghislainmuabila/FileClassTemp/dirLog");
        System.out.println("Folder created: " + dirLog.mkdir());
        try {
            for(String str: filesArr){
                File logFile = new File(dirLog, str);
                System.out.println("File created: " + logFile.createNewFile());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFilenameFilterC2() throws IOException {
        String targetDirectory = "/Users/ghislainmuabila/FileClassTemp/dirLog";
        File dir = new File(targetDirectory);
        // FilenameFilter filterLog = (folder, name) -> name.endsWith(".log");
//Find out all log files
        String[] logFiles = dir.list(new LogFilenameFilter());
//If no log file found; no need to go further
        if (logFiles.length == 0)
            return;
//This code will delete all log files one by one
        for (String fileName: logFiles){
            String logFile = new StringBuffer(targetDirectory)
                    .append(File.separator)
                    .append(fileName)
                    .toString();
            Files.delete(Paths.get(logFile));
            System.out.println("Log file : " + logFile + " is deleted");
        }

    }
}
