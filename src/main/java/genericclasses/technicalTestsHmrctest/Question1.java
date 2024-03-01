package genericclasses.technicalTestsHmrctest;

public class Question1 {
    public static void main(String[] args){
        try{
            ((ClassA) new ClassB()).process();
        }catch (Exception e){
            System.out.println("Exception");
        }
    }
}
