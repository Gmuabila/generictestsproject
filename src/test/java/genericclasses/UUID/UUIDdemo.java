package genericclasses.UUID;

import org.junit.Test;

import java.util.UUID;

public class UUIDdemo {
    /** UUID class
     A UUID (Universally Unique Identifier) code is a 128-bit long number in hex characters separated by “-“ .
     It is  occasionally referred to as GUID (Globally Unique Identifier).
     Example:
     e58ed763-928c-4155-bee9-fdbaaadc15f3
     A standard UUID code contains 32 hex digits along with 4 “-” symbols, which makes its length equal to 36 characters.
     There is also a Nil UUID code where all bits are set to zero. The java.util.UUID class represents an immutable universally unique identifier (UUID).
     The more convenient way to create a UUID without giving any parameter as input is using the randomUUID() method, this creates a version 4 UUID:
     UUID uuid = UUID.randomUUID();                                                                                                             */
    @Test
    public void testUUID() {
        UUID uuid = UUID.randomUUID(); //Generates random UUID
        System.out.println(uuid);
    }
}
