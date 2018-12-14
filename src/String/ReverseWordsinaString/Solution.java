package String.ReverseWordsinaString;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/13
 */
public class Solution {
    // 不会删除前后多余的‘ ’
    public static String reverseWords(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        char[] chr = str.toCharArray();
        int len = chr.length;
        reverse(chr,0, len - 1);
        int begin = 0, end = 0;
        while (begin <= len) {
            if (begin == len || chr[begin] == ' ') {
                begin++;
                end++;
            } else if(end == len || chr[end] == ' ') {
                reverse(chr, begin, end - 1);
                begin = ++end;
            } else {
                end++;
            }
        }
        return String.valueOf(chr);
    }

    public static void reverse(char[] s, int begin, int end) {
        if (s == null || s.length <= 1 || end - begin == 0) {
            return;
        }
        while (begin < end) {
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        }
    }

    //去除首尾空格，缩减单次之间为只有一个空格
    public static String removeDupEmpty(String s) {
        s = s.trim();
        if (s == null || s.length() <= 0) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int start = 0, end = 0, len = s.length();
        while (start < len) {
            char c = s.charAt(end);
            if (c != ' ') {
                ret.append(c);
                end++;
                start = end;
            } else {
                if(end - start == 0) {
                    ret.append(" ");
                }
                end++;
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "the     sky  is   blue";
        // System.out.println(removeDupEmpty(s) + "!");
        //System.out.println(reverseWords(s));
        String a = null;
        char[] aa = a.toCharArray();
        System.out.println(aa);
    }
}
