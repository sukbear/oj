package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/***
 *@ClassName IntervalMerge
 *@Description
 * @author sukbear
 * @create 2019-04-22 15:12
 */
public class IntervalMerge {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "["+this.start+","+this.end+"]";
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval temp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval e = intervals.get(i);
        if (e.start <= temp.end) {
            temp = new Interval(temp.start, e.end);
        } else {
            res.add(temp);
            temp = e;
        }
    }
        res.add(temp);
        return res;
    }

    public static void main(String[] args) {
        IntervalMerge im = new IntervalMerge();
        Interval e1 = new Interval(1,3);
        Interval  e2= new Interval(2,6);
        Interval e3 = new Interval(8,10);
        Interval e4 = new Interval(15,18);
        List<Interval> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
       for(Interval interval :im.merge(list)){
           System.out.println(interval);
       }
    }
}
