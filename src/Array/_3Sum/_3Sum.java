package Array._3Sum;

import java.util.*;

/**
 * Created by PennyLiu on 2017/10/20.

 * 思路：需要的是不重复的答案，所以先排序。在算的时候是，确定一个起始值i,在i+1--end中找剩下的，所以这样就可以跳过重复的起始值。
 */
public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int lo, hi, target;  //三个辅助变量
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {  //排除重复值
                lo = i + 1;
                hi = nums.length - 1;
                target = 0 - nums[i];  //转换成寻找2sum的程序
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == target) {
                        ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++; //找到符合条件的之后，将相等的数跳过,lo+到最后一个等于nums[lo]的地方
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        lo++; //+1到第一个 != lo的数
                        hi--;
                    } else if (nums[lo] + nums[hi] < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = 0 - nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[lo] + nums[hi];
                if(sum == target){
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    while(lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                }
                else if(sum > target) {
                    hi--;
                } else if(sum < target) {
                    lo++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] algs) {
        int[] A = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        _3Sum t = new _3Sum();
        List<List<Integer>> ans = t.threeSum1(A);
        System.out.println(ans);
    }

}
