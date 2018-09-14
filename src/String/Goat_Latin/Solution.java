package String.Goat_Latin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    public String toGoatLatin(String S) {
        if(S == null || S.length() == 0) {
            return S;
        }

        String[] array = S.split(" ");
        Set<Character> set = new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        StringBuilder a = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > 1 && !set.contains(array[i].charAt(0))) {
                array[i] = array[i].substring(1, array[i].length()) + array[i].substring(0, 1);
            }
            array[i] += "ma";
            array[i] += a.append("a").toString();
            res.append(" " + array[i]);
        }
        return res.toString().substring(1);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        // String a = "The quick brown fox jumped over the lazy dog";
        String a = "I speak Goat Latin";
        System.out.println(s.toGoatLatin(a));
    }
}