package Binary_Search.Kth_Smallest_Element_in_a_Sorted_Matrix;

import java.util.PriorityQueue;

/**
 * Created by PennyLiu on 2017/10/21.
 * 378. Kth Smallest Element in a Sorted Matrix
 * 堆排序（O（nlogn）-- kthSmallest1）
 */
public class Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int kthSmallest1(int[][] matrix, int k) {
        int num = matrix.length;
        PriorityQueue<Tuple> ans = new PriorityQueue<Tuple>();
        for (int i=0; i<num; i++) {
            ans.add(new Tuple(0, i, matrix[0][i]));
        }
        for (int i=0; i<k-1; i++)
        {
            Tuple t = ans.poll();
            if(t.x == num-1) {
                continue;
            }
            ans.add(new Tuple(t.x+1,t.y,matrix[t.x+1][t.y])); //在这一步添加全局最小
        }
        return ans.poll().val;
    }

    class Tuple implements Comparable<Tuple>
    {
        int x,y,val;
        public Tuple(int x, int y, int val)
        {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Tuple that)
        {
            return this.val - that.val;
        }
    }

    public static void main(String[] algs)
    {
        int[][] matrix = {{1, 5,  9},
                    {10, 11, 13},
                    {12, 13, 15}};
//        int sum = matrix.length * matrix.length;
//        System.out.println(sum);
        Kth_Smallest_Element_in_a_Sorted_Matrix t = new Kth_Smallest_Element_in_a_Sorted_Matrix();
        int ans = t.kthSmallest1(matrix,8);
        System.out.println(ans);
    }
}
