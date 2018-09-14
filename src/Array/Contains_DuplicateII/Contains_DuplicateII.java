package Array.Contains_DuplicateII;

import java.util.*;

/**
 * Created by PennyLiu on 2018/5/16.
 */
public class Contains_DuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        if(nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]) == false)
            {
//                List poss = new ArrayList<>();
//                poss.add(i);
//                map.put(nums[i], poss);
                map.put(nums[i], new ArrayList<>(Arrays.asList(i)));
            }
            else
            {
                List poss = map.get(nums[i]);
                for (int j = 0; j < poss.size(); j++)
                {
                    if(i - (int)poss.get(j) <= k) {
                        return true;
                    }
                }
                poss.add(i);
                map.put(nums[i], poss);
            }
        }
        return false;
    }

    // 滑动窗口
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) {
                set.remove(nums[i - k - 1]); // 把离nums[i]的距离>k的全删掉
            }
            if(!set.add(nums[i])) {
                return true; //目前这些元素都是距离nums[i]<=k的，所以如果没有添加成功，就证明已经存在这个数了
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Contains_DuplicateII t = new Contains_DuplicateII();
        int[] nums = {99,99};
        int k = 2;
        System.out.println(t.containsNearbyDuplicate1(nums,k));
    }
}
