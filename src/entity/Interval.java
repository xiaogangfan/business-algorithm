package entity;

/**
 * Created by anduo on 17-3-12.
 */ // Definition for an interval.
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[start="+start+",end="+end+"]";
    }
}
