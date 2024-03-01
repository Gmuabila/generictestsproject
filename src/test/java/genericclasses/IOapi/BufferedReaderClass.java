package genericclasses.IOapi;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BufferedReaderClass {
    /** Java.io.BufferedReader Class
     -------------------------------
     The Java.io.BufferedReader is a class which simplifies reading text from a character input stream.
     It buffers the characters in order to enable efficient reading of text data. BufferedReader reads text from a character-input stream,
     buffering characters so as to provide for the efficient reading of characters, arrays, and lines. The buffer size may be specified,
     or the default size may be used. The default is large enough for most purposes. In general, each read request made by a
     Reader causes a corresponding read request to be made of the underlying character or byte stream. It is therefore advisable to
     wrap a BufferedReader around any Reader whose read() operations may be costly, such as FileReaders and InputStreamReaders.
     Programs that use DataInputStreams for textual input can be localized by replacing each DataInputStream with an appropriate BufferedReader.
     Constructors of BufferedReader Class:
     BufferedReader(Reader in)
     Creates a buffering character-input stream that uses a default-sized input buffer.
     BufferedReader(Reader in, int sz)
     Creates a buffering character-input stream that uses an input buffer of the specified size.
     When to Use BufferedReader:
     In general, BufferedReader comes in handy if we want to read text from any kind of input source whether that be files, sockets,
     or something else. Simply put, BufferedReader enables us to minimize the number of I/O operations by reading chunks of characters and
     storing them in an internal buffer. While the buffer has data, the reader will read from it instead of directly from the underlying stream.
     BufferedReader expects a Reader in its constructor. In this way, it enables us to flexibly extend an instance of a Reader implementation with
     buffering functionality:
     BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.txt"));
     But, if buffering doesn’t matter to us, we could just use a FileReader directly:
     FileReader reader = new FileReader("src/main/resources/input.txt");
     Buffering a Stream:
     In general, we can configure BufferedReader to take any kind of input stream as an underlying source.
     We can do it using InputStreamReader and wrapping it in the constructor:
     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     In the above example, we are reading from System.in which typically corresponds to the input from the keyboard.                              */
    @Test
    public void testBufferedReader() throws IOException {
        /** Reading Text With BufferedReader Line-by-line                                                                                                      */
        BufferedReader reader = new BufferedReader(new FileReader("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile"));
        String resultText = readAllLines(reader);
        System.out.println(resultText);

    }

    public String readAllLines(BufferedReader reader) throws IOException {
        /** Reading text Line-by-Line                                                                                                           */
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }
        return content.toString();
    }

    @Test
    public void testBufferedReaderB(){
        /** We can do the same thing as above using the lines() method introduced in Java 8 a bit more simply.
         After using the BufferedReader, we have to call its close() method to release any system resources associated with it.
         This is done automatically if we use a try-with-resources block.                                                                           */
        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile"))){
            String strResult = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            System.out.println(strResult);
        }catch (IOException e){
            e.printStackTrace();
        }
        /** The lines() method of BufferedReader class returns a Stream, the elements of which are lines read from this BufferedReader.
        The Stream is lazily populated, i.e., read only occurs during the terminal stream operation.
        Returns:a Stream<String> providing the lines of text described by this BufferedReader.                                                      */
    }

    public String readAllCharsOneByOne(BufferedReader reader) throws IOException {
        /** Reading a Single Character
         We can use the read() method to read a single character.
         Let’s read the whole content character-by-character until the end of the stream:                                                       */
         StringBuilder content = new StringBuilder();
        int value;
        while ((value = reader.read()) != -1) {
            content.append((char) value);
        }
        return content.toString();
    }

    @Test
    public void testBufferedReaderC() {
        /** Reading a Single Character                                                                                                             */
       try(BufferedReader reader = new BufferedReader(new FileReader("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile"))){
           String strResul = readAllCharsOneByOne(reader);
           System.out.println(strResul);

       }catch (FileNotFoundException e){
           e.printStackTrace();
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    @Test
    public void testBufferedReaderC2(){
        /** There is one more handy way to create a BufferedReader using the Files helper class from the java.nio API:
         BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/input.txt"))
         Creating it like this is a nice way to buffer if we want to read a file because we don’t have to
         manually create a FileReader first and then wrap it.                                                                                   */
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile");
         try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
            String str = null;
            while((str = reader.readLine())!= null){
                System.out.println(str);
            }
        }catch(IOException ex){
            System.err.println(ex);
        }
    }

    @Test
    public void testBufferedReaderD() {
        /** Skipping Characters
         We can also skip a given number of characters by calling the skip(long n) method.                                                      */
        StringBuilder result = new StringBuilder();
        int value;
        Path path = Paths.get("/Users/ghislainmuabila/FileClassTemp/skipFolder");
        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/ghislainmuabila/FileClassTemp/skipFolder/skipFile.txt"))) {
            System.out.println(Files.createDirectory(path));
            Path path2 = path.resolve("skipFile.txt");
            System.out.println(Files.createFile(path2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/ghislainmuabila/FileClassTemp/skipFolder/skipFile.txt"))) {
            while ((value = reader.read()) != -1) {
                result.append((char) value);
                reader.skip(2L);
            }
            System.out.println(result);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferedReaderE(){
        /** Mark() and reset() methods
         We can use the mark(int readAheadLimit) and reset() methods to mark some position in the stream and return to it later.                    */
        //As a somewhat contrived example, let’s use mark() and reset() to ignore all whitespaces at the beginning of a stream:
        String result = null;
        try (BufferedReader reader = new BufferedReader(new StringReader("    Lorem ipsum dolor sit amet."))) {
            do {
                reader.mark(1);
            } while(Character.isWhitespace(reader.read()));
            reader.reset();
            result = reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }
        assertEquals("Lorem ipsum dolor sit amet.", result);
    }
}
