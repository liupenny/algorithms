package Array;

/**
 * Created by PennyLiu on 2017/10/20.
 * 167. Two Sum II - Input array is sorted
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 * 思路1：hashmap实现
 * 思路2：用两个指针分别指向头和尾，依次移动.两个节点求和的一般都是双指针方法
 */
public class Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int lo = 0, hi = numbers.length-1;
        while (numbers[lo] + numbers[hi] != target)
        {
            if(numbers[lo] + numbers[hi]>target)
                hi--;
            else if(numbers[lo] + numbers[hi]<target)
                lo++;
        }
        ans[0] = lo+1;
        ans[1] = hi+1;
        return ans;
    }

    public static void main(String[] algs)
    {
        int[] A = {2,7,11,13};
        Two_Sum t = new Two_Sum();
        int[] ans = t.twoSum(A,9);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
