package String.Unique_Morse_Code_Words;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PennyLiu on 2018/7/3.
 */

public class Solution{
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        if(words == null || words.length == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < words[i].length(); j++) {
                tmp.append(morse[words[i].charAt(j)-'a']);
            }
            set.add(tmp.toString());
        }

        return set.size();
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(s.uniqueMorseRepresentations(words));
    }
}