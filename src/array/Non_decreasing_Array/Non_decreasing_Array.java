package array.Non_decreasing_Array;

/**
 * Created by PennyLiu on 2018/5/31.
 */
public class Non_decreasing_Array {
    public boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return true;
        }

        Integer pos = null; // pos初始为Null的话，也可以用来记到底有几个这样的位置，如果一直null，证明没有这样的点
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > nums[i+1])
            {
                if(pos != null) {
                    return false;
                }
                pos = i;
            }
        }
        // pos在第一个位置，或者倒数第二个位置都可以，
        return (pos == null || pos == 0 || pos == nums.length - 2 || nums[pos - 1] <= nums[pos + 1] || nums[pos] <= nums[pos + 2]);
    }



    public static void main(String[] args) {
        Non_decreasing_Array t = new Non_decreasing_Array();
        int[] nums = {4,2,3};
        System.out.println(t.checkPossibility(nums));
    }
}
