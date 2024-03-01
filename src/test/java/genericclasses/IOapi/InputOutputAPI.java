package genericclasses.IOapi;

import org.junit.Test;

import java.io.*;
import java.lang.module.FindException;

public class InputOutputAPI {
    /** Java IO (Input Output) API
     ---------------------------------------------
     Most applications need to process some input and produce some output based on that input. For instance, read data from a file or
     over the network, and write to a file or write a response back over the network.
     The Java IO API defines classes required to perform I/O operations.  These classes are used for reading and writing data (input and output).
     All the I/O classes are packaged in the java.io namespace.  Java I/O (Input and Output) is used to process the input and produce the output.
     Java uses the concept of stream to make I/O operation fast.
     Input and Output
     Java IO basically provides a mechanism to read data from a source and write data to a destination. Input represents the source while
     output represents the destination.  These sources and destinations can be anything from Files, Pipes to Network Connections.
     Java's IO package mostly concerns itself with the reading of raw data from a source and writing of raw data to a destination.
     The most typical sources and destinations of data are these:
     •	Files
     •	Pipes
     •	Network Connections
     •	In-memory Buffers (e.g., arrays)
     •	System.in, System.out, System.error
     A stream is a sequence of data. In Java, a stream is composed of bytes. Java IO provides the concept of streams which basically represents a
     continuous flow of data. Streams can support many different types of data like bytes, characters, objects, etc.  Moreover, connection to a
     source or a destination is what a stream represents. They hence come as either InputStream or OutputStream respectively.
     In Java, 3 streams are created for us automatically. All these streams are attached with the console.
     •	System.out: standard output stream
     •	System.in: standard input stream
     •	System.err: standard error stream
     OutputStream:
     Java application uses an output stream to write data to a destination; it may be a file, an array, peripheral device, or socket.
     InputStream:
     Java application uses an input stream to read data from a source; it may be a file, an array, peripheral device, or socket.                */
    @Test
    public void testFileOutputStreamClass(){
        /** FileOutputStream class
         The FileOutputStream class is an outputstream used for writing data to a file. It is an outputstream for writing data/streams of
         raw bytes to file or storing data to file. FileOutputStream is a subclass of OutputStream. To write primitive values into a file,
         we use FileOutputStream class. For writing byte-oriented and character-oriented data, we can use FileOutputStream but for
         writing character-oriented data, FileWriter is more preferred.
         flush() method
         The flush() method of OutputStream class is used to flush the content of the buffer to the output stream. A buffer is a portion in
         memory that is used to store a stream of data(characters). That data sometimes will only get sent to an output device when the buffer is full.
         Syntax: public void flush() throws IOException
         Throws: IOException- If an I/O error occurs.

         Steps to write data to a file using FileOutputStream
         -----------------------------------------------------
         First, attach a file path to a FileOutputStream as shown here:
         FileOutputStream  fout = new FileOutputStream(“file1.txt”);
         This will enable us to write data to the file. Then, to write data to the file, we should write data using the FileOutputStream as:
         fout.write();
         Then we should call the close() method to close the fout file:
         fout.close()                                                                                                                           */
        try{
            FileOutputStream fout = new FileOutputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile");
            fout.write('B');
            fout.close();
            System.out.println("success...");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testFileOutputStreamB(){
        /** FileOutputStream class                                                                                                      */
        try{
            FileOutputStream fout = new FileOutputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile");
            String str = "Welcome to javaMastering, this is GTech trying things out..\n";
            byte bts[] = str.getBytes();  //converting string into byte array
            fout.write(bts);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){
            System.out.println(e);
        }

    }

    @Test
    public void testFileOutputStreamB2(){
        /** FileOutputStream class                                                                                                      */
        try{
            FileOutputStream fout = new FileOutputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile");
            String str = "Welcome to javaMastering, this is GTech trying things out..\n";
            String strTwo = "Use this as the second line of our documents.\n";
            byte bts[] = str.getBytes();  //converting string into byte array
            byte[] btsTwo = strTwo.getBytes();
            fout.write(bts);
            fout.write(btsTwo);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){
            System.out.println(e);
        }

    }

    @Test
    public void testFileOutputStreamC() throws IOException {
        /** FileOutputStream class                                                                                                  */
        int i;
        File file = new File("/Users/ghislainmuabila/FileClassTemp/DirParent/TestFile.txt");
        System.out.println("File created: " + file.createNewFile());
        // create a fileoutputstream object
        FileOutputStream fout = new FileOutputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/TestFile.txt");
        // we need to transfer this string to files
        String str = "TATA";
        char ch[] = str.toCharArray();
        for (i = 0; i < ch.length; i++) {
            // we will write the string by writing each
            // character one by one to file
            fout.write(ch[i]);
        }
        // by doing fout.close() all the changes which have
        // been made till now in RAM had been now saved to
        // hard disk
        fout.close();
    }

    @Test
    public void testFileOutputStreamD(){
        /** Write() Method
        write(): this writes the single byte to the file output stream.
        write(byte[] array): this writes the specified array’s bytes to the output stream.
        write(byte[] array, int start, int length): this writes the number of bytes equal to length to the
        output stream from an array starting from the position start.                                                                   */
        String data = "Welcome to Input Output API";
        try {
            FileOutputStream output = new FileOutputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/TestFile.txt");
            // The getBytes() method used converts a string into bytes array.
            byte[] arrByte = data.getBytes();
            // writing the string to the file by writing each character one by one
            // Writes byte to the file
            output.write(arrByte);
            output.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Test
    public void testFileOutputStreamE(){
        /** flush() method
         The flush() method of the OutputStream class is used to flush the content of the buffer to the output stream.
         A buffer is a portion in memory that is used to store a stream of data(characters). That data sometimes will only get sent to
         an output device when the buffer is full.
         Flush: to clean, rinse, or empty with a rapid flow of a liquid, especially water: flush a toilet; flush a wound with iodine.
         Buffer: In computer science, a data buffer (or just buffer) is a region of a memory used to store data temporarily while it is
         being moved from one place to another.
         Syntax: public void flush() throws IOException
         Specified By: flush in interface Flushable
         Throws: IOException- If an I/O error occurs.                                                                                               */
        try {
            OutputStream outSteam = new FileOutputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile");
            InputStream inStream = new FileInputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/ChildFile");
            outSteam.write('A');   //Writes A to the file “ChildFile”
            outSteam.flush();
            outSteam.write('B');   //Writes B to the same file above
            System.out.println("" + (char) inStream.read());     //Outputs ‘A’
            System.out.println("" + (char) inStream.read());     //Outputs ‘B’
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testFileOutputStreamF(){
        /**Close() method
         This method closes the FileOutputStream. Once it is called, we cannot use any other methods.                                       */
        FileOutputStream out = null;
        String data = "Welcome to GfG";
        try {
            out = new FileOutputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/flush.txt");  //If the file does not exist, it will be created.
            // Using write() method
            out.write(data.getBytes());
            // Using the flush() method
            out.flush();
            out.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Test
    public void testFileInputStream(){
        /** FileInputStream Class
         The FileInputStream class is used to read data from a file in the form of sequence of bytes.
         The FileInputStream class obtains input bytes from a file. It is used for reading byte-oriented data (streams of raw bytes) such as
         image data, audio, video etc. You can also read character-stream data. But, for reading streams of characters,
         it is recommended to use FileReader class.
         Syntax: public class FileInputStream extends InputStream

         Constructors of FileInputStream Class
         --------------------------------------
         FileInputStream(File file): Creates an input file stream to read from the specified File object.
         FileInputStream(FileDescriptor fdobj): Creates an input file stream to read from the specified file descriptor.
         FileInputStream(String name): Creates an input file stream to read from a file with the specified name.

         Steps to read data from a file using FileInputStream
         -------------------------------------------------------
         Attach a file to a FileInputStream as this will enable us to read data from the file:
         FileInputStream  fileInputStream = new FileInputStream(“file.txt”);
         Now in order to read data from the file, we should read data from the FileInputStream as shown below:
         Ch = fileInputStream.read();
         When there is no more data available to read further, the read() method returns -1;
         Then we should attach the monitor to the output stream. For displaying the data, we can use System.out.print:
         System.out.print(ch);                                                                                                                  */
        //Read a Single Character
        try{
            FileInputStream fin = new FileInputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/TestFile.txt");
            int i = fin.read();   //Reads just the first character of the text in the file.
            System.out.print((char)i);
            fin.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testFileInputStreamB(){
        /** FileInputStream class
         Read all Characters                                                                                                                    */
        try{
            FileInputStream fin = new FileInputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/TestFile.txt");
            int i = 0;
            while((i = fin.read())!=-1){
                System.out.print((char)i);
            }
            fin.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void TestFileInputStreamC(){
        /** FileInputStream class                                                                                                   */
        // Attaching the file to FileInputStream
        try {
            FileInputStream fin = new FileInputStream("/Users/ghislainmuabila/FileClassTemp/DirParent/TestFile.txt");
            // Illustrating getChannel() method
            System.out.println(fin.getChannel());
            // Illustrating getFD() method
            System.out.println(fin.getFD());
            // Illustrating available method
            System.out.println("Number of remaining bytes: "
                    + fin.available());
            // Illustrating skip() method
            fin.skip(4);
            // Display message for better readability
            System.out.println("FileContents :");
            // Reading characters from FileInputStream
            // and write them
            int ch;
            // Holds true till there is data inside file
            while ((ch = fin.read()) != -1)
                System.out.print((char) ch);
            // Close the file connections
            // using close() method
            fin.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
