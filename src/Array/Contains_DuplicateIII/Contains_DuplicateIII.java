package Array.Contains_DuplicateIII;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by PennyLiu on 2018/5/16.
 */
public class Contains_DuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //input check
        if(k<1 || t<0 || nums==null || nums.length<2) {
            return false;
        }

        SortedSet<Long> set = new TreeSet<Long>();

        for(int j=0; j<nums.length; j++) {
            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);
            if(!subSet.isEmpty()) {
                return true;
            }

            if(j>=k) {
                set.remove((long)nums[j-k]);
            }
            set.add((long)nums[j]);
        }
        return false;
    }

    public static void main(String[] args) {
        Contains_DuplicateIII a = new Contains_DuplicateIII();
        int[] nums = {1,3,1};
        int k = 1, t = 1;
        int[] nums1 = {-2147483648,-2147483647};
        int k1 = 3, t1 = 3;
        System.out.println(a.containsNearbyAlmostDuplicate(nums1, k1, t1));
    }
}
