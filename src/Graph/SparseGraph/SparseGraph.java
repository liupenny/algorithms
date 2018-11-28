package Graph.SparseGraph;

import Graph.utils.Graph;

import java.util.Vector;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/28
 */
public class SparseGraph implements Graph {
    // 节点数
    private int n;
    // 边数
    private int m;
    // 是否为有向图
    private boolean directed;
    // 图的具体数据
    private Vector<Integer>[] g;

    // 构造函数
    public SparseGraph( int n , boolean directed ){
        assert n >= 0;
        this.n = n;
        // 初始化没有任何边
        this.m = 0;
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (Vector<Integer>[])new Vector[n];
        for(int i = 0 ; i < n ; i ++) {
            g[i] = new Vector<Integer>();
        }
    }

    @Override
    // 返回节点个数
    public int V(){ return n;}
    // 返回边的个数
    @Override
    public int E(){ return m;}

    // 向图中添加一个边
    @Override
    public void addEdge(int v, int w ){

        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        g[v].add(w);
        // 处理了自环边
        if( v != w && !directed ) {
            g[w].add(v);
        }

        m ++;
    }

    // 验证图中是否有从v到w的边
    @Override
    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        for( int i = 0 ; i < g[v].size() ; i ++ ) {
            if( g[v].elementAt(i) == w ) {
                return true;
            }
        }
        return false;
    }

    // 显示图的信息
    @Override
    public void show(){
        for (int i = 0; i < n; i++) {
            System.out.println("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.println(g[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
