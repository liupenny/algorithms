package String.Valid_Palindrome;/**
 * Created by PennyLiu on 2018/7/18.
 */

public class Solution{
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    public static void main(String[] args)
    {
    
    }
}