package hmrctest;

public class Question3 {
    Short result = 5;

    Question3 go(Question3 question){
        question = null;
        return question;
    }

    @Override
    public String toString() {
        return "Question3{" +
                "result=" + result +
                '}';
    }
}
