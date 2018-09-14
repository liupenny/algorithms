package Dynamic_Programming.Wildcard_Matching;

/**
 * Created by PennyLiu on 2018/3/6.
 */
public class Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        if(s == null || s == "" || p == null || p == "") {
            return false;
        }
        return match(s,p,0,0);
    }

    public boolean match(String s, String p, int si, int pi)
    {
        if(si == s.length() - 1) {
            return true;
        }
        if(p.charAt(pi) == '?') //匹配单个字符
        {
            return match(s, p, si+1,pi+1);
        }
        else if(p.charAt(pi) == '*') //匹配任意长度的字符串
        {
            while (si < s.length() && s.charAt(si+1) == s.charAt(si)) {
                si++;
            }
            return match(s, p, si, pi);
        }
        else if(s.charAt(si) == p.charAt(pi)) {
            return match(s, p, si + 1, pi + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Wildcard_Matching t = new Wildcard_Matching();
        System.out.println(t.isMatch("aasaaaa","a*?aa*"));
    }
}
