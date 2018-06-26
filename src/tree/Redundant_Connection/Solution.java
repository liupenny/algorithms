package tree.Redundant_Connection;/**
 * Created by PennyLiu on 2018/6/26.
 */

public class Solution{
    int MAX_NODE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_NODE_VAL);
        for (int[] edge : edges) {
            if(dsu.union(edge[0],edge[1]))
                return edge;
        }
        throw new AssertionError();
    }
}

class DSU
{
    int[] parent;
    int[] rank;

    public DSU(int size)
    {
        parent = new int[size + 1];
        rank = new int[size + 1];
        for (int i = 1; i < size + 1; i++) {
            parent[i] = i;
        }
    }

    public int find(int x)
    {
        while ( x != parent[x] )
            x = parent[x];
        return x;
    }

    public boolean union(int u, int v)
    {
        int up = find(u), vp = find(v);
        if(up == vp)
            return true;

        //根据根节点所在树的层级来判断合并方向
        //层级矮的树往层级高的树合并不需要维护rank,因为层级矮的高度没变，层级高的高度因为加了层级矮的所以也不变
        if(rank[up] < rank[vp])
            parent[up] = vp;
        else if(rank[up] > rank[vp])
            parent[vp] = up;
        //只有rank相等的情况才需要维护rank
        else {
            parent[up] = vp;
            rank[vp] += 1;
        }
        return false;
    }

}