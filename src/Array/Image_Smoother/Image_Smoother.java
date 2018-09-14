package Array.Image_Smoother;

/**
 * Created by PennyLiu on 2018/5/15.
 */
public class Image_Smoother {
    public int[][] imageSmoother(int[][] M)
    {
        if(M == null || M.length == 0) {
            return new int[0][0];
        }
        int row = M.length, col = M[0].length;
        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                res[i][j] = help(M, i, j);
            }
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

        return res;
    }

    public int help(int[][] M, int i, int j)
    {
        int scale = M[i][j], num = 1;
        if(i - 1 >= 0)
        {
            scale += M[i - 1][j];
            num++;
            if(j - 1 >= 0)
            {
                scale += M[i - 1][j - 1];
                num++;
            }
            if(j + 1 <= M[0].length - 1)
            {
                scale += M[i - 1][j + 1];
                num++;
            }
        }
        if(i + 1 <= M.length - 1)
        {
            scale += M[i + 1][j];
            num++;
            if(j - 1 >= 0)
            {
                scale += M[i + 1][j - 1];
                num++;
            }
            if(j + 1 <= M[0].length - 1)
            {
                scale += M[i + 1][j + 1];
                num++;
            }
        }
        if(j - 1 >= 0)
        {
            scale += M[i][j - 1];
            num++;
        }
        if(j + 1 <= M[0].length - 1)
        {
            scale += M[i][j + 1];
            num++;
        }
        return scale/num;
    }

    public int[][] imageSmoother1(int[][] M) { //遍历技巧很方便
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r - 1; nr <= r + 1; ++nr) {
                    for (int nc = c - 1; nc <= c + 1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {  //这里只要一次判断即可
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                }
                ans[r][c] /= count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Image_Smoother t = new Image_Smoother();
        int[][] nums = {{1,1,1}, {1,0,1}, {1,1,1}};
        t.imageSmoother(nums);
    }
}
