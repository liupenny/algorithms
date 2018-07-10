package String.Most_Common_Word;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() == 0)
            return "";

        int ans = 0;
        paragraph = paragraph.replaceAll("\\pP","");
        String[] clean = paragraph.split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> record = new HashMap<>();
        String ret = " ";
        for (int i = 0; i < clean.length; i++) {
            if(!set.contains(clean[i]))
            {
                record.put(clean[i].toLowerCase(), record.getOrDefault(clean[i].toLowerCase(), 0) + 1);
                ans = Math.max(ans, record.get(clean[i].toLowerCase()));
            }
        }

        // Iterator iterator = record.keySet().iterator();
        for (String s : record.keySet())
        {
             if(record.get(s) == ans)
             {
                 ret = s;
                 return ret;
             }
        }
        return ret;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(s.mostCommonWord(paragraph,banned));
    }
}