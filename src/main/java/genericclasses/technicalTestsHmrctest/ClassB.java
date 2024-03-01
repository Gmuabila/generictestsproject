package genericclasses.technicalTestsHmrctest;

public class ClassB extends ClassA{
    public void process(){
        super.process();
        if (true)
            throw new RuntimeException();
        System.out.println("B");
    }
}
