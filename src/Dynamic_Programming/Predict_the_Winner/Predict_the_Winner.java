package Dynamic_Programming.Predict_the_Winner;

public class Predict_the_Winner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums==null || nums.length==0) return false;
        if(nums.length == 1) return true;

        int[] sum = new int[nums.length];  //算出0-i位置的数组和
        sum[0] = nums[0];
        int[][] dp = new int[nums.length][nums.length];  //代表i-j这一段能取得的最大值，无论哪一方

        for (int i = 1; i < nums.length; i++)
        {
            sum[i] = sum[i-1] + nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) //1选择0位置
        {
            dp[i][i] = nums[i];
            if (i == nums.length - 1) continue;
            for (int j = i + 1; j < nums.length - 1; j++)
            {
                if(j == i+1)
                {
                    dp[i][j] = Math.max(nums[i],nums[j]);
                    continue;
                }
                dp[i][j] = Math.max(nums[i] + sum[j] - sum[i+1] - dp[i+1][j], nums[j] + sum[j-1] - sum[i] - dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1]*2 > sum[nums.length-1] ? true : false;
    }

    public boolean PredictTheWinner1(int[] nums)
    {
        return winner1(nums,0,nums.length-1,1) >= 0;
    }

    public int winner1(int[] nums, int start, int end, int turn)
    {
        if(start == end) return turn*nums[start];  //很多地方都乘以turn，不要忘了
        int first = nums[start]*turn + winner1(nums, start+1, end, -turn);
        int last = nums[end]*turn + winner1(nums, start, end - 1, -turn);
        return turn*Math.max(turn*first,turn*last);  //外面和里面都要乘以turn
    }

    public boolean PredictTheWinner2(int[] nums)
    {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return winner2(nums, 0, nums.length - 1, memo) >= 0;
    }

    public int winner2(int[] nums, int s, int e, Integer[][] memo) //返回选择首尾后，1和2差值大的那一个
    {
        if (s == e)
            return nums[s];
        if (memo[s][e] != null)
            return memo[s][e];
        int a = nums[s] - winner2(nums, s + 1, e, memo);
        int b = nums[e] - winner2(nums, s, e - 1, memo);
        memo[s][e] = Math.max(a, b);
        return memo[s][e];
    }

    public static void main(String[] args) {
        Predict_the_Winner t = new Predict_the_Winner();
        System.out.println(t.PredictTheWinner2(new int[]{1,5,2}));
    }
}
