package Array.Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/5/9.
 */
public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0, res = 0;
        Map<Integer, Integer> arrSum = new HashMap<>();
        arrSum.put(0,1);  //0是累加和的值，1是累加和0出现的次数

        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if(arrSum.containsKey(sum - k)) {
                res += arrSum.get(sum - k);
            }
            if(arrSum.containsKey(sum)) //之前sum出现过，把出现过的次数加一
            {
                arrSum.put(sum, arrSum.get(sum) + 1);
            } else {
                arrSum.put(sum, 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Subarray_Sum_Equals_K t = new Subarray_Sum_Equals_K();
        int[] nums = {1, 1, 1, 2, 1};
        int[] nums1 = {-174,703,438,871,-241,781,429,-215,177,273,-628,106,235,-410,145,-793,-451,913,807,596,-982,709,
                585,-629,966,623,947,-467,-405,552,-858,8,-252,-128,-659,-233,-836,588,324,-817,175,-329,510,-388,878,
                398,231,730,66,-528,857,383,928,-924,199,-750,-868,-652,-133,408,391,685,483,-31,-986,945,271,778,-96,
                677,-961,-130,990,-891,-431,-317,-676,479,-919,-20,-814,3,-89,34,-292,548,201,-119,-94,-442,-934,-491,
                208,-722,115,527,73,636,-681,857};
        int[] nums2 = {1};
        int k1 = -469;
        int k = 3;
        int k2 = 0;
        System.out.println(t.subarraySum(nums2,k2));
    }
}
