package array.Spiral_MatrixII;

/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Spiral_MatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if(n == 0) {
            return ans;
        }

        int r1 = 0, r2 = ans.length - 1;
        int c1 = 0, c2 = ans[0].length - 1;
        int num = 1;
        while (r1 <= r2 && c1 <= c2)
        {
            for (int c = c1; c <= c2 ; c++) {
                ans[r1][c] = num++;
            }
            for (int r = r1 + 1; r <= r2 ; r++) {
                ans[r][c2] = num++;
            }
            if (r1 < r2 && c1 < c2)
            {
                for (int c = c2 - 1; c > c1; c--) {
                    ans[r2][c] = num++;
                }
                for (int r = r2; r > r1 ; r--) {
                    ans[r][c1] = num++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }

//        for (int i = 0; i < ans.length; i++) {
//            for (int j = 0; j < ans[0].length; j++) {
//                System.out.print(ans[i][j] + " ");
//            }
//            System.out.println(" ");
//        }
        return ans;
    }

    public static void main(String[] args) {
        Spiral_MatrixII t = new Spiral_MatrixII();
        int n = 5;
        t.generateMatrix(n);
    }
}
