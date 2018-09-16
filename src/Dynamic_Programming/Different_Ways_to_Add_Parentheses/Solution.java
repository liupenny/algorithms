package Dynamic_Programming.Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/7/12.
 */

public class Solution{
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        if(input == null || input.length() == 0) {
            return ans;
        }
        return compute(input);
    }

    public List<Integer> compute(String input)
    {
        List<Integer> res = map.get(input);
        if(res != null) {
            return res;
        }

        res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 如果是符号，就分为左右两边，分别递归
            if(c == '+' || c == '-' || c == '*')
            {
                List<Integer> left = compute(input.substring(0,i));
                List<Integer> right = compute(input.substring(i+1));
                // 算完左右两边，再根据符号进行笛卡尔积
                for (int l: left) {
                    for (int r: right) {
                        switch (c)
                        {
                            case '+': res.add(l + r); break;
                            case '-': res.add(l - r); break;
                            case '*': res.add(l * r); break;
                            default:break;
                        }
                    }
                }
            }
        }
        // 此时input就是一个单独的数，直接添加即可
        if(res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }
        map.put(input, res);
        return res;
    }

    public static void main(String[] args)
    {
    
    }
}