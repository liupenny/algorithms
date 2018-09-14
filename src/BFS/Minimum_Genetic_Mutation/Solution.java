package BFS.Minimum_Genetic_Mutation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by PennyLiu on 2018/9/11.
 */

public class Solution{
    public int minMutation(String start, String end, String[] bank) {
        Set<String> dict = new HashSet<>();
        for (String word:bank) {
            dict.add(word);
        }

        if(!dict.contains(end)) {
            return -1;
        }

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(start);
        q2.add(end);

        int len = start.length();
        int steps = 0;
        char[] gene = new char[]{'A','C','G','T'};

        while (!q1.isEmpty() && !q2.isEmpty()){
            steps++;
            if(q1.size() > q2.size()){
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            Set<String> tmpq = new HashSet<>();
            for (String w:q1){
                char[] chars = w.toCharArray();
                for(int i = 0;i < len; i++){
                    // 保存当前位置，后面还要改回来
                    char ch = chars[i];
                    for (char c : gene){
                        if(ch == c) {
                            continue;
                        }
                        chars[i] = c;
                        String newString = new String(chars);
                        if(q2.contains(newString)) {
                            return steps;
                        }
                        if(!dict.contains(newString)) {
                            continue;
                        }
                        dict.remove(newString);
                        tmpq.add(newString);
                    }
                    chars[i] = ch;
                }
            }
            q1 = tmpq;
        }
        return -1;
    }

    public static void main(String[] args){
       String start = "AACCGGTT" , end = "AAACGGTA";
       String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
       Solution s = new Solution();
       System.out.println(s.minMutation(start, end, bank));
    }
}