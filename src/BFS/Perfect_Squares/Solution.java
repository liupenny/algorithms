package BFS.Perfect_Squares;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by PennyLiu on 2018/9/9.
 */

public class Solution{
    public int numSquaresDp(int n) {
        if(n <= 0) {
            return 0;
        }
        // 角标0-n记录0-n所有数对应的答案
        int[] help = new int[n+1];
        Arrays.fill(help, Integer.MAX_VALUE);
        help[0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                //1代表j*j，help[i-j*j]是剩下的数所代表的答案
                help[i] = Math.min(help[i], help[i - j*j] + 1);
            }
        }
        return help[n];
    }

    public int numSquaresBfs(int n) {
       if(n <= 0) {
           return 0;
       }
        // case 1
        if(isSquare(n)) {
            return 1;
        }
        // case 2
        int sqt = (int)Math.sqrt(n);
        for (int i = 1; i <= sqt ; i++) {
            if(isSquare(n - i*i)) {
                return 2;
            }
        }
        // case 4:
        while (n%4==0) {
            n = n / 4;
        }
        if(n%8==7) {
            return 4;
        }
        // case 3
        return 3;

    }

    boolean isSquare(int n){
        double sqt = Math.sqrt((double)n);
        int x = (int)sqt;
        return Math.pow(sqt,2) == Math.pow(x,2);
    }

    public int numSquares(int n) {

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if (num == 0) {
                return step;
            }
            //这里就是构建图的过程，所有Num-i*i的点到num的距离是1
            for (int i = 1; num - i * i >= 0; i++) {
                queue.addLast(new Pair(num - i * i, step + 1));
            }
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.numSquares(12));
    }
}