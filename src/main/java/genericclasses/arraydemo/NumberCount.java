package genericclasses.arraydemo;

public class NumberCount {
    Integer num;
    Integer count;

    public NumberCount() {
    }

    public NumberCount(Integer num, Integer count) {
        this.num = num;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
