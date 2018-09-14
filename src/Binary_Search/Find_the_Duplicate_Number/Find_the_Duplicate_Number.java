package Binary_Search.Find_the_Duplicate_Number;

/**
 * Created by PennyLiu on 2017/10/24.
 * 287. Find the Duplicate Number
 * findDuplicate(6ms)：利用角标和数组元素本身的大小关系去找
 * findDuplicate1(1ms)：将数组元素和角标一起看成一个有环的链表，https://leetcode.com/problems/find-the-duplicate-number/discuss/
 */
public class Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length-1,count, mid;
        while (lo < hi)
        {
            count = 0;
            mid = lo + (hi - lo) / 2;  //所有数的中位数
            for (int i=0; i<nums.length; i++)
            {
                if(nums[i]<=mid)  //共有多少数小于中位数
                {
                    count++;
                }
            }
            if(count <= mid) {
                lo = mid + 1;     //小于中位数小于一半，则重复的数出现在大于的那一半里面
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int findDuplicate1(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow)
        {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] algs)
    {
        Find_the_Duplicate_Number t = new Find_the_Duplicate_Number();
        int[] A = {1, 3, 4, 2, 2};
        int ans = t.findDuplicate1(A);
        System.out.println(ans);

    }
}
