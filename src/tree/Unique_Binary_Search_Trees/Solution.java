package tree.Unique_Binary_Search_Trees;/**
 * Created by PennyLiu on 2018/6/28.
 */

public class Solution{
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;

        // 从2开始更新G[i]
        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < i; j++) {
                G[i] += G[j] * G[i - 1 - j];
            }
        }
        return G[n];
    }


    public static void main(String[] args)
    {
    
    }
}