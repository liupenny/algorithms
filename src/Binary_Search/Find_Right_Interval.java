package Binary_Search;

import tools.Interval;
import tools.ListNode;

import java.util.*;

import static java.util.Collections.binarySearch;

/**
 * Created by PennyLiu on 2017/10/25.
 * 436. Find Right Interval
 Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger
 than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

 For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum
 start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i.
 Finally, you need output the stored value of each interval as an array.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 You may assume none of these intervals have the same start point.

 Example 1:
 Input: [ [1,2] ]
 Output: [-1]

 Explanation: There is only one interval in the collection, so it outputs -1.

 Example 2:
 Input: [ [3,4], [2,3], [1,2] ]
 Output: [-1, 0, 1]

 Explanation: There is no satisfied "right" interval for [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point;
 For [1,2], the interval [2,3] has minimum-"right" start point.

 Example 3:
 Input: [ [1,4], [2,3], [3,4] ]
 Output: [-1, 2, -1]

 Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point.
 * findRightInterval:用到了TreeMap.http://blog.csdn.net/x_i_y_u_e/article/details/46372023
 * findRightInterval1:用二分搜索,java自带的collections.binarySearch会在找不到的时候返回负数。所以不要用
 */
public class Find_Right_Interval {
    public int[] findRightInterval(Interval[] intervals) {
        int[] ans = new int[intervals.length];
        NavigableMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++)
            map.put(intervals[i].start, i);

        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            ans[i] = entry != null ? entry.getValue() : -1;
        }
        return ans;
    }

    public int[] findRightInterval1(Interval[] intervals) {
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
