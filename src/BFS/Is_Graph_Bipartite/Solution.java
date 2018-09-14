package BFS.Is_Graph_Bipartite;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/9/9.
 */

public class Solution{
    // DFS
    // 1.如果节点还没有被染色，就染红色。然后用另一个颜色去染跟他相邻的节点
    // 2.如果节点染了色，就看他的颜色和要给他染的颜色是不是一样的。如果一样，就继续扩展后面节点。不一样就返回false。
    public boolean isBipartite(int[][] graph) {
        // 0:没染色
        // 1:染红色
        // -1:染黑色
        int[] color = new int[graph.length];
        color[0] = 1;

        for (int i = 0; i < graph.length; i++){
            if(color[i] != 0 && putColor(graph,color,i,1)) {
                return false;
            }
        }

        return true;
    }

    public boolean putColor(int[][] graph, int[] color, int node, int nodecolor){
        if(color[node] != 0) {
            return color[node] == nodecolor;
        }

        color[node] = nodecolor;
        for (int a : graph[node]) {
            if(!putColor(graph, color, a, -nodecolor)) {
                return false;
            }
        }
        return true;
    }

    // BFS
    public boolean isBipartite1(int[][] graph) {
        int[] colors = new int[graph.length];
        // 因为图可能分为多个子图，所以每个节点都看一下
        for (int i = 0; i < graph.length; i++) {
            if(colors[i] == 0){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 1;
                while (!queue.isEmpty()){
                    int node = queue.poll();
                    //当前节点的所有临界点
                    for (int adjacent : graph[node]) {
                        if(colors[adjacent] == colors[node]) {
                            return false;
                        } else if(colors[adjacent] == 0){
                            queue.add(adjacent);
                            colors[adjacent] = -colors[node];
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] a =  {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        System.out.println(s.isBipartite(a));
    }
}