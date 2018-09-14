package BFS.Shortest_Path_Visiting_All_Nodes;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by PennyLiu on 2018/9/9.
 */

public class Solution{
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        // ans是走完所有节点时的bit表示的整数，即n个1，就是2^n-1
        int ans = (1 << n) - 1;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int[][] visited = new int[n][ans];

        // 第一层就是每个节点都作为头结点被访问了
        for (int i = 0; i < graph.length; i++) {
          queue.offer(new Pair<>(i,1<<i));
        }
        int steps = 0;

        while (!queue.isEmpty()){
            int s = queue.size();
            while (s-- > 0){
                Pair p = queue.poll();
                int node = (int)p.getKey();
                int state = (int)p.getValue();
                if(state == ans) {
                    return steps;
                }
                if(visited[node][state] == 1) {
                    continue;
                }
                visited[node][state] = 1;
                for (int next:graph[node]){
                    // state | (1<<next) 是当前状态和已经访问过的节点或一下。这样当前状态就包含了这一步访问的节点
                    queue.offer(new Pair<>(next, state | (1<<next)));
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] a =  {{1,2,3},{0},{0},{0}};
        System.out.println(s.shortestPathLength(a));
    }
}