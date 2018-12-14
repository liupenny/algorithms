package Math.UglyNumberII;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/13
 */
public class Solution {
    public static int nthUglyNumber(int n) {
        if(n <= 0) {
            return 0;
        }
        int[] index = new int[n + 1];
        index[1] = 1;
        int indexNum = 2, index2 = 1, index3 = 1, index5 = 1;
        while (indexNum<= n) {
            int next = Math.min(Math.min(index[index2]*2, index[index3]*3),index[index5]*5);
            index[indexNum++] = next;
            while (index[index2] * 2 <= next) {
                index2++;
            }
            while (index[index3] * 3 <= next) {
                index3++;
            }
            while (index[index5] * 5 <= next) {
                index5++;
            }
        }
        return index[n];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(5));
    }
}
