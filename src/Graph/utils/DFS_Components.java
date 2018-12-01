package Graph.utils;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/28
 */
public class DFS_Components {
    // 图的引用
    private Graph G;
    // 记录dfs的过程中节点是否被访问
    private boolean[] visited;
    // 记录联通分量个数:compontent count
    private int ccount;
    // 用来判断两个节点是否相连（类似并查集），每个节点所对应的联通分量标记
    private int[] id;

    public DFS_Components(Graph graph) {
        G = graph;
        visited = new boolean[G.V()];
        ccount = 0;

        // 使用设计的迭代器，使得该方法能适用于两种图
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    private void dfs (int v) {
        visited[v] = true;
        id[v] = ccount;

        for (int i : G.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    // 返回图的连通分量个数
    public int count(){
        return ccount;
    }

    // 查询点v和点w是否联通
    boolean isConnected( int v , int w ){
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }
}
