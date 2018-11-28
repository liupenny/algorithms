package Dynamic_Programming.RegularExpressionMatching;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/27
 */
public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        return matchCore(str,0,pattern,0);
    }

    public boolean matchCore(char[] str, int sIdx, char[] pattern, int pIdx) {
        if (sIdx == str.length && pIdx == pattern.length) {
            return true;
        }
        if (sIdx != str.length && pIdx == pattern.length) {
            return false;
        }

        if(pattern[pIdx+1] == '*') {
            if(pattern[pIdx] == str[sIdx] || (pattern[pIdx]=='.' && sIdx!=str.length)) {
                return matchCore(str,sIdx+1,pattern,pIdx+2) || matchCore(str,sIdx+1,pattern,pIdx) || matchCore(str,sIdx,pattern,pIdx+2);
            } else {
                return matchCore(str,sIdx,pattern,pIdx+2);
            }
        }
        if (pattern[pIdx] == str[sIdx] || (pattern[pIdx] == '.' && sIdx!=str.length)) {
            return matchCore(str, sIdx + 1, pattern, pIdx + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[] a = {'a','a','a'};
        char[] p = {'a','.','a'};
        Solution s = new Solution();
        System.out.println(s.match(a,p));
    }
}
