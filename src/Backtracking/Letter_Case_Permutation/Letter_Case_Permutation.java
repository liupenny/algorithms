package Backtracking.Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

/**
 * Created by PennyLiu on 2018/5/14.
 */
public class Letter_Case_Permutation {
    private static Pattern pattern = Pattern.compile("[0-9]*");
    public List<String> letterCasePermutation(String S)
    {
        List<String> res = new ArrayList<>();
        if(pattern.matcher(S).matches())
        {
            res.add(new String(S));
            return res;
        }
        StringBuilder temp = new StringBuilder();
        help(S, temp, res, 0);
        return res;
    }

    public void help(String S, StringBuilder temp, List<String> res, int i)
    {
        if(i == S.length())
        {
            res.add(new String(temp));
            return;
        }

        char c = S.charAt(i);
        if(Character.isLetter(c))
        {
            temp.append(Character.toLowerCase(c));
            help(S, temp, res, i+1);
            temp.setLength(temp.length() - 1);
            temp.append(Character.toUpperCase(c));
            help(S, temp, res, i+1);
        }
        else
        {
            temp.append(c);
            help(S, temp, res, i+1);
        }
        temp.setLength(temp.length()-1);
    }

    public List<String> letterCasePermutation1(String S) {
        Queue<String> r = new LinkedList<>();
        r.add(S);
        for (int i = 0; i < S.length(); i++) {//分析字符串每一个字符
            char c = S.charAt(i);
            if (Character.isLetter(c)) {//如果该字符为英文字符，继续执行
                int size = r.size();
                for (int j = 0; j < size; j++) {//队列内存放目前为止各种情况
                    String s = r.poll();//每一次弹出一个保存的String
                    r.add(s.substring(0, i) + Character.toLowerCase(c) + s.substring(i + 1));
                    r.add(s.substring(0, i) + Character.toUpperCase(c) + s.substring(i + 1));
                    //弹出后将该字符串的当前位置字符分别替换为大小写，保存到队列中
                }
            }
        }
        return (List)r;
    }

    public static void main(String[] args)
    {
        Letter_Case_Permutation t = new Letter_Case_Permutation();
        String S = "12345";
        System.out.println(t.letterCasePermutation(S));
    }
}
