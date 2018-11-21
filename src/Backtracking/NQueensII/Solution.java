package Backtracking.NQueensII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/20
 */
public class Solution {
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private int ans;
    private List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    private HashSet<Integer> aa = new HashSet(a);


    public void test(){
        HashSet<Integer> aaa = new HashSet<>();
        aaa = (HashSet<Integer>) aa.clone();
    }

    public int totalNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia1 = new boolean[2*n-1];
        ans = 0;

        putQueen(n , 0);
        return ans;
    }

    private void putQueen(int n, int index) {
        if (index == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!col[i] && !dia1[index + i] && !dia2[index - i + n -1]) {
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
            }
        }

        return;
    }
}
