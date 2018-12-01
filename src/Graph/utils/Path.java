package Graph.utils;

import java.util.Stack;
import java.util.Vector;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/28
 */
public class Path {
    // 图的引用
    private Graph G;
    // 起始点
    private int s;
    // 记录dfs的过程中节点是否被访问
    private boolean[] visited;
    // 记录路径, from[i]表示查找的路径上i的上一个节点
    private int[] from;

    // 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
    public Path(Graph graph, int s) {

        //初始化
        G = graph;
        assert s >= 0 && s < G.V();
        this.s = s;

        visited = new boolean[G.V()];
        from = new int[G.V()];

        for (int i = 0; i < G.V(); i++) {
            from[i] = -1;
        }

        dfs(s);
    }

    // 图的深度优先
    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    // 查询从s到w是否有路径.因为现在求的是从s出发能否到w.所以如果从s开始dfs访问过w就能到
    boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 查询从s点到w点的路径, 存放在vec中
    Vector<Integer> path(int w) {
        assert hasPath(w);

        Stack<Integer> s = new Stack<>();
        int p = w;
        while (p != -1){
            s.push(p);
            p = from[p];
        }

        Vector<Integer> res = new Vector<>();
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }

    // 打印出从s点到w点的路径
    void showPath(int w){

        assert hasPath(w) ;

        Vector<Integer> vec = path(w);
        for( int i = 0 ; i < vec.size() ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 ) {
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
        }
    }
}
