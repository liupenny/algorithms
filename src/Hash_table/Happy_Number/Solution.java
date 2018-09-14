package Hash_table.Happy_Number;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PennyLiu on 2018/7/29.
 */

public class Solution{
    //超时
    public boolean isHappy(int n) {
        if(n == 0) {
            return false;
        }

        Set<Long> res = new HashSet<>();
        String strn = String.valueOf(n);
        long tmp = 0;
        while (!res.contains(tmp)) {
            for (int i = 0; i < strn.length(); i++) {
                Integer c = Integer.valueOf(strn.charAt(i) - '0');
                tmp += Math.pow(c, 2.0);
            }
            if(tmp == 1) {
                return true;
            }
            res.add(tmp);
            strn = String.valueOf(tmp);
            tmp = 0;
        }
        return false;
    }

    // 一直计算到1会超时，出现重复的就返回false就行
    public boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1)
        {
            int res = 0;
            while (n != 0){
                res += Math.pow(n%10,2);
                n/=10;
            }
            if(set.contains(res)) {
                return false;
            }
            set.add(res);
            n = res;
        }
        return true;
    }
        public static void main(String[] args)
    {
        Solution s  = new Solution();
        int a = 19;
        System.out.println(s.isHappy(a));
    }
}