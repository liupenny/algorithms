package Array.Two_Sum_II_Input_array_is_sorted;

import Array.Two_Sum.Two_Sum;

/**
 * Created by PennyLiu on 2017/10/20.

 * 思路1：hashmap实现
 * 思路2：用两个指针分别指向头和尾，依次移动.两个节点求和的一般都是双指针方法
 */
public class Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int lo = 0, hi = numbers.length-1;
        while (numbers[lo] + numbers[hi] != target)  //在不等于的情况下循环
        {
            if(numbers[lo] + numbers[hi]>target) {
                hi--;
            } else if(numbers[lo] + numbers[hi]<target) {
                lo++;
            }
        }
        ans[0] = lo+1; //题目中要求从1开始
        ans[1] = hi+1;
        return ans;
    }

    public static void main(String[] algs)
    {
        int[] A = {2,7,11,13};
        Two_Sum_II_Input_array_is_sorted t = new Two_Sum_II_Input_array_is_sorted();
        int[] ans = t.twoSum(A,9);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
