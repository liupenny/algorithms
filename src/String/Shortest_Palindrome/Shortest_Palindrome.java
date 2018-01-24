package String.Shortest_Palindrome;

/**
 * Created by PennyLiu on 2018/1/24.
 */
public class Shortest_Palindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <=1) return s;
        char[] arrStr = manacherString(s);
        int L = arrStr.length, C = -1;
        int[] index = new int[arrStr.length];

        for (int i=arrStr.length-1; i>=0; i--)
        {
            index[i] = L < i ? Math.min(i-L,index[2*C-i]) : 1;
            while (i-index[i]>=0 && i+index[i]<arrStr.length)
            {
                if(arrStr[i-index[i]] == arrStr[i+index[i]])
                    index[i]++;
                else
                    break;
            }
            if(i-index[i] < L)
            {
                L = i-index[i];
                C = i;
            }

            if(L==-1)
                break;
        }
        if( 2*C+1 == arrStr.length) return s;
        else
        {
            StringBuilder b = new StringBuilder(s.substring(C, s.length()));
            String res = b.reverse().toString();
            return res + s;
        }
    }

    public static char[] manacherString(String str) {   //生成manacher字符串
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static void main(String[] algs)
    {
        String A="acecaa";
        Shortest_Palindrome t = new Shortest_Palindrome();
        System.out.println(t.shortestPalindrome(A));
    }

}
