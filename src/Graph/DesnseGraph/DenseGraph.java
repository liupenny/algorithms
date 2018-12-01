package Graph.DesnseGraph;

import java.util.Vector;
import Graph.utils.Graph;
/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/28
 */
public class DenseGraph implements Graph{
    // 节点数.每个顶点的编号为0-(n-1)
    private int n;
    // 边数
    private int m;
    // 是否为有向图
    private boolean directed;
    // 图的具体数据
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        // 初始化没有任何边
        this.m = 0;
        this.directed = directed;
        // g初始化为v*v的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = new boolean[n][n];
    }

    // 返回节点个数
    @Override
    public int V(){
        return n;
    }

    // 返回边的个数
    @Override
    public int E(){
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        // 平行边就不会再添加
        if (hasEdge(v,w)){
            return;
        }

        g[v][w] = true;
        // 不是无向图，反方向的边也要添加
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    // 显示图的信息
    @Override
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for(int i = 0 ; i < n ; i ++ ) {
            if( g[v][i] ) {
                adjV.add(i);
            }
        }
        return adjV;
    }
}
