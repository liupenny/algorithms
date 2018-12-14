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

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3,5,1,4,2};
        System.out.println(s.bigNum(arr));
    }
}

class NumComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o, Integer b) {
        String a1 = String.valueOf(o) + String.valueOf(b);
        String a2 = String.valueOf(b) + String.valueOf(o);
        return a1.compareTo(a2);
    }
}