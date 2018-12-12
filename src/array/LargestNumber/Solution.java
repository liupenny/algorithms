package array.LargestNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/11
 */
public class Solution {
    public int bigNum(int[] arr) {
        Integer[] tmp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp, new NumComparator());
        StringBuilder s = new StringBuilder();
        for (Integer integer : tmp) {
            s.append(integer);
        }
        return Integer.parseInt(s.toString());
    }
}

class NumComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o, Integer b) {
        return String.valueOf(o).compareTo(String.valueOf(b));
    }
}