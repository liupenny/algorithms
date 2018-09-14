package Binary_Search.Find_Right_Interval;

import tools.Interval;
import tools.ListNode;

import java.util.*;

import static java.util.Collections.binarySearch;

/**
 * Created by PennyLiu on 2017/10/25.

 * findRightInterval:用到了TreeMap. http://blog.csdn.net/x_i_y_u_e/article/details/46372023
 * TreeMap基于红黑树（Red-Black tree）实现。该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的 Comparator 进行排序。
 * TreeMap.ceilingKey(K key)，返回大于等于给定键的最小键；如果不存在这样的键，则返回 null
 * findRightInterval1:用二分搜索,java自带的collections.binarySearch会在找不到的时候返回负数。所以不要用
 */
public class Find_Right_Interval {
    public int[] findRightInterval(Interval[] intervals) {
        int[] ans = new int[intervals.length];
        NavigableMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);   //先将start存起来
        }

        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end); //ceilingEntry自动找出大于等于的最小值
            ans[i] = entry != null ? entry.getValue() : -1;
        }
        return ans;
    }

    public int[] findRightInterval1(Interval[] intervals) {  //把头元素存在一个数组中，每次去根据end二分查找对应的头
        int[] ans = new int[intervals.length];
        List<Integer> starts = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<intervals.length; i++)
        {
            starts.add(intervals[i].start);
            map.put(intervals[i].start, i);
        }
        Collections.sort(starts);

        for (int i=0; i<intervals.length; i++)
        {
            int end = intervals[i].end;
            int start = binarySearch(starts,end);
            if (start < end) {
                ans[i] = -1;
            } else {
                ans[i] = map.get(start);
            }
        }
        return ans;

    }

    public int binarySearch(List<Integer> list, int x) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return list.get(left);
    }

    public static void main(String[] algs)
    {
        List<Integer> starts = new ArrayList<>(Arrays.asList(1,2,3,4,5,7,8));
        //Integer[] ans = {1,2,3,4,5,6,7,8};
        int a = Collections.binarySearch(starts,6);
        System.out.println(a);
    }
}
