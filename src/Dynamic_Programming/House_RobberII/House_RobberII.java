package Dynamic_Programming.House_RobberII;

/**
 * Created by PennyLiu on 2018/5/5.
 */
public class House_RobberII {
    public int rob(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];

        return Math.max(rob(nums, 0,nums.length-2), rob(nums, 1,nums.length - 1));
    }

    public int rob(int[] nums, int begin, int end)
    {
        int moneyL = 0, moneyLL = 0;
        for (int i = begin; i <= end; i++)
        {
            int tmp = moneyL;
            moneyL = Math.max(moneyL, moneyLL + nums[i]);
            moneyLL = tmp;
        }
        return moneyL;
    }

    public static void main(String[] args) {
        House_RobberII t = new House_RobberII();
        int[] nums = {1,2,3,1};
        System.out.println(t.rob(nums));
    }
}
