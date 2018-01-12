package Binary_Search.Max_Sum_of_Rectangle_No_Larger_Than_K;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by PennyLiu on 2018/1/11.
 * 按题目描述是行数小于列数
 * maxSumSubmatrix（630ms）：按照左神课程中的思路来的
 * maxSumSubmatrix1(29ms)：经过优化后
 */
public class Max_Sum_of_Rectangle_No_Larger_Than_K {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;

//  错误的想法，因为要算1,1+2,1+2+3...行 + 2,2+3,2+3+4... 如果像下面这样就只算了 1,1+2,1+2+3...行
//        for (int i=0; i<row; i++)
//        {
//            for (int j=0; j<col; j++)
//                colsum[j] = colsum[j] + matrix[i][j];
//            max = Math.max(max, maxSumOneDemision(colsum,k));
//        }

        // 以行为外循环  630ms
        for (int i=0; i<row; i++)
        {
            int[] colsum = new int[col];
            for (int j=i; j<row; j++)
            {
                for (int c=0; c<col; c++)
                    colsum[c] += matrix[j][c];  // 这里已经实现了节省空间，只用一个数组变量存储之前的信息了
                max = Math.max(max, maxSumOneDemision(colsum,k));
            }
        }

        //用列做外循环  159ms
        for (int i=0; i<col; i++)
        {
            int[] rowsum = new int[row];
            for (int j=i; j<col; j++)
            {
                for (int c=0; c<row; c++)
                    rowsum[c] += matrix[c][j];  // 这里已经实现了节省空间，只用一个数组变量存储之前的信息了
                max = Math.max(max, maxSumOneDemision(rowsum,k));
            }
        }

        return max;
    }

    public int maxSumOneDemision(int[] nums, int k)  //求一维数组中子段和《k的最大子段和，这一部分不能用数组，因为数组的Binary是根据数组有序找的，现在的数组不是有序的，用treeset
    {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> s = new TreeSet();
        s.add(0);

        for(int i = 0;i < nums.length; i ++){
            int t = sum + nums[i];
            sum = t;
            Integer gap = s.ceiling(sum - k);
            if(gap != null) max = Math.max(max, sum - gap);
            s.add(t);
        }

        return max;
    }

    public int maxSumSubmatrix1(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {  //预先判断，排除问题数组
            return 0;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {  //用列做外循环
            int[] sums = new int[matrix.length];

            for (int j = i; j < matrix[0].length; j++) {
                int max = Integer.MIN_VALUE;

                int sum = 0;
                for (int m = 0; m < matrix.length; m++) {
                    sums[m] += matrix[m][j];
                    sum = Math.max(sum + sums[m], sums[m]);  //当前的值和前面累加的和比e.g. 第一列是 5，-3,5。 到m=1的时候是 2（5+-3） 和 -3比较
                    max = Math.max(max, sum);
                }

                if (max <= k) {         //当max < k就进行下一轮，不用比较了
                    res = Math.max(res, max);
                    continue;
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                sum = 0;
                for (int s: sums) {
                    sum += s;
                    Integer prev = set.ceiling(sum - k);
                    if (prev != null) {
                        res = Math.max(res, sum - prev);
                    }
                    set.add(sum);
                }
            }
        }

        return res;
    }

    public static void main(String[] algs)
    {
        int[][] arr = {{5,-4,-3,4}, {-3,-4,4,5}, {5,1,5,-4}};
        int[] onearr = {1,-1,2,1,5,-1};
        int k = -2;
        Max_Sum_of_Rectangle_No_Larger_Than_K test = new Max_Sum_of_Rectangle_No_Larger_Than_K();
        System.out.println(test.maxSumSubmatrix1(arr,k));
        //System.out.println(test.maxSumOneDemision(onearr,k));
    }
}
