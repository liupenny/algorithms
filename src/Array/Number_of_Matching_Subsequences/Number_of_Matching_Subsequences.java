package Array.Number_of_Matching_Subsequences;

import java.text.StringCharacterIterator;
import java.util.*;

/**
 * Created by PennyLiu on 2018/6/1.
 */
public class Number_of_Matching_Subsequences {
    public int numMatchingSubseq(String S, String[] words) { //效率最低的
        if(S == null || S.length() == 0 || words == null || words.length == 0)
            return 0;

        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            int index = S.indexOf(words[i].charAt(0));
            if(index != -1) {
                int j = 0;
                for (j = 1; j < words[i].length(); j++) { //后一个字符出现的位置总在前一个字符位置之后
                    int nextIndex = S.indexOf(words[i].charAt(j), index + 1);
                    if (nextIndex == -1)
                        break;
                    else if (nextIndex > index)
                        index = nextIndex;
                }
                if( j == words[i].length())
                    ans++;
            }
            else
                continue;
        }
        return ans;
    }

    public int numMatchingSubseq1(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0)
            return 0;

        Map<Character, Deque<String>> map = new HashMap<>(); //用双端队列，这样可以从前面取出来后再插入
        for (char i = 'a'; i < 'z'; i++) {
            map.putIfAbsent(i, new LinkedList<>());  //先建立首字母的队列map
        }
        for (String word: words) {
            map.get(word.charAt(0)).addLast(word);
        }

        int count = 0;
        for (char c: S.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if(word.length() == 1)
                    count++;
                else
                    map.get(word.charAt(1)).addLast(word.substring(1));  //不能在上面的word之间操作，没用
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Number_of_Matching_Subsequences t = new Number_of_Matching_Subsequences();
        String S = "abcde";
        String[] words = {"a", "b", "adc", "es"};
        System.out.println(t.numMatchingSubseq(S, words));
    }
}
