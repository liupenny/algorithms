package Array.Move_Zeroes;

/**
 * Created by PennyLiu on 2018/4/30.
 */
public class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        //通过数组中元素个数，一起判断数组全部为0或全部非0
        int totalNum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0) {
                totalNum++;
            }
        }
        if(totalNum == 0 || totalNum == nums.length) {
            return;
        }

        for (int i = 0, lastNonezeropos = 0; i < nums.length; i++)
        {
            if(nums[i] != 0) {
                swap(nums, lastNonezeropos++, i);
            }
        }
        for (int t:nums)
        {
            System.out.print(t + " ");
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Move_Zeroes t = new Move_Zeroes();
        t.moveZeroes(nums);
    }
}
