package Binary_Search.Is_Subsequence;

/**
 * Created by PennyLiu on 2017/10/22.
 */
public class Is_Subsequence {
    public boolean isSubsequence1(String s, String t) {
        if (t=="" && s=="" || s=="") return true;
        else if (t=="" && s!="") return false;

        int lens = s.length(), lent = t.length();
        int i=0,j=0;
        while (i<lens && j<lent)
        {
            if(t.charAt(j) == s.charAt(i))
            {
                i++;
                j++;
            }
            else j++;
        }
        if(i==lens) return true;
        else return false;
    }

    public boolean isSubsequence2(String s, String t) { //快很多
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1); //feed back as the next offset
            if (index == -1) return false;
        }
        return true;
    }

    public static void main(String[] algs)
    {
        String s="abc", t="ahbdc";
        Is_Subsequence ta = new Is_Subsequence();
        boolean ans = ta.isSubsequence2(s,t);
        System.out.println(ans);
    }
}
