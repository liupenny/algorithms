package String.Repeated_String_Match;/**
 * Created by PennyLiu on 2018/7/18.
 */

public class Solution{
    public int repeatedStringMatch(String A, String B) {
        if(A == null || A.length() == 0) {
            return -1;
        }

        int times = 1;
        StringBuilder stringBuilder = new StringBuilder(A);
        for(;stringBuilder.length() < B.length();times++) {
            stringBuilder.append(A);
        }
        if(stringBuilder.indexOf(B) >= 0) {
            return times;
        }
        if(stringBuilder.append(A).indexOf(B) >= 0) {
            return times + 1;
        }
        return -1;
    }

    public int repeatedStringMatch1(String A, String B) {
        int count = 1;
        int i = 0;
        for (int j = 0; j < B.length(); j++) {
            if (A.charAt(i) != B.charAt(j)) {
                if (count > 1) {       // already second time: no way to make B from A
                    return -1;
                }
                j = -1;    // try to match j's starting character with next i
            }

            i++;
            if (i == A.length()) {        // one more time of A
                if (j == B.length() - 1) {
                    break;
                }
                count++;
                i = 0;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        Solution s  = new Solution();
        String A = "abcd" , B = "cdabcdab";
        System.out.println(s.repeatedStringMatch1(A,B));
    }
}