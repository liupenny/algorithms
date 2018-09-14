package String.Valid_Palindrome;/**
 * Created by PennyLiu on 2018/7/18.
 */

public class Solution{
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);

    }

    public boolean isPalindrome1(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        char[] arr = s.toLowerCase().toCharArray();
        int left = 0, right = arr.length - 1;
        while(left < right)
        {
            while( left < right && !Character.isLetterOrDigit(arr[left]) ) {
                left++;
            }
            while( left < right && !Character.isLetterOrDigit(arr[right]) ) {
                right--;
            }
            if(arr[left] != arr[right] ) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }

    public String reverseString(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while(left < right)
        {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }

        String ans = String.valueOf(arr);
        return ans;
    }

        public static void main(String[] args)
    {
        Solution s  = new Solution();
        String a = "12c";
        // System.out.println(s.reorganizeString(a));
        // System.out.println(s.reorganizeString_sort(a));
        // s.isPalindrome1(a);
        System.out.println(s.reverseString(a));
    }
}