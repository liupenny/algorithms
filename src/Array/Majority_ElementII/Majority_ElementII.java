package Array.Majority_ElementII;

import java.util.ArrayList;
import java.util.List;

public class Majority_ElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>(2);
        if(nums == null || nums.length <2) {
            return ans;
        }

        int cnt1 = 0, cnt2 = 0;
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] == ans1)
            {
                cnt1++;
            }
            else if (nums[i] == ans2)
            {
                cnt2++;
            }
            else if (cnt1 == 0)
            {
                ans1 = nums[i];
                cnt1 = 1;
            }
            else if (cnt2 == 0)
            {
                ans2 = nums[i];
                cnt2 = 1;
            }
            else  //都不相等的时候，两个数字的贡献都要--
            {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;    //因为题目中没说一定存在这样的两个数，所以有可能原数组中每个数出现一次，得到的是最后两个数。还要在原数组中算一下
        cnt2 = 0;
        for (int num:nums)
        {
            if(num == ans1) //有可能数组中有多个重复元素，所以对于数组的每次元素只能判断一次，所以必须加上else
            {
                cnt1++;
            }
            else if(num == ans2)  //不然会判断两次
            {
                cnt2++;
            }
        }
        if (cnt1 > nums.length/3)
        {
            ans.add(ans1);
        }
        if (cnt2 > nums.length/3)
        {
            ans.add(ans2);
        }
        return ans;
    }

    public static void main(String[] args) {
        Majority_ElementII t = new Majority_ElementII();
        System.out.println(t.majorityElement(new int[]{1,1,1,2,3,3,3,4}));
    }
}
