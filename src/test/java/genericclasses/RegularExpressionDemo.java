package genericclasses;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegularExpressionDemo {
    //Regular Expression
    //A regular expression is a sequence of characters that forms a search pattern.
    //When you search for data in a text, you can use this search pattern to describe what you are searching for.
    //A regular expression can be a single character, or a more complicated pattern.  Regular expressions can be used to
    //perform all types of text search and text replace operations.  Java does not have a built-in Regular Expression class,
    //but we can import the java.util.regex package to work with regular expressions.
    //The package includes the following classes:
    //•	Pattern class: Defines a pattern (to be used in a search).  Pattern object is a compiled regex.
    // The Pattern class provides no public constructors.  To create a pattern, we must invoke its public static compile() method,
    // which will then return a Pattern object. This method accept a regular expression as the first argument.
    //•	Matcher class: is used to search for the pattern.  Matcher object interprets the pattern and
    // performs match operations against an input String. It also defines no public constructors.
    // We obtain a Matcher object by invoking the matcher method on a Pattern object.
    //•	PatternSyntaxException class: Indicates syntax error in a regular expression pattern.
    // PatternSyntaxException object is an unchecked exception that indicates a syntax error in a regular expression pattern.
    //
    //To use regular expressions in Java, we do not need any special setup. The JDK contains a special package java.util.regex
    //totally dedicated to regex operations. We only need to import it into our code.
    //Moreover, the java.lang.String class also has inbuilt regex support that we commonly use in our code.

    @Test
    public void regularExpressionDemo(){
        Pattern pattern = Pattern.compile("w3School", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Always go to W3School first to see.");
        boolean matchFound = matcher.find();
        if(matchFound){
            System.out.println("Match Found");
        }else {
            System.out.println("No Match Found");
        }
    }

    @Test
    public void regularExpressionMatchCount(){
        Pattern pattern = Pattern.compile("w3School", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Always go to W3School first to see w3School, and w3School, and always w3School.");
        int matchCount = 0;
        while (matcher.find()){
            System.out.println("Match Found");
            matchCount++;
        }
        System.out.println("Match count: " + matchCount);
    }

    @Test
    public void testRegexMatchCountDemo(){
        int returnedMatches = regexMatchCountTest("foo", "foofoofoofoofoot");
        assertEquals(5, returnedMatches);
    }

    @Test
    public void regexUsingDotMetaCh(){
        //Metacharacters
        //Metacharacters are characters with a special meaning, and they affect the way a pattern is matched,
        // in a way adding logic to the search pattern.  The Java API supports several metacharacters,
        // the most straightforward being the dot “.” which matches any character.
        int matches = regexMatchCountTest(".", "foofoofoo");
        System.out.println();
        System.out.println("Found " + matches + " Matches");
    }

    @Test
    public void regexUsingDotMetaCh2(){
        /*Notice the dot after the foo in the regex. The matcher matches every text that is preceded by foo since the
        last dot part means any character after.  So, after finding the first foo, the rest is seen as any character.
        That is why there is only a single match. */
        int matches = regexMatchCountTest("foo.", "foofoo");
        System.out.println(matches);
    }

    public int regexMatchCountTest(String regex, String matcher){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(matcher);
        int matches = 0;
        while (matcher1.find()){
            matches++;
            System.out.println("Pattern found from " + matcher1.start() +
                      " to " + (matcher1.end()-1));
        }
        return matches;
    }

    @Test
    public void givenORSet_whenMatchesAny_thenCorrect() {
        //Character Classes
        //A character class allows you to match any symbol from a certain character set.
        //A character class is also called a character set.
        //OR class
        //Constructed as [abc]. Any of the elements in the set is matched.
        //If they all appear in the text, each is matched separately with no regard to order.
        int matches = regexMatchCountTest("[abc]", "acbhhjaa");
        assertEquals(5, matches);
    }

    @Test
    public void givenORSet_whenMatchesAllCombinations_thenCorrect() {
        /*They can also be alternated as part of a String. In the following example,
        when we create different words by alternating the first letter with each element of the set, they are all matched:
         Durint the matching, the expression [bcr]at will create the following words in turn: bat, cat, rat, and they will all
         be matched with the String "bat cat rat". */
        int matches = regexMatchCountTest("[bcr]at", "bat cat rat");
        assertEquals(3, matches);
    }

    @Test
    public void givenNORSet_whenMatchesNon_thenCorrect() {
        //NOR class
        //The above set is negated by adding a caret as the first element.  This will match any other
        //character that is not included in the bracket.  The expression [^abc] says match characters other than abc.
        int matches = regexMatchCountTest("[^abc]", "g");
        assertTrue(matches > 0);
        assertEquals(1, matches);
    }

    @Test
    public void givenNORSet_whenMatchesAllExceptElements_thenCorrect() {
        //Any character other than characters in brackets in front of "at" will match.
        //[^bcr]at, will match a String with any character other than b, c, or r in front of "at",
        //including space.
        int matches = regexMatchCountTest("[^bcr]at", "sat mat eat");
        assertTrue(matches > 0);
        assertEquals(3, matches);
    }

    @Test
    public void givenUpperCaseRange_whenMatchesUpperCase_thenCorrect() {
        //Range class
        //We can define a class that specifies a range within which the matched text should fall using a hyphen(-),
        //likewise, we can also negate a range.
        //Matching uppercase letters:
        int matches = regexMatchCountTest("[A-Z]", "Two Uppercase alphabets 34 overall");
        assertEquals(2, matches);
    }

    @Test
    public void testing(){
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher("Two Uppercase alphabets 34 overall");
        int matches = 0;
        while (matcher.find()){
            matches++;
        }
        System.out.println("Match Found: " + matches);
    }

    @Test
    public void givenUpperCaseRange_whenMatchesLowerCase_thenCorrect() {
        //As above, this example is Matching Lowercase letters:
        int matches = regexMatchCountTest("[a-z]", "Two Uppercase alphabets 34 overall");
        assertEquals(26, matches);
    }

    @Test
    public void givenBothLowerAndUpperCaseRange_whenMatchesAllLetters_thenCorrect() {
        // Matching both uppercase and lowercase letters:
        int matches = regexMatchCountTest("[a-zA-Z]", "Two Uppercase alphabets 34 overall");
        assertEquals(28, matches);
    }

    @Test
    public void givenNumberRange_whenMatchesAccurately_thenCorrect() {
        //Matching a given range of numbers:
        int matches = regexMatchCountTest("[1-5]", "Two Uppercase alphabets 34 overall");  //Both 1 and 5 inclusive.
        assertEquals(2, matches);
    }

    @Test
    public void givenNumberRange_whenMatchesAccurately_thenCorrect2(){
        // Matching another range of numbers.  The Regex expression 3[0-5] will create the following numbers: 30, 31, 32,33, 34, 35 to
        //match against the String "Two Uppercase alphabets 34 overall" which will return only one match 34.
        int matches = regexMatchCountTest("3[0-5]", "Two Uppercase alphabets 34 overall");
        assertEquals(1, matches);
    }

    @Test
    public void givenTwoSets_whenMatchesUnion_thenCorrect() {
        //Union class
        //A union character class is a result of combining two or more character classes:
        int matches = regexMatchCountTest("[1-3[7-9]]", "123456789");
        assertEquals(6, matches);
    }

    @Test
    public void givenTwoSets_whenMatchesIntersection_thenCorrect() {
        //Intersection class
        //Similar to the union class, the Intersection class results from picking common elements between two or more sets.
        // To apply intersection, we use the &&:
        int matches = regexMatchCountTest("[1-6&&[3-9]]", "123456789");
        assertEquals(4, matches);
    }

    @Test
    public void givenSetWithSubtraction_whenMatchesAccurately_thenCorrect(){
        //Subtraction Class
        //We can use subtraction to negate one or more character classes,
        // for example matching a set of odd decimal numbers.
        //The result of the Regex [0-9&&[^2468]] is: 1,3,5,7,9 when matched with the string "123456789",
        //the result is 5 matches which are 1,3,5,7,9.
        int matches = regexMatchCountTest("[0-9&&[^2468]]", "123456789");
        assertEquals(5, matches);
    }

    @Test
    public void givenDigits_whenMatches_thenCorrect() {
        //Predefined Character Classes
        //The Java regex API also accepts predefined character classes.
        // Some of the above character classes can be expressed in shorter form though making the code less intuitive.
        // One special aspect of the Java version of this regex is the escape character.
        //As we will see, most characters will start with a backslash, which has a special meaning in Java.
        // For these to be COMPILED by the Pattern class – the leading backslash must be escaped i.e., \d becomes \\d.
        // Matching digits, \\d equivalent to [0-9] :
        int matches = regexMatchCountTest("\\d", "1235");
        assertEquals(4, matches);
    }

    @Test
    public void givenNonDigits_whenMatches_thenCorrect() {
        //Matching non-digits, \\D equivalent to [^0-9] :
        int matches = regexMatchCountTest("\\D", "a6c");
        assertEquals(2, matches);
//        int matches = regexMatchCountTest("\\-?\\d+", "-1");
//        assertEquals(1, matches);
    }

    @Test
    public void givenWhiteSpace_whenMatches_thenCorrect() {
        // Matching white space characters:
        int matches = regexMatchCountTest("\\s", "a  c");
        assertEquals(2, matches);
    }

    @Test
    public void givenWhiteSpaceTwo_whenMatches_thenCorrect() {
        // Matching white space characters:
        int matches = regexMatchCountTest("\\s", "a c \n");
        assertEquals(3, matches);
    }

    @Test
    public void givenNonWhiteSpace_whenMatches_thenCorrect() {
        //Matching non-white space characters:
        int matches = regexMatchCountTest("\\S", "a c x t");
        assertEquals(4, matches);
    }

    @Test
    public void givenWordCharacter_whenMatches_thenCorrect() {
        //Matching a word character, equivalent to [a-zA-Z_0-9].
        //Each character that make up the word is matched in turn.
        //Other special characters such as !,are not considered a word character and are therefore not matched.
        int matches = regexMatchCountTest("\\w", "hi A 25!");
        assertEquals(5, matches);
//        int matches = regexMatchCountTest("[a-zA-Z_0-9]", "hi A 25!");
//        assertEquals(5, matches);
    }

    @Test
    public void givenNonWordCharacter_whenMatches_thenCorrect() {
        //Matching a non-word character.  This excludes the characters [a-zA-Z_0-9].
        //Matches non-word characters including spaces.
        int matches = regexMatchCountTest("\\W", "hi G !$£");
        assertEquals(5, matches);
    }

    @Test
    public void givenZeroOrOneQuantifier_whenMatches_thenCorrect() {
        //Quantifiers
        //Reluctant Quantifier (Appending a ? after quantifier)
        //The Java regex API also allows us to use quantifiers.  X? will match Zero or One occurrence of X.
        // These enable us to further tweak the match's behaviour by specifying the number of
        // occurrences to match against.  To match a text zero or one time, we use the ? quantifier.
        // ? after a quantifier makes it a reluctant quantifier. It tries to find the smallest match.
        // This makes the regular expression stop at the first match.
        //This quantifier uses the approach that is the opposite of greedy quantifiers.
        // It starts with the first character and processes one character at a time.
        int matches = regexMatchCountTest("g+?", "gHiaggg");
        assertEquals(4, matches);

        //Explanation: Since the quantifier is reluctant, it matches the shortest part of the test with the pattern.
        //It processes one character at a time.

        //TODO: more tests needed as results are inconclusive when we use g? on its own.
        //But used as above, results are conclusive.

        //Note: The matching starts at index 0 onwards.
        //In this case, a match is found at index 0, 4, 5, 6, for our input String gHiaggg above.
        //No match for index 1 which has a value of H, index 2 value is i, and index 3 with value of a.

    }

    @Test
    public void givenZeroOrOneQuantifier_whenMatches_thenCorrect2() {
        //Alternatively, we can use the brace syntax, also supported by the Java regex API:
        int matches = regexMatchCountTest("\\a{0,1}", "hi");
        assertEquals(3, matches);
    }

    @Test
    public void quantifiersTest(){
        //Quantifiers
        //Greedy Quantifier (Default)
        //By default, quantifiers are Greedy. Greedy quantifiers try to match the
        // longest text that matches a given pattern. Greedy quantifiers work by first reading the
        // entire string before trying any match. If the whole text doesn’t match, remove the
        // last character and try again, repeating the process until a match is found.
        // Making an instance of Pattern class
        // By default quantifier "+" is Greedy.  X+ matches One or More occurrences of X.
        Pattern p = Pattern.compile("g+");
        // Making an instance of Matcher class
        Matcher m = p.matcher("ggg");
        int matches = 0;
        while (m.find()){
            matches++;
           System.out.println("Pattern found from " + m.start() +
                    " to " + (m.end()-1));
    }
        System.out.println("\nNumber of matches: " + matches);
        assertEquals(1, matches);
        /*Explanation: The pattern g+ means one or more occurrences of g. Text is ggg.
        The greedy matcher would match the longest text even if parts of the matching text also match.
        In this example, g and gg also match, but the greedy matcher produces ggg.
         */
}

    @Test
    public void quantifiersTestTwo(){
        int matches = regexMatchCountTest("a{0,1}", "Hiaaaa!");
        assertEquals(1, matches);
    }

    @Test
    public void quantifiersTestThree(){
        // Making an instance of Pattern class
        // By default quantifier "+" is Greedy.  X* matches zero or more occurrences of X.
        Pattern p = Pattern.compile("g*");
        // Making an instance of Matcher class
        Matcher m = p.matcher("ggg");
        int matches = 0;
        while (m.find()){
            matches++;
            System.out.println("Pattern found from " + m.start() +
                    " to " + (m.end()-1));
        }
        System.out.println("\nNumber of matches: " + matches);
        assertEquals(1, matches);

        //TODO: more test needed as results are inconclusive
    }

    @Test
    public void quantifiersTestFour(){
        //X{n} means Exactly n occurrences of X
        int matches = regexMatchCountTest("g{2}", "gggg ggg");

        System.out.println("\nNumber of matches: " + matches);
        assertEquals(3, matches);

        //TODO: more test needed as results are inconclusive
    }

    @Test
    public void quantifiersTestFive(){
        //X{n,} means At-least n occurrences of X
        int matches = regexMatchCountTest("g{2,}", "ggg ggg ggg");

        System.out.println("\nNumber of matches: " + matches);
        assertEquals(3, matches);

        //TODO: more test needed as results are inconclusive
    }

    @Test
    public void quantifiersTestSix(){
        //X{n, m} means Count of occurrences of X is from n to m
        int matches = regexMatchCountTest("g{2,4}", "ggggg gggg");

        System.out.println("\nNumber of matches: " + matches);
        assertEquals(3, matches);

        //TODO: more tests needed as results are inconclusive
    }

    @Test
    public void quantifiersTestSeven(){
        //Possessive Quantifier (Appending a + after quantifier)
        //This quantifier matches as many characters as possible, like a greedy quantifier.
        // But if the entire string doesn’t match, then it doesn’t try removing characters from the end.
        // Here "+" is a Possessive quantifier because a "+" is appended after it.

        int matches = regexMatchCountTest("g++", "ggg");

        System.out.println("\nNumber of matches: " + matches);
        assertEquals(1, matches);

        //Explanation: We get the same output as Greedy because the whole text matches the pattern.

    }

    @Test
    public void differenceBetweenGreedyAndPossessiveQuantifiers(){
        // Java program to demonstrate difference
        // between Possessive and Greedy Quantifiers
        int matches = regexMatchCountTest("g+g", "ggg");
        System.out.println("Using Greedy Quantifier.....");
        System.out.println("Number of matches found: " + matches);
        assertEquals(1, matches);

        int matches2 = regexMatchCountTest("g++g", "ggg");
        System.out.println("\n\nUsing Possessive Quantifier.....");
        System.out.println("Number of matches: " + matches2);
        assertEquals(0, matches2);

    }

    @Test
    public void replaceAllMethodWithRegex(){
        //Regular Expressions \s and \s+
        //String substitution is a standard operation when we process strings in Java.
        // Thanks to the handy replaceAll() method in the String class,
        // we can easily do string substitution with regular expressions.
        //The regular expression \s is a predefined character class. It indicates a single whitespace character.
        //The plus sign + is a greedy quantifier, which means one or more times. For example,
        // expression X+ matches one or more X characters.  Therefore, the regular expression \s matches a
        // single whitespace character, while \s+ will match one or more whitespace characters.

        String inputString = "Text   With     Whitespaces!   ";
        String result = inputString.replaceAll("\\s", "_");

        System.out.println("Replaced all whitespaces with an underscore.... ");
        System.out.println("The result is: \n" + result);
        assertEquals("Text___With_____Whitespaces!___", result);

        //Note:The replaceAll() method finds single whitespace characters and replaces each match with an underscore.
        // We have eleven whitespace characters in the input text. Thus, eleven replacements will occur.

        System.out.println("\nReplacing \"Whitespaces\" with underscore using s+..........");
        String result2 = inputString.replaceAll("\\s+", "_");

        System.out.println("The s+ result is: \n" + result2);
        assertEquals("Text_With_Whitespaces!_", result2);

        //Due to the greedy quantifier + , the replaceAll() method will match the longest sequence of
        // contiguous whitespace characters and replace each match with an underscore.
        // In our input text, we have three sequences of contiguous whitespace characters.
        // Therefore, each of the three will become an underscore.
    }

    @Test
    public void replaceAllMethodWithRegexTwo(){
        //replaceAll() With an Empty Replacement
        //Another common usage of the replaceAll() method is to remove matched patterns from
        //the input text. We usually do it by passing an empty string as the replacement to the method.
        String inputString = "Text With     Whitespaces!   !";
        System.out.println("Removing matched text from the input string with s.....");
        String result = inputString.replaceAll("\\s", "");
        System.out.println("The s result is: \n" + result);

        System.out.println("\nRemoving matched text from input text with s+.......");
        String result2 = inputString.replaceAll("\\s+", "");
        System.out.println("The s+ result is: \n" + result2);
        System.out.println();

        String result3 = inputString.replaceAll("\\s+", " ");
        System.out.println("\nReplace whitespaces with s+: ");
        System.out.println("The s+ result3 is: \n" + result3);

        String result4 = inputString.replaceAll("\\s", " ");
        System.out.println("\nReplace whitespace with s: ");
        System.out.println("The s result is: \n" + result4);
    }

    @Test
    public void testForSolutionHomeOffice(){
        int stackMovies = -9;
        if (Pattern.matches("\\-?\\d+", "\"" + stackMovies + "\"")){
            System.out.println("Wrong character");
        }
       // if(Pattern.matches("\\d+", (CharSequence) myObject);)==true)
    }
}
