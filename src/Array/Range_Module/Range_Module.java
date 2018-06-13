package Array.Range_Module;

import tools.Interval;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by PennyLiu on 2018/6/8.
 */
public class Range_Module {
//    class RangeModule {
//        TreeSet<Interval> ranges;
//
//        public RangeModule() {
//            ranges = new TreeSet<>();
//        }
//
//        public void addRange(int left, int right) {
//            Iterator<Interval> itr = ranges.tailSet(new Interval(0,left - 1)).iterator(); //返回大于（0,left-1）的集合的迭代器
//            while (itr.hasNext())
//            {
//                Interval iv = itr.next();
//                if(right < iv.left)
//                    break;
//                left = Math.min(left, iv.left);
//                right = Math.max(right, iv.right);
//                itr.remove();
//            }
//            ranges.add(new Interval(left,right));
//        }
//
//        public boolean queryRange(int left, int right) {
//
//        }
//
//        public void removeRange(int left, int right) {
//
//        }
//    }

    class Interval implements Comparable<Interval>
    {
        int left, right;
        public Interval(int left, int right)
        {
            this.left = left;
            this.right = right;
        }

        public int compareTo(Interval that)
        {
            if(this.right == that.right)  //再按照左边的大小比较
                return this.left - that.left;
            return this.right - that.right;  //先按照右边的大小
        }

    }

    public static void main(String[] args) {
        Range_Module t = new Range_Module();
    }
}
