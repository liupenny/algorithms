package String.Reorganize_String;

import java.util.PriorityQueue;

/**
 * Created by PennyLiu on 2018/7/18.
 */

public class Solution{
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }

        int[] num = new int[26];
        for (char c : S.toCharArray()) {
            num[c - 'a']++;
            // 注意这里是s.length() + 1 / 2 跟当前元素个数+1后去比较
            if(num[c - 'a'] > (S.length() + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Letter> priorityQueue = new PriorityQueue<>((a,b) -> b.num - a.num);
        for (int i = 0; i < num.length; i++) {
            if(num[i] > 0)
            {
                priorityQueue.add(new Letter((char)(i + 97), num[i]));
            }
        }

        // 贪心算法，用优先级队列，不断把次数最多的字符拿出来，当ans为空，或者最后一个字符跟拿出来的不一样时，就加在ans后面；否则再取一个
        StringBuilder ans = new StringBuilder();
        while (!priorityQueue.isEmpty()){
            Letter letter = priorityQueue.poll();
            if(ans.length() == 0 || ans.charAt(ans.length() - 1) != letter.aChar)
            {
                ans.append(letter.aChar);
                if(letter.num - 1 > 0) {
                    priorityQueue.add(new Letter(letter.aChar, letter.num - 1));
                }
            }
            else
            {
                Letter second = priorityQueue.poll();
                ans.append(second.aChar);
                if(second.num - 1 > 0) {
                    priorityQueue.add(new Letter(second.aChar, second.num - 1));
                }
                priorityQueue.add(letter);
            }
        }
        return ans.toString();
    }

    class Letter{
        public char aChar;
        public int num;

        public Letter(char c, int n) {
            aChar = c;
            num = n;
        }
    }


    //首先找出字符数量最大的字符，如果大于S长度的一半，返回空字符串，
    // 如果小于，则将该字符从索引0开始，间隔着放置(0, 2, 4...)。然后再放其他字符，
    //如果偶数索引没有放完，则接着间隔着放，如果偶数索引结束了，则从索引1开始(1, 3, 5...)。
    public String reorganizeString_inter(String S) {
        char[] ch = new char[26];
        int max = 0;
        // 统计个数
        for(char c: S.toCharArray()) {
            ch[c - 'a'] ++;
            if(ch[c-'a'] > ch[max]) {
                max = c - 'a';
            }
        }
        int len = S.length();
        if(len < 2 * ch[max] - 1) {
            return "";
        }
        int index = 0;
        char []res = new char[len];
        for(int i = 0 ; i < ch[max]; i++) {
            res[index] = (char)(max + 'a');
            index += 2;
        }
        ch[max] = 0;
        for(int i = 0 ; i < 26; i++) {
            int count = ch[i];
            while(count > 0 ) {
                if(index >= len ) {
                    index = 1;
                }
                res[index] = (char)(i + 'a');
                index += 2;
                count --;
            }
        }

        return new String(res);
    }

    public static void main(String[] args)
    {
        Solution s  = new Solution();
        String a = "vvvlo";
        // System.out.println(s.reorganizeString(a));
        // System.out.println(s.reorganizeString_sort(a));
        System.out.println(s.reorganizeString_inter(a));
    }
}