package Binary_Search;

/**
 * 162. Find Peak Element
 A peak element is an element that is greater than its neighbors.
 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 思路：自己分情况写的（很混乱）：0位置>1位置；只有两个元素时，分别判断；最后一个元素大于前面的；中间的元素
 思路1：从元素1开始，每次都是跟前面的元素比较，1跟0比。。。
 */
public class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        if(nums.length == 2)
            return (nums[0]>nums[1])?0:1;
        if(nums[nums.length-1] > nums[nums.length-2])
            return nums.length-1;
        for(int i = 1; i < nums.length-1; i++)
        {
            if(nums[i] > nums[i+1] && nums[i] > nums[i-1])
            {
                return i;
            }
        }
        return 0;
    }

    public int findPeakElement1(int[] num)
    {
        for (int i = 1; i < num.length; i++) {
            if (num[i] < num[i - 1]) {   //很赞
                return i - 1;
            }
        }
        return num.length - 1;
    }

    public static void main(String[] algs)
    {
        Find_Peak_Element t = new Find_Peak_Element();
        int[] A={1,2,3,4,5,2};
        System.out.println(t.findPeakElement(A));
    }
}
