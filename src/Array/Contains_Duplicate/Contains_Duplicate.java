package Array.Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PennyLiu on 2018/5/16.
 */
public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums)
    {
        if(nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> map = new HashSet<>();
        for (int num: nums)
        {
            if(map.contains(num) == false) {
                map.add(num);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Contains_Duplicate t = new Contains_Duplicate();
        int[] nums = {1,2,3,4};
        System.out.println(t.containsDuplicate(nums));
    }
}
