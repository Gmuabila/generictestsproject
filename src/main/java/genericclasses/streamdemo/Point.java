package genericclasses.streamdemo;

public class Point {
    private Integer x;
    private Integer y;

    Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public String toString() {
        return "Point [" + this.x + ", "+ this.y + "]";
    }
}
