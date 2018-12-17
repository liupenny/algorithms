package String.StringToInteger;

import java.util.regex.Pattern;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/13
 */
public class Solution {
    public static int StrToInt(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        char[] a = str.toCharArray();
        int sign = 1;
        int beginPos = 0, ans = 0;
        if (a[0] == '-' || a[0] == '+') {
            sign = (a[0] == '-' ? -1 : 1);
            beginPos++;
        }
        for (int i = beginPos; i < a.length; i++) {
            if (a[i] < 48 || a[i] > 57) {
                return 0;
            }
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MIN_VALUE/10 && a[i] - '0' > 7)) {
                return 0;
            }
            ans = ans * 10 + a[i] - '0';
        }
        return sign * ans;
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        char[] a = str.toCharArray();
        int sign = 1, i = 0, ans = 0;
        while (i < a.length && a[i] == ' ') {
            i++;
        }
        if (i < a.length && (a[i] == '-' || a[i] == '+')) {
            sign = (a[i] == '-' ? -1 : 1);
            i++;
        }
        while (i < a.length && a[i] >= '0' && a[i] <= '9') {
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && a[i] - '0' > 7)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            ans = ans * 10 + a[i] - '0';
            i++;
        }
        return sign * ans;
    }

    public static void main(String[] args) {
        String a = "2147483648";
        System.out.println(myAtoi(a));
    }
}
