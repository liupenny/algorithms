package tree.All_Nodes_Distance_K_in_Binary_Tree;

import tools.TreeNode;

import java.util.*;

/**
 * Created by PennyLiu on 2018/7/3.
 */

public class Solution{
    Map<TreeNode, HashSet<TreeNode>> graph;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        graph = new HashMap<>();
        buildGraph(null, root);

        // ans是答案数组
        List<Integer> ans = new ArrayList<>();
        // visited记录已经访问过的元素
        Set<TreeNode> visited = new HashSet<>();
        // 用来做图的dfs
        Queue<TreeNode> queue = new LinkedList<>();
        // 从target自己出发，自己是已经访问过的，此时target自己k=0.
        queue.add(target);
        // 自己是已经访问过的，所以先加进去，避免后面从孩子节点又回到自己
        visited.add(target);

        int k = 0;
        while (!queue.isEmpty() && k <= K)
        {
            int size = queue.size();
            while (size-- > 0)
            {
                TreeNode temp = queue.poll();
                if(k == K) {
                    ans.add(temp.val);
                }
                // 把当前节点相连的未访问的所有节点加进去
                Iterator<TreeNode> iterator = graph.get(temp).iterator();
                while ( iterator.hasNext() ) {
                    TreeNode child = iterator.next();
                    if (visited.contains(child)) {
                        continue;
                    }
                    queue.add(child);
                    visited.add(child);
                }
            }
            ++k;
        }
        return ans;
    }

    public void buildGraph(TreeNode parent, TreeNode child)
    {
        if(child != null)
        {
            graph.computeIfAbsent(child, x->new HashSet<TreeNode>());
            graph.computeIfAbsent(parent, x->new HashSet<TreeNode>());
            if(parent != null) {
                graph.get(child).add(parent);
                graph.get(parent).add(child);
            }
        }
        if(child.left != null) {
            buildGraph(child, child.left);
        }
        if(child.right != null) {
            buildGraph(child, child.right);
        }
    }

    List<Integer> ans;
    public List<Integer> distanceK_tree(TreeNode root, TreeNode target, int K) {
        ans = new ArrayList<>();
        dis(root, target, K);
        return ans;
    }

    // 返回从root到target的距离
    // 如果target不在子树里，返回-1
    public int dis(TreeNode root, TreeNode target, int K)
    {
        if(root == null) {
            return -1;
        }
        if(root == target)
        {
            // 如果当前节点就是target，在本节点搜集距离为k的节点
            collect(target, K);
            return 0;
        }


        int l = dis(root.left, target, K);
        int r = dis(root.right, target, K);

        // target在左子树，去搜集右子树上距离target k - l的点
        if(l >= 0)
        {
            // target到root.left的距离是k-1 == target到root的距离是K
            if(l == K - 1) {
                ans.add(root.val);
            }
            // target到root.left的距离是l,root.left到root.right距离是2
            // 还需要找到root.right距离是 k - l -2的
            collect(root.right, K - l - 2);
            return l + 1;
        }

        if(r >= 0)
        {
            if(r == K - 1) {
                ans.add(root.val);
            }
            collect(root.right, K -r -2);
            return r + 1;
        }

        return -1;
    }

    // 递归在子树中寻找
    public void collect(TreeNode root, int k)
    {
        if(root == null || k < 0) {
            return;
        }
        if(k == 0) {
            ans.add(root.val);
        }
        collect(root.left, k - 1);
        collect(root.right, k - 1);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode target = root.left;
        int k = 2;
        List<Integer> ans = s.distanceK(root, target, k);
        for (Integer a: ans) {
            System.out.print(a + " ");
        }

//        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
//        graph.computeIfAbsent(4,x->new HashSet<Integer>(5));
    }
}