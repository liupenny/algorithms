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
//    public static int StrToInt(String str) {
//
//
//    }

    public static boolean isLeagal(String str) {
        String pattern = "^-?[1-9]//d*$";
        boolean a = Pattern.matches(str, pattern);
        return a;
//        if (str == null || str.length() <= 0 || !Pattern.matches(str, pattern)) {
//            return false;
//        } else {
//            return true;
//        }
//        } else {
//            String min = String.valueOf(Integer.MIN_VALUE);
//            String max = String.valueOf(Integer.MAX_VALUE);
//
//        }
    }

    public static void main(String[] args) {
        String a = "-1995";
        System.out.println(isLeagal(a));
    }
}
