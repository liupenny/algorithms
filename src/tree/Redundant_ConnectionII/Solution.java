package tree.Redundant_ConnectionII;/**
 * Created by PennyLiu on 2018/6/26.
 */

public class Solution{
    int MAX_NODE_VAL = 1000;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if(edges == null || edges.length == 0)
            return new int[0];

        DSU dsu = new DSU(MAX_NODE_VAL);
        for (int[] arr: edges) {
            if(dsu.union(arr[0],arr[1]))
                return arr;
        }
        throw new AssertionError();
    }

    class DSU
    {
        int[] parent;
        //int[] rank;

        public DSU(int size)
        {
            parent = new int[size + 1];
            //rank = new int[size + 1];
            for (int i = 1; i < size + 1; i++) {
                parent[i] = i;
            }
        }

        public int find(int u)
        {
            if(u != parent[u])
                u = parent[u];
            return u;
        }

        public boolean union(int u, int v)
        {
            int up = find(u); //u是这条边的父亲节点
            // 找到v的父亲节点
            int vp = find(v);

            //
            if(vp == v)
            {
               parent[v] = u;
               return true;
            }
            else {

                return false;
            }
        }
    }
}