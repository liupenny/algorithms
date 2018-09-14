package Array.Remove_Element;


/**
 * Created by PennyLiu on 2018/4/30.
 */
public class Remove_Element {
    public int removeElement(int[] nums, int val)
    {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        //通过数组中元素个数，一起判断数组全部为val或全部非val
        int totalNum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] == val) {
                totalNum++;
            }
        }
        if(totalNum == 0) {
            return nums.length;
        }
        if(totalNum == nums.length) {
            return 0;
        }

        int nonVal = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] != val) {
                swap(nums, nonVal++, i);
            }
        }

        return nonVal;
    }

    public void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        Remove_Element t = new Remove_Element();
        System.out.println(t.removeElement(nums, val));
    }
}
