package Math.LargestTimeforGivenDigits;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/2
 */
class Solution {
    String ans;
    public String largestTimeFromDigits(int[] A) {
        ans = "";
        check(A[0],A[1],A[2],A[3]);
        check(A[0],A[2],A[1],A[3]);
        check(A[0],A[3],A[1],A[2]);
        check(A[1],A[2],A[0],A[3]);
        check(A[1],A[3],A[0],A[2]);
        check(A[2],A[3],A[0],A[1]);
        return ans;
    }

    public void check(int h1, int h2, int m1, int m2) {
        String hour = best(h1, h2, 24);
        String min = best(m1, m2, 60);
        if (hour.isEmpty() || min.isEmpty()) {
            return;
        }
        String tmp = hour + ":" + min;
        if (tmp.compareTo(ans) > 0) {
            ans = tmp;
        }
    }

    public String best(int n1, int n2, int max) {
        int ans = Math.max(10*n1+n2 < max ? 10*n1+n2 : -1, 10*n2+n1 < max ? 10*n2+n1 : -1);
        return ans >= 0 ? String.format("%02d",ans):"";
    }
}
