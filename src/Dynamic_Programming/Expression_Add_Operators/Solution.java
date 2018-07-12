package Dynamic_Programming.Expression_Add_Operators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/7/12.
 */

public class Solution{
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if(num == null || num.length() == 0)
            return ans;

        // char[] numChar = num.toCharArray();
        //String temp = new String();
        isSum(ans, num, "", target, 0, 0,0);
        return ans;
    }

    //temp是当前组成的字符串， prev是上一个整数， sum是当前字符串的和
    public void isSum(List<String> ans, String num, String temp, int target, int index, long sum, long prev)
    {
        if(index == num.length())
        {
            if(sum == target)
                ans.add(temp);
            return;
        }
        // 这里的循环就是在字符中填空格，使两个字符连接起来，其成为一个新的更大的数
        for (int i = index; i < num.length(); i++) {
            // 03是不合法的，直接退出
            if(i != index && num.charAt(index) == '0')
                break;
            long cur = Long.parseLong(num.substring(index, i + 1));
            if(index == 0)
                isSum(ans, num, temp + cur, target, i + 1, cur, cur);
            else
            {
                isSum(ans,num,temp + '+' + cur, target, i + 1, sum + cur, cur);
                isSum(ans,num,temp + '-' + cur, target, i + 1, sum - cur, -cur);
                // 相乘的时候，字符串表达式不受影响，只是字符串所代表的值要改动，同时prev也要改变为当前的数相乘的结果
                isSum(ans,num,temp + '*' + cur, target, i + 1, sum - prev + prev * cur, prev * cur);
            }
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String num = "105";
        int target = 5;
        System.out.println(solution.addOperators(num, target));
    }
}