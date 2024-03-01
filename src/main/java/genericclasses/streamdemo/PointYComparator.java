package genericclasses.streamdemo;

import java.util.Comparator;

public class PointYComparator implements Comparator<Point> {
    @Override
    public int compare(Point pointOne, Point pointTwo){
        return Integer.compare(pointOne.getY(), pointTwo.getY());
    }
}
