package tree.Sum_of_Distances_in_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by PennyLiu on 2018/7/2.
 */

public class Solution{
    List<HashSet<Integer>> tree;
    int[] ans, count; //ans是答案数组，count记录每个节点有几个子节点，包括自己
    int NN;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if(N == 0 || edges == null || edges.length == 0)
            return new int[0];

        tree = new ArrayList<>();
        ans = new int[N];
        count = new int[N];
        NN = N;
        // 因为计算子节点包括自己，所以都初始化为1
        Arrays.fill(count, 1);

        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] edge: edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int node, int parent) {
        for (int child: tree.get(node))
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
    }

    public void dfs2(int node, int parent) {
        for (int child: tree.get(node))
            if (child != parent) {
                ans[child] = ans[node] - count[child] + NN - count[child];
                dfs2(child, node);
            }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        int N = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int[] ans = s.sumOfDistancesInTree(N,edges);
        for (int a: ans) {
            System.out.print(a + " ");
        }
    }
}