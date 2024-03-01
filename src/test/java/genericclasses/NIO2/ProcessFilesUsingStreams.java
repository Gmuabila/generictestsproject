package genericclasses.NIO2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.fail;

public class ProcessFilesUsingStreams {
    /** Processing Files with Java 8 Streams
     -------------------------------------------
     Streams, introduced in Java 8, use functional-style operations to process data declaratively. The elements of streams are
     consumed from data sources such as collections, arrays, or I/O resources like files. Streams can be used to make life easier when
     it comes to handling files.
     Converting files to streams helps us to easily perform many useful operations like
     •	counting words in the lines,
     •	filtering files based on conditions,
     •	removing duplicates from the data retrieved,
     •	and others.
     First, let us see how we can obtain streams from files.
     Building Streams from Files
     ----------------------------
     We can get a stream from the contents of a file line by line by calling the lines() method of the Files class.                                 */
    @Test
    public void testProcessFilesUsingStreams(){
        /**  Using Files.lines() method to get a stream from a file:
         The lines() method takes the Path representing the file as an argument. This method does not read all lines into a List,
         but instead populates lazily as the stream is consumed and this allows efficient use of memory.
         The output will be the contents of the file itself.                                                                                          */
       try {
           Stream<String> lines = Files.lines(Path.of("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt"));
                  //Can also use: Files.lines(Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt"));
           lines.forEach(System.out::println);
       }catch (IOException e){
           System.err.println("An IO occurred when reading the file");
        }
    }

    @Test
    public void testProcessFilesUsingStreamsB(){
        /** Using BufferedReader.lines() method to get a stream from a file.
         The same results can be achieved by invoking the lines() method of BufferedReader.                                                         */
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt"));
            Stream<String> lines = br.lines();
            lines.forEach(System.out::println);
        }catch (IOException e){
            fail("An error occurred while reading the file");
        }
        /** As streams are lazy-loaded in the above cases (i.e. they generate elements upon request instead of storing them all in memory),
        reading and processing files will be efficient in terms of memory used.                                                                         */
    }

    @Test
    public void testProcessFilesUsingStreamsC(){
        /** Using BufferedReader.lines() method to get a stream from a file.                                                                            */
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt"))) {
            reader.lines().forEach(System.out::println);
        }catch (IOException e){
            fail("An error occurred while reading the file");
        }
    }

    @Test
    public void testProcessFilesUsingStreamsD(){
        /** Using Files.readAllLines() method to get a stream from a file.
         The Files.readAllLines() method can also be used to read a file into a List of String objects.
         It is possible to create a stream from this collection, by invoking the stream() method on it.
         However, this method loads the entire contents of the file in one go and hence is not memory efficient like the Files.lines() method.         */
        try {
            List<String> strList = Files.readAllLines(Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt"));
                   //Can also use: Files.readAllLines(Path.of("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt"));
            Stream<String> lines = strList.stream();
            lines.forEach(System.out::println);
        }catch (IOException e){
            System.err.println("An IO error has occurred while reading the file");
        }
    }

    @Test
    public void testProcessFilesUsingStreamsE(){
        /** Importance of try-with-resources
         The try-with-resources syntax provides an exception handling mechanism that allows us to declare resources to
         be used within a Java try-with-resources block. When the execution leaves the try-with-resources block,
         the used resources are automatically closed in the correct order (whether the method successfully completes,
         or any exceptions are thrown). We can use try-with-resources to close any resource that implements either AutoCloseable or Closeable.
         Streams are AutoCloseable implementations and need to be closed if they are backed by files.                                               */
        try (Stream<String> lines = Files.lines(Path.of("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt"))) {
            lines.forEach(System.out::println);
        }catch (IOException e){
            System.err.println("An error occurred while reading files");
        }
        System.out.println();

        try (Stream<String> lines =
                     Files.newBufferedReader(Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt"))
                             .lines()) {
            lines.forEach(System.out::println);
        }catch (IOException e){
            System.err.println("An error occurred while reading files");
        }
        System.out.println();

        try(Stream<String> lines = (Files.readAllLines(Paths.get("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt"))).stream()){
            lines.forEach(System.out::println);
        }catch (IOException e){
            System.err.println("An error occurred while reading this file");
        }
        System.out.println();

        try(Stream<String> lines = new BufferedReader(new FileReader("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/childFile4.txt")).lines()){
            lines.forEach(System.out::println);
        }catch (IOException e){
            System.err.println("An error occurred while reading the file");
        }
    }

    @Test
    public void testProcessFilesUsingStreamsF() {
        /** Using Parallel Streams
         By default, streams are serial, meaning that each step of a process is executed one after the other sequentially.
         Streams can be easily parallelized, however this means that a source stream can be split into multiple sub-streams executing in parallel.
         Each sub-stream is processed independently in a separate thread and finally merged to produce the final result.
         The parallel() method can be invoked on any stream to get a parallel stream.                                                               */
        try (Stream<String> lines = Files.lines(Path.of("/Users/ghislainmuabila/FileClassTemp/DirFTwo/bookIndex.txt"))
                .parallel()) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("An error occurred while reading this file");
        }
        /** You will notice that the stream elements are printed in random order. This is because the order of the elements is not
         maintained when forEach() is executed in the case of parallel streams. Parallel streams may perform better only if there is a
         large set of data to process. In other cases, the overhead might be more than that for serial streams. Hence, it is advisable to
         go for proper performance benchmarking before considering parallel streams.                                                                 */
    }

    @Test
    public void testProcessFilesUsingStreamsG(){
        /** Reading UTF-Encoded Files
         What if you need to read UTF-encoded files?
         All the above methods have overloaded versions that take a specified charset also as an argument.
         Consider a file named input.txt with Japanese characters:
         akarui     	_ あかるい  _   bright
         Let us see how we can read from this UTF-encoded file:                                                                                     */
        try (Stream<String> lines = Files.lines(Path.of("/Users/ghislainmuabila/FileClassTemp/dirLog/fileOne.txt"), StandardCharsets.UTF_8)) {
            lines.forEach(System.out::println);
        }catch (IOException e){
            System.err.println("An IO error occurred while reading this file");
        }
        //Note: can also use "Charset.forName("UTF8")" in place of "StandardCharsets.UTF_8".
        //Also note that all other Charset are unable to read the japanese text apart from UTF8.
    }

    @Test
    public void testProcessFilesUsingStreamsH(){
        /** We could also have used the overloaded version of BufferedReader for reading the file:                                                  */
        try(Stream<String> lines = Files.newBufferedReader(Paths.get("/Users/ghislainmuabila/FileClassTemp/dirLog/fileOne.txt"), StandardCharsets.UTF_8).lines()){
            lines.forEach(System.out::println);
        }catch (IOException e){
            System.err.println("An IO error occurred while reading this file");
        }
    }

    @Test
    public void testProcessFilesUsingStreamsI(){

    }

    @Test
    public void testProcessFilesUsingStreamsJ(){
        try (Stream<String> lines = Files.lines(Path.of("/Users/ghislainmuabila/FileClassTemp/DirFTwo/bookIndex.txt"))) {
            Stream<String> words = lines
                    .flatMap(line -> Stream.of(line.split("\\W+")));
            Set<String> wordSet = words.collect(Collectors.toSet());
            System.out.println(wordSet);
        }catch (IOException e){
            System.err.println("An IO error occurred while reading the file");
        }


    }


}
