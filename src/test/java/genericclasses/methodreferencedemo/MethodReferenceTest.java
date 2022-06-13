package genericclasses.methodreferencedemo;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceTest {

    @Test
    public void methodReferenceTesting(){
        List<String> messages = Arrays.asList("hello", "my", "dear", "friend");

//       messages.forEach(word -> StringUtils.capitalize(word));  //Does not convert Strings to Uppercase. To investigate.
//       System.out.println(messages);

//        messages.forEach(word -> word.toUpperCase());  //Does not convert Strings to UpperCase.  To investigate.
//        System.out.println(messages);

        List<String> messagesToUpperCase = messages.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(messagesToUpperCase);
    }
}
