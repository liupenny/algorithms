package String.Special_Binary_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    public String makeLargestSpecial(String S) {
        // 到最里面就是"()"，这时候返回
        if(S == null || S.length() == 0 || S.length() == 2) {
            return S;
        }

        // begin从0开始
        int begin = 0, cnt = 0;
        // 每次进入循环都会重新建一个list
        List<String> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
            }

            if(cnt == 0) {
                // 这里截取了 [begin + 1, i) 之前的子串，因为begin,i是一定知道的，所以对里面的进行排序
                res.add("1" + makeLargestSpecial(S.substring(begin + 1, i)) + "0");
                begin = i + 1;
            }
        }
        // 对内部进行排序后返回
        Collections.sort(res, Collections.reverseOrder());
        return String.join("",res);
    }

//    public String makeLargestSpecial(String S) {
//        if(S == null || S.length() == 0)
//            return S;
//
//        // begin从0开始
//        int begin = 1, cnt = 0;
//        List<String> res = new ArrayList<>();
//        for (int i = 1; i < S.length() - 1; i++) {
//            if(S.charAt(i) == '1')
//                cnt++;
//            else
//                cnt--;
//
//            if(cnt == 0) {
//                res.add("1" + makeLargestSpecial(S.substring(begin, i)) + "0");
//                begin = i + 1;
//            }
//        }
//        Collections.sort(res, Collections.reverseOrder());
//        return "1" + String.join("",res) + "0";
//    }

    public static void main(String[] args)
    {
        Solution a = new Solution();
        String S = "11011000";
        System.out.println(a.makeLargestSpecial(S));
    }
}