package String.Is_Subsequence;

/**
 * Created by PennyLiu on 2018/6/1.
 */
public class Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }

        int index = t.indexOf(s.charAt(0));
        if(index != -1) {
            int j = 0;
            for (j = 1; j < s.length(); j++) {
                int nextIndex = t.indexOf(s.charAt(j), index + 1); //后一个字符出现的位置总在前一个字符位置之后
                if (nextIndex == -1) {
                    break;
                } else if (nextIndex > index) {
                    index = nextIndex;
                }
            }
            if( j == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Is_Subsequence t = new Is_Subsequence();
        String s = "abc", m = "ahbgdc";
        System.out.println(t.isSubsequence(s,m));
    }
}
