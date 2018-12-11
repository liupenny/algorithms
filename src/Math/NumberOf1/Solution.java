package Math.NumberOf1;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/11
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        if (n <= 0) {
            n = -n;
        }

        for (int i = 1; i < n; i *= 10) {
            int a = n / i, b = n % i;
            count += ((a + 8) / 10) * i;
            if (a%10 == 1) {
                count += (b+1);
            }
        }
        return count;
    }

}
