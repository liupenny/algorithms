package String.Add_Binary;/**
 * Created by PennyLiu on 2018/7/10.
 */

public class Solution{
    public String addBinary(String a, String b) {
        if(a == null || b == null || a.length() == 0 || b.length() == 0) {
            return (a == null || a.length() == 0) ? b : a;
        }

        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();

        int aDigit, bDigit;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--,j--) {
            aDigit = (i > -1) ? a.charAt(i) - '0' : 0;
            bDigit = (j > -1) ? b.charAt(j) - '0': 0;
            stringBuilder.append((aDigit + bDigit + carry)%2);
            carry = (aDigit + bDigit + carry)/2;
        }
        if(carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.addBinary("11","1"));
    }
}