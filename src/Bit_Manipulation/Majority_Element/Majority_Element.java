package Bit_Manipulation.Majority_Element;

import java.util.Arrays;

public class Majority_Element {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement1(int[] nums) {
        int ans = 0, cnt;
        for(int i = 0; i < 32; i++)
        {
            cnt = 0;
            for (int j = 0; j < nums.length; j++)
            {
                if((nums[j]&(1<<i))!=0)
                {
                    cnt++;
                }
            }
            ans += cnt>nums.length/2 ? 1<<i : 0<<i;
        }
        return ans;
    }

    public int majorityElement2(int[] nums)
    {
        int ans = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if(cnt == 0)
            {
                ans = nums[i];
                cnt = 1;
            }
            else if(nums[i] == ans)
            {
                cnt++;
            }
            else
            {
                cnt--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Majority_Element t = new Majority_Element();
        System.out.println(t.majorityElement2(new int[]{2,2,2,5}));
    }
}
