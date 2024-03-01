package genericclasses.streamdemo;

import java.util.Comparator;

public class PointXComparator implements Comparator<Point> {
    @Override
    public int compare(Point pointOne, Point pointTwo){
        return Integer.compare(pointOne.getX() , pointTwo.getX());
    }
}
