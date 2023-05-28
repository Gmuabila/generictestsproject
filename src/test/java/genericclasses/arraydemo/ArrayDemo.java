package genericclasses.arraydemo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayDemo {

    @Test
    public void testingArray() {
        //Note: There are no specific methods to remove elements from the array.
        int[] intArray;
        int[] intArrayFive = new int[10];

        intArrayFive[2] = 10;

        String[] stringArray = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        intArray = new int[]{1, 2, 7, 10, 101, 122};

        int[] intArrayTwo = {23, 22, 6, 79, 105};

        int[] intArrayThree = new int[]{17, 29, 16, 15, 40};

        int[] intArraySix = IntStream.of(9, 1, 4, 7, 2, 4, 10, 3, 10).sorted().toArray();

        //Generating a stream of primitive int values and assign it to the array
        int[] intArrayFour = IntStream.rangeClosed(100, 200).toArray();

        double[] doubleArray = DoubleStream.of(19.37d, 89.12d, 33.52, 11.35d).toArray();

        for (int i = 0; i < intArrayFour.length; i++) {
            System.out.println(intArrayFour[i]);

        }
        System.out.println("\nThe size of stringArray is: " + stringArray.length);

        System.out.println("\nPrinting intArraySix: ");
        for (int i = 0; i < intArraySix.length; i++) {
            System.out.println(intArraySix[i]);

        }
        System.out.println();
    }

    @Test
    public void testingArrayTwo() {
        //Converting an Array to a list
        Integer[] intArrayTwo = new Integer[]{11, 14, 15, 17};
        List<Integer> integerList = Arrays.asList(intArrayTwo);
        //Converting an Array to a List
        List<Integer> integerList4 = Arrays.stream(intArrayTwo).collect(Collectors.toList());
        //Converting an Array to a Set
        Set<Integer> integerSet = Arrays.stream(intArrayTwo).collect(Collectors.toSet());

        //Using List.of to convert an array to a List
        List<Integer> integerList6 = new ArrayList<>(List.of(intArrayTwo));
        //Using Set.of to convert an Array to a Set
        Set<Integer> integerSet1 = new HashSet<>(Set.of(intArrayTwo));

        //Converting an Array to a Stream
        Stream<Integer> integerStream = Arrays.stream(intArrayTwo);
        Stream<Integer> integerStream1 = Stream.of(intArrayTwo);
        List<Integer> integerStreamList = integerStream.collect(Collectors.toList());
        List<Integer> integerStream1List = integerStream1.collect(Collectors.toList());

        List<Integer> integerList3 = Arrays.asList(10, 11, 12, 19);
        List<String> stringList = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

        List<Integer> integerList1 = new ArrayList<>(Arrays.asList(intArrayTwo));

        //Using addAll() of the collection class to add an array to a list
        List<Integer> integerList2 = new ArrayList<>();
        Collections.addAll(integerList2, intArrayTwo);

        //Converting an Array of int primitive type to a List, first convert int to wrapper class Integer.
        int[] intArray = IntStream.rangeClosed(1, 10).toArray();
        List<Integer> listOne = new ArrayList<>();

        for (int i = 0; i < intArray.length; i++) {
            listOne.add(intArray[i]);
        }

        //Converting a List to an Array.
        String[] stringArrayThree = stringList.stream().toArray(String[]::new);
        System.out.println("Printing an Array converted from a List: ");
        System.out.println(Arrays.toString(stringArrayThree));
        System.out.println();

        System.out.println("Printing listOne: " + listOne);
        System.out.println("\nPrinting integerList: " + integerList);
        System.out.println("\nPrinting integerList1: " + integerList1);
        System.out.println("\nPrinting integerList2: " + integerList2);
        System.out.println("\nPrinting integerList4: " + integerList4);
        System.out.println("\nPrinting integerList6: " + integerList6);
        System.out.println("\nPrinting integerStreamList: " + integerStreamList);
        System.out.println("\nPrinting integerStream1List: " + integerStream1List);



    }

    @Test
    public void testingArrayThree() {
        //Create a Stream from the Array, apply functions and return result to an Array.
        //Not all element of the array have been used here.  We only selected 6, 3, 8 from the array below
        int[] intArrays = new int[]{2, 9, 1, 6, 3, 8, 4};

        int[] intArraysResult = Arrays.stream(intArrays, 3, 6).sorted().map(x -> x + 3).toArray();
        System.out.println("The original Array \"intArrays\" is: ");
        Arrays.stream(intArrays).forEach(s -> System.out.print(s + ", "));
        System.out.println("\n\nThe processed Arrays \"intArraysResult\" is: ");
        Arrays.stream(intArraysResult).forEach(s -> System.out.print(s + ", "));
    }


    public List<WordCount> testingArrayFour(String text) {
        //Given a text, count how many occurrences of each word in the text.
        int counter;
        List<WordCount> wordCountList = new ArrayList<>();
        Map<String, Integer> resultCount = new HashMap<>();

        String cleanText = text.replace(".", "").toLowerCase();  //remove all dot "." and convert all to lowercase.
        String cleanTextTwo = cleanText.replace(",", "");  //removing ","

        String[] textArray = cleanTextTwo.split("\\s+");

//        System.out.print("The Array size is: " + textArray.length);
//        System.out.println();
//        System.out.println("Printing the Array: ");
//        //Printing the Array
//        System.out.println(Arrays.toString(textArray));
//        System.out.println();
//        System.out.println();

        for (int i = 0; i < textArray.length; i++) {
            counter = 0;
            for (int j = 0; j < textArray.length; j++) {
                if (textArray[i].equals(textArray[j])) {
                    counter++;
                }
            }
            resultCount.put(textArray[i], counter);
        }
        Set<String> keySet = resultCount.keySet();
        for(String item: keySet){
            Integer count = resultCount.get(item);
            WordCount wordCount = new WordCount();
            wordCount.setWord(item);
            wordCount.setCount(count);
            wordCountList.add(wordCount);
        }
        WordCountComparator wordCountComparator = new WordCountComparator();
        Collections.sort(wordCountList, wordCountComparator.reversed());


        //System.out.println(wordCountList);
//        System.out.println("\"" + textArray[i] + "\"" + " Word count: " + counter);
//        System.out.println();
//        System.out.println(testSet);
//        System.out.println();
//        System.out.println("Printing the map result: ");
       // System.out.println(resultCount.);

        return wordCountList;
    }

    @Test
    public void wordCountTest(){
        String text = "Every morning I go to work.  " +
                "Monday is the day we all start work. " +
                "Every week the same thing happens.  " +
                "The cycle repeat itself every week. " +
                "Next Monday, Tuesday, Wednesday. " +
                "work, work, work, Monday, Tuesday, Tuesday ";


        System.out.println("WORD" + "\t\t\t\t" + "Count");
        List<WordCount> resultList = testingArrayFour(text);
        System.out.println();
        //System.out.println(resultList);   //Prints the list using toString() method of the object in the list
        //Printing the list
//        for(WordCount wordCount: resultList){
//            System.out.println(wordCount.getWord() + ":\t\t\t\t\t" + wordCount.getCount());
//        }
        //Or can print the List with for loop as below
        for(int i = 0; i < resultList.size(); i++){
            System.out.println(resultList.get(i).getWord() + "\t\t\t\t\t" + resultList.get(i).getCount());
        }
    }

    @Test
    public void numberCountTest(){
        //How would you do to find duplicate elements in an array?
        int counter;
        int j = 0;
        int[] intArray = new int[]{1, 2, 3, 4, 5, 3, 2, 3, 2, 7, 2, 7};
        Map<Integer, Integer> integerMap = new HashMap<>();
        List<NumberCount> numberCountList = new ArrayList<>();

        for(int i = 0; i < intArray.length; i++){
            counter = 0;
            for(j = 0; j < intArray.length; j++){
                if(intArray[i] == intArray[j]){
                    counter++;
                }
            }
            integerMap.put(intArray[i], counter);
           // System.out.println("\"" + intArray[i] + "\"" + " Word count: " + counter);
        }

        System.out.println("Element" + "\t\t" + "Count");
        System.out.println();
        Set<Integer> keySet = integerMap.keySet();
        for(Integer item: keySet){
            Integer count = integerMap.get(item);
            NumberCount numberCount = new NumberCount();
            numberCount.setNum(item);
            numberCount.setCount(count);
            numberCountList.add(numberCount);
            //System.out.println(item + "\t\t\t" + count);
        }
        NumberComparator numberComparator = new NumberComparator();
        Collections.sort(numberCountList, numberComparator.reversed());
        //System.out.println(numberCountList);

        for(NumberCount item: numberCountList){
            System.out.println(item.getNum() + "\t\t\t" + item.getCount());
        }
        //Or use the For Loop below:
//        for(int i = 0; i < numberCountList.size(); i++){
//            System.out.println(numberCountList.get(i).getNum() + "\t\t\t" + numberCountList.get(i).getCount());
//        }
    }
}

