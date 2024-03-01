package genericclasses.methodreferencedemo;

import java.util.Random;

public class Person {
// Java Program to Illustrate how one can use Static Method Reference to Sort with Custom Comparator

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        Random random = new Random();
        this.age = random.nextInt(10) * 100;
        String[] names = new String[]{"John Mark", "Carlos J", "Micheal Morse", "GTech M", "G Muabila", "Glenn Muabila"};
        Random rand = new Random();
        int index = rand.nextInt(6);
        this.name = names[index];
//        int generatedNumber = rand.nextInt(4);
//        if(generatedNumber == 0)
//            this.name = "John Mark";
//        if (generatedNumber == 1)
//            this.name = "Carlos J";
//        if (generatedNumber == 2)
//            this.name = "Micheal Morse";
//        if (generatedNumber == 3)
//            this.name = "GTech M";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
