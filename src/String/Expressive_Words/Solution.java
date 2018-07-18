package String.Expressive_Words;

/**
 * Created by PennyLiu on 2018/7/13.
 */

public class Solution{
    public int expressiveWords(String S, String[] words) {
        if (S == null || S.length() == 0 || words == null || words.length == 0)
            return 0;

        int ans = 0;
        for (String word : words) {
            // j是word的index
            int j = 0, i = 0;
            while (i < S.length()) {
                // 这两个index表示S和word重复子串的index,从下一位开始比较，所以在计算相同字符长度的时候是
                // indexS - i 而不是 indexS - i + 1
                int indexS = i + 1, indexWord = j + 1;
                while (indexS < S.length() && S.charAt(indexS) == S.charAt(i))
                    indexS++;
                while (indexWord < word.length() && word.charAt(indexWord) == word.charAt(j))
                    indexWord++;

                // 这里先判断两个字符串还没到末尾
                if(i < S.length() && j < word.length() && S.charAt(i) == word.charAt(j) && ((indexS - i >= 3 && indexS - i >= indexWord - j) || (indexS - i== indexWord - j)))
                {
                    i = indexS;
                    j = indexWord;
                }
                else
                    break;
            }
            // 这里要判断两个都到了末尾
            if(j == word.length() && i == S.length())
                ans++;
        }
        return ans;
    }

    // 答案的分得更清晰，把子函数单独拿出来
    public int expressiveWords_ans(String S, String[] words) {
        int res = 0;
        for (String word: words) {
            if (isExtensible(word, S)) {
                res++;
            }
        }
        return res;
    }

    private boolean isExtensible(String w, String s) {
        int i = 0, j = 0;
        while (i < w.length() && j < s.length()) {
            if (w.charAt(i++) != s.charAt(j++)) {
                return false;
            }
            int m = 1, n = 1;
            while (i < w.length() && w.charAt(i - 1) == w.charAt(i)) {
                i++;
                m++;
            }
            while (j < s.length() && s.charAt(j - 1) == s.charAt(j)) {
                j++;
                n++;
            }
            if (m > n || (m < n && n < 3)) {
                return false;
            }
        }
        return i == w.length() && j == s.length();
    }

    public static void main(String[] args)
    {
        String s = "heeellooo";
        String[] words = {"axxxrrzzz"};
        Solution a = new Solution();
        System.out.println(a.expressiveWords(s,words));
    }
}