package Array.Find_Pivot_Index;

/**
 * Created by PennyLiu on 2018/5/25.
 */
public class Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;

        int sum = 0;
        for (int num:nums) {
            sum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if(i == 0)
                leftSum = 0;
            else
                leftSum += nums[i-1];
            if(leftSum == sum - leftSum - nums[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Find_Pivot_Index t = new Find_Pivot_Index();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] num = {-1,-1,-1,0,1,1};
        System.out.println(t.pivotIndex(num));
    }
}
