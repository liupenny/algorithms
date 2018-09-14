package Binary_Search.Find_Peak_Element;

/**
 * 162. Find Peak Element

 思路：自己分情况写的（很混乱）：0位置>1位置；只有两个元素时，分别判断；最后一个元素大于前面的；中间的元素
 思路1：从元素1开始，每次都是跟前面的元素比较，1跟0比。。。
 */
public class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums.length == 2) {
            return (nums[0] > nums[1]) ? 0 : 1;
        }
        if(nums[nums.length-1] > nums[nums.length-2]) {
            return nums.length - 1;
        }
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
