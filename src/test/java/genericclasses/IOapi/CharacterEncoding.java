package genericclasses.IOapi;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class CharacterEncoding {
    /** Character Encoding
     ------------------------
     A character encoding is a set of mappings between the bytes in the computer and the characters in the character set.
     A character encoding provides a key to unlock (ie. crack) the code.  Without the key, the data looks like garbage.
     So, when you input text using a keyboard or in some other way, the character encoding maps characters you choose to
     specific bytes in computer memory, and then to display the text, it reads the bytes back into characters.
     Every character in every language needs to be mapped to a set of ones and zeros. To do this, we need to think about character encoding.
     ** Character set:
     --------------------
     Characters that are needed for a specific purpose are grouped into a character set (also called a repertoire).
     The characters are stored in the computer as one or more bytes. To refer to characters in an unambiguous way,
     each character is associated with a number called a code point.
     ** Unicode system:
     ---------------------
     The Unicode Standard is an international encoding standard that provides a unique number for every character, digits,
     and symbols, and now including Emojis no matter what platform, device, application, or language.
     It is a character code that defines every character in most of the speaking languages in the world.
     Unicode system is an international character encoding technique that can represent most of the languages around the world.
     •	Hexadecimal values are used to represent Unicode characters.
     •	There are multiple Unicode Transformation Formats:
            1.	UTF-8: It represents 8-bits (1 byte) long character encoding.
            2.	UTF-16: It represents 16-bits (2 bytes) long character encoding.
            3.	UTF-32: It represents 32-bits (4 bytes) long character encoding.
     Unicode code point
     --------------------
     Unicode is an encoding standard for characters and symbols which is able to represent characters from many different languages from
     around the world (Now including Emojis). Each character is represented by a Unicode code point. A code point is an integer value that
     uniquely identifies the given character. As mentioned, each Unicode character is represented by a Unicode code point which is an integer value.
     Examples:
     Character A -> Unicode = U+0041 -> Code point = 41 -> Code point in Decimal = 65
     Character B -> Unicode = U+0042 -> Code point = 42 -> Code point in Decimal = 66
     Character C -> Unicode = U+0043 -> Code point = 43 -> Code point in Decimal = 67
     Types of Encoding
     -------------------
     Following are the different types of encoding used before the Unicode system.
     •	ASCII (American Standard Code for Information Interchange): used for the United States
     •	ISO8859-1 used for the Western European Languages
     •	KOI8 used for Russian.
     •	GB18030 and BIG-5 used for Chinese and so on.
     •	Base64 used for binary to text encoding.
     Charset class
     -----------------------------------
     Charset is a mapping technique used in Java to map the 16-bit Unicode sequence and sequences of bytes.
     An object of the Charset class represents the encoding scheme.
     We can convert a Unicode character to a sequence of bytes and vice versa using an encoding scheme. The java.nio.charset package provides
     classes to encode/decode a CharBuffer to a ByteBuffer and vice versa.  It is also used to encode and decode the string data text into
     different character encoding. It comes under the java.nio.charset.Charset package. The CharsetEncoder class performs the encoding.
     The CharsetDecoder class performs the decoding. We can get an object of the Charset class using its forName() method by passing the name of
     the character set as its argument. For simple encoding and decoding tasks, we can use the encode() and decode() methods of the Charset class.
     The charset must begin with a number or letter. Every charset can decode and encode. For constructing a map that contains every charset,
     support is available in JVM.
     CharBuffer Class
     --------------------
     CharBuffer holds a sequence of integer values to be used in an I/O operation.
     ByteBuffer Class
     --------------------
     ByteBuffer holds a sequence of integer values to be used in an I/O operation.  The ByteBuffer is an abstract class,
     so we can’t construct a new instance directly.
     Wrap() method
     ------------------
     Syntax: public static CharBuffer wrap(CharSequence csq)
     The wrap() method of the CharBuffer class wraps a character sequence into a buffer.
     The content of the new, read-only buffer will be the content of the given character sequence.
     The new buffer's capacity and limit will be csq.length(), its position will be zero, and its mark will be undefined.
     Params: csq – The character sequence from which the new character buffer is to be created.
     Returns: The new character buffer                                                                                                              */
    @Test
    public void testCharacterEncoding() {
        //The following code shows how to encode a sequence of characters in the string "Hello" stored in a character buffer and
        //decode it using the UTF-8 encoding-scheme.
        Charset enCodSchem = Charset.forName("UTF8");
        CharBuffer charBuffer = CharBuffer.wrap("Welcome to Character Encoding");
        ByteBuffer byteBuffer = enCodSchem.encode(charBuffer);
        CharBuffer charBufferDecoded = enCodSchem.decode(byteBuffer);
        System.out.println(charBufferDecoded);
    }

    @Test
    public void testCharacterEncodingB() {
        //Chinese Character set able to decode Chinese text.
        Charset enCodSchem = Charset.forName("ASCII"); //KOI8, ISO8859-1, and ASCII are all unable to decode but all UTF can decode this chinese text.
        CharBuffer charBuffer = CharBuffer.wrap("䡥汬漠坯牬");
        ByteBuffer byteBuffer = enCodSchem.encode(charBuffer);
        CharBuffer charBufferDecoded = enCodSchem.decode(byteBuffer);
        System.out.println(charBufferDecoded);
    }

     public String decodeText(String input, String encoding) throws IOException {
        return new BufferedReader( new InputStreamReader( new ByteArrayInputStream(input.getBytes()), Charset.forName(encoding))).readLine();
    }
    @Test
    public void testCharacterEncodingC() throws IOException {
        System.out.println(decodeText("Hello World", "UTF16"));
    }

    /** Single-Byte Encoding
     One of the earliest encoding schemes, called ASCII (American Standard Code for Information Exchange) uses a single-byte encoding scheme.
     This essentially means that each character in ASCII is represented with seven-bit binary numbers. This still leaves one bit free in every byte!
     ASCII’s 128-character set covers English alphabets in lower and upper cases, digits, and some special and control characters.
     Let’s define a simple method in Java to display the binary representation for a character under a particular encoding scheme:                  */
    String convertToBinary(String input, String encoding)
            throws UnsupportedEncodingException {
        byte[] encoded_input = Charset.forName(encoding)
                .encode(input)
                .array();
        return IntStream.range(0, encoded_input.length)
                .map(i -> encoded_input[i])
                .mapToObj(e -> Integer.toBinaryString(e ^ 255))
                .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
                .collect(Collectors.joining(" "));
    }
    @Test
    public void testSingleByteEncoding() throws UnsupportedEncodingException {
        assertEquals(convertToBinary("T", "GB18030"), "01010100"); // Failing
    }
    @Test
    public void testSingleByteEncodingB() throws UnsupportedEncodingException {
        assertEquals(convertToBinary("語", "UTF8"), "11101000 10101010 10011110"); //Failing
    }

}
