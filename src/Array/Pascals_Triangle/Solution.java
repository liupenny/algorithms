package Array.Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/24.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) {
            return res;
        }

        for (int i = 1; i <= numRows; i++)
        {
            List<Integer> temp = new ArrayList<>();
            if(i == 1) {
                temp.add(1);
            }
            if(i == 2)
            {
                temp.add(1);
                temp.add(1);
            }
            if(i >= 3)
            {
                for (int j = 0; j < i; j++)
                {
                    if(j == 0) {
                        temp.add(1);
                    } else if(j == i-1) {
                        temp.add(1);
                    } else
                    {
                        List<Integer> before = res.get(i-2);
                        temp.add(before.get(j-1) + before.get(j));
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }



    public static void main(String[] args)
    {
        Solution t = new Solution();
        int numRows = 5;
        System.out.println(t.generate(numRows));
    }
}
