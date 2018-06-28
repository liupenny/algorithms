package tree.Redundant_ConnectionII;

/**
 * Created by PennyLiu on 2018/6/26.
 */

public class Solution{
    public int[] findRedundantDirectedConnection1(int[][] edges) {

        int n = edges.length;
        int[] root = new int[n + 1];
        int[] first = {-1,-1};
        int[] second = {-1,-1};

        for (int i = 0; i < edges.length; i++) {
            if (root[edges[i][1]] == 0)
                root[edges[i][1]] = edges[i][0];

            else {
                first = new int[]{root[edges[i][1]], edges[i][1]};
                second = new int[]{edges[i][0], edges[i][1]};
                edges[i][1] = 0;
            }
        }

        // 进行Union过程
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }

        for (int[] arr : edges) {
            if(arr[1] == 0)
                continue;

            int x = getParent(root, arr[0]), y = getParent(root, arr[1]);
            if (x == arr[1]) {
                //有环，first不存在就是第二种情况
                if (first[0] == -1)
                    return arr;
                // 存在，是第一种情况,因为一开始遍历了有两个父亲的节点，按照顺序存储了两条父亲边，
                    // 此时的遍历到了这一步找到了环，且有first，
                    // 因为形成环，证明该节点的一个父亲是在环里的，那么
                else
                    return first;
            }
            // 为找回路做准备，找回路就是两个点能通向同一个点，所以root[x]存的x通向的终点。如果存父亲，可能存的那条边不跟回路重合
            root[arr[1]] = arr[0];
        }


        // 没有环，第一种情况
        return second;

    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0)
            return new int[0];

        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                // 记录下来有两个parent的那个点的两条边，有先后顺序
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                // 第二条边设为Null
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            if (getParent(parent, father) == child) {
                // 情况三：因为上面第二条边设为null了，所以这里如果成环且有first，那肯定是第一条边在环里
                if (can1[0] == -1) {
                    return edges[i];
                }
                // 情况二：成环，都只有一个父亲
                return can1;
            }
            parent[child] = father;
        }
        // 情况三：这里因为设置第二条边为null，所以不成环的话就返回第二天边
        return can2;
    }

//    public int getParent(int[] parent, int i) {
//        while (i != parent[i]) {
//            parent[i] = parent[parent[i]];
//            i = parent[i];
//        }
//        return i;
//    }

    public int getParent (int[] root, int x)
    {
        while (x != root[x])
            x = root[x];
        return x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        // int[][] edges = {{1,2},{2,3},{3,1},{4,3}};
        int[][] edges = {{1,2},{4,3},{3,1},{2,3}};
        // int[][] edges = {{2,1},{3,1},{4,2},{1,4}};
        // int[][] edges = {{1,2},{1,3},{2,3}};
        //int[][] edges = {{1,2},{2,3},{3,4},{4,1},{1,5}};
        int[] ans = s.findRedundantDirectedConnection(edges);
        for (int x:ans) {
            System.out.print(x + " ");
        }
    }

}
