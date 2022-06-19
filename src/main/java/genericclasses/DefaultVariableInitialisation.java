package genericclasses;

public class DefaultVariableInitialisation {
        int number;         // number will have default value: 0
        float ratio;        // default value: 0.0
        boolean success;    // default value: false
        String name;        // default: null
        Object obj;         // default: null

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void print() {
            System.out.println("Uninitialised Integer variable value is: " + number);
            System.out.println("Uninitialised Float variable value is: " + ratio);
            System.out.println("Uninitialised Boolean variable value is: " + success);
            System.out.println("Uninitialised String variable value is: " + name);
            System.out.println("Uninitialised Object variable value is: " + obj);
        }
}
