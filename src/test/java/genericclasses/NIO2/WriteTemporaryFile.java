package genericclasses.NIO2;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class WriteTemporaryFile {
    /** Write to a Temporary File
     Now let’s try to write to a temporary file. The following code creates a temporary file and writes a String to it:                             */
    @Test
    public void testWriteTemporaryFile() {
        String toWrite = "Hello";
        try {
            File tmpFile = File.createTempFile("/Users/ghislainmuabila/FileClassTemp/TestDIRThree/tempFile", ".tmp");
            FileWriter writer = new FileWriter(tmpFile);
            writer.write(toWrite);
            writer.close();
            BufferedReader reader = new BufferedReader(new FileReader(tmpFile));
            assertEquals(toWrite, reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
