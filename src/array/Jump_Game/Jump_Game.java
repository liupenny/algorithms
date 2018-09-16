package array.Jump_Game;

/**
 * Created by PennyLiu on 2018/6/7.
 */
public class Jump_Game {
    // 回溯法
    public boolean canJump_backtrack(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }

        return canJumpFromPosition(0, nums);
    }

    public boolean canJumpFromPosition(int pos, int[] nums)
    {
        if(pos == nums.length - 1) {
            return true;
        }

        int furthestpos = Math.min(pos + nums[pos], nums.length - 1);
        for (int i = furthestpos; i > pos; i--) {
            if(canJumpFromPosition(i, nums)) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump_dp(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }

        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition_dp(0, nums, memo);
    }


    enum Index{
        // 三种状态
        GOOD,
        BAD,
        UNKNOWN
    }

    public boolean canJumpFromPosition_dp(int pos, int[] nums, Index[] memo)
    {
        if(memo[pos] != Index.UNKNOWN) {
            return memo[pos] == Index.GOOD ? true : false;
        }

        int furthestpos = Math.min(pos + nums[pos], nums.length - 1);
        for (int i = furthestpos; i > pos; i--) {
            if(canJumpFromPosition(i, nums)) {
                memo[i] = Index.GOOD;
                return true;
            }
        }
        memo[pos] = Index.BAD;
        return false;
    }

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1; //终点位置，能到这里就可以了
        for (int i = nums.length - 1; i >=0 ; i--) {
            if(i + nums[i] >= lastPos) //每一步都判断一下是否能到
            {
                lastPos = i; //修改能到的最后的位置
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        Jump_Game t = new Jump_Game();
        int[] nums = {3,2,1,0,4};
        System.out.println(t.canJump(nums));
    }
}
