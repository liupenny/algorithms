package Array.Positions_of_Large_Groups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/7.
 */
public class Positions_of_Large_Groups {
    public List<List<Integer>> largeGroupPositions(String S)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (S == null || S.length() == 0 || S.length() < 3) {
            return res;
        }

        char nowLetter = S.charAt(0);
        int nowNum = 1, beginPos = 0, endPos = 0;
        for (int i = 1; i < S.length(); i++)
        {
            if(S.charAt(i) == nowLetter)
            {
                nowNum++;
                endPos = i;
            }
            else
            {
                if(nowNum >= 3)
                {
                    List<Integer> tmp = Arrays.asList(beginPos, endPos);
                    res.add(tmp);
                }
                nowLetter = S.charAt(i);
                nowNum = 1;
                beginPos = i;
            }
        }
        if(nowNum >= 3) //有可能结尾最后一个满足条件，但被忽略了
        {
            List<Integer> tmp = Arrays.asList(beginPos, endPos);
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args)
    {
        Positions_of_Large_Groups t = new Positions_of_Large_Groups();
        String s = "abcdddeeeeaabbbcd";
        String s1 = "aaa";
        String s2 = "abbxxxxzzy";
        System.out.println(t.largeGroupPositions(s1));
    }
}
