package Hash_table.Max_Points_on_a_Line;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/30.
 */

class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
 }

public class Solution{
    // map存储《斜率，直线list》，一个斜率对应多条直线。每条直线是一个set
    // 所有斜率相同的直线组成一个list,
    // 这个方法斜率的精度有问题，应该用比值去比较是否一条直线
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) {
            return 0;
        }
        if(points.length <= 2) {
            return points.length;
        }

        // 用序号标明是哪个点
        int ans = 0;
        Map< Double, List<Set<Integer>> > map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            Point head = points[i];
            int samex = 1, samey = 1;

            for (int j = i+1; j < points.length; j++) {
//                if(j == i)
//                    continue;

                Point next = points[j];
                if(next.x == head.x) {
                    samex++;
                    continue;
                }
                else if(next.y == head.y){
                    samey++;
                    continue;
                }
                else {
                    double slopeTmp = (double) (next.y - head.y) / (next.x - head.x);
                    if(map.containsKey(slopeTmp)) {
                        List<Set<Integer>> pair = map.get(slopeTmp);
                        boolean appBefore = false;
                        for (int k = 0; k < pair.size(); k++) {
                            if(pair.get(k).contains(i)) {
                                map.get(slopeTmp).get(k).add(j);
                                appBefore = true;
                            }
                        }
                        if(appBefore == false){
                            Set tmpSet = new HashSet();
                            tmpSet.add(i);
                            tmpSet.add(j);
                            map.get(slopeTmp).add(tmpSet);
                        }
                    }
                    else
                    {
                        List<Set<Integer>> tmpList = new ArrayList<>();
                        Set tmpSet = new HashSet();
                        tmpSet.add(i);
                        tmpSet.add(j);
                        tmpList.add(tmpSet);
                        map.put(slopeTmp, tmpList);
                    }
                }
            }
            ans = Math.max(ans, Math.max(samex, samey));
        }
        for (List<Set<Integer>> num: map.values()) {
            for(Set set: num) {
                ans = Math.max(ans, set.size());
            }
        }
        return ans;
    }

    // 因为对每个起始点i，一次遍历就会遍历完当前点所在的所有直线，且得知这条直线上的所有点个数
    // 所以不用担心之前遍历过的直线，在后面还需要补充点
    // 所以，对每个起始点i,遍历的时候从j=i+1开始，每一个起始点i遍历完即可比较个数。
    public int maxPoints1(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
            int samePoints = 1;
            int maxPoints = 0;
            Point p1 = points[i];
            for (int j = i+1; j < points.length; j++) {
                Point p2 = points[j];
                if(p1.x == p2.x && p1.y == p2.y) {
                    ++samePoints;
                } else{
                    Pair p = getGCD(p1,p2);
                    map.put(p, map.getOrDefault(p,0)+1);
                    maxPoints = Math.max(maxPoints, map.get(p));
                }
            }
            ans = Math.max(ans, samePoints + maxPoints);
        }
        return ans;
    }

    public Pair<Integer, Integer> getGCD(Point a, Point b){
        int dx = b.x - a.x;
        int dy = b.y - a.y;

        // 水平线
        if(dy == 0) {
            return new Pair<>(a.y, 0);
        }
        // 垂直线
        if(dx == 0){
            return new Pair<>(0, a.x);
        }

        int d = gcd(dx, dy);
        return new Pair<>(dy/d,dx/d);
    }

    public int gcd(int m, int n){
        return n == 0 ? m : gcd(n, m%n);
    }

    public Point[] makepoints(String s)
    {
        s = s.replace("[","");
        s = s.replace("]","");
        String[] parts = s.split(",");
        Point[] points = new Point[parts.length/2];
        for (int i = 0; i < parts.length; i += 2) {
            int x = Integer.valueOf(parts[i]);
            int y = Integer.valueOf(parts[i+1]);
            points[i/2] = new Point(x,y);
        }
        return points;
    }

    private void t()
    {
        int a = 1;
    }

    public static void main(String[] args)
    {
        // Point[] points = {new Point(1,1), new Point(3,2), new Point(5,3),new Point(4,1), new Point(2,3), new Point(1,4)};
        // Point[] points = {new Point(1,1), new Point(0,0), new Point(1,-1)};
        // Point[] points = {new Point(2,3), new Point(3,3), new Point(-5,3)};
        //String string = "[0,-12]";
        // String string = "[0,-12],[5,2],[2,5],[0,-5],[1,5],[2,-2],[5,-4],[3,4],[-2,4],[-1,4],[0,-5],[0,-8],[-2,-1],[0,-11],[0,-9]";
        //String string = "[1,1],[2,2],[3,3]";
        String string = "[0,0],[94911151,94911150],[94911152,94911151]";
        Solution s = new Solution();
        Point[] points = s.makepoints(string);
        System.out.println(s.maxPoints1(points));
    }
}