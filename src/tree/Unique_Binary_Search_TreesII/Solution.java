package tree.Unique_Binary_Search_TreesII;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/6/28.
 */

public class Solution{
    public List<TreeNode> generateTrees(int n) {
        // List<TreeNode> ans = new ArrayList<>();

        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }
        // 如果n=0,就返回[]，如果res[0].add写在返回前，就会返回[[]]
        result[0].add(null);
        result[1] = new ArrayList<>();
        result[1].add(new TreeNode(1));

        for (int i = 2; i <= n ; i++) {
            result[i] = new ArrayList<>();

            for (int j = 1; j <= i; j++) {
                for(TreeNode nodeL: result[j-1]){
                    for(TreeNode nodeR: result[i-j]){
                        TreeNode node = new TreeNode(j);
                        node.left = nodeL;
                        node.right = clone(nodeR, j);
                        result[i].add(node);
                    }
                }

            }
        }

        return result[n];
    }

    static TreeNode clone(TreeNode node, int offset){
        if(node == null) return null;
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = clone(node.left, offset);
        newNode.right = clone(node.right, offset);
        return newNode;
    }

    public List<TreeNode> generateTrees_recursive(int n) {
        return genTree(1,n);
    }

    public List<TreeNode> genTree(int start, int end)
    {
        List<TreeNode> list = new ArrayList<>();

        if(start > end)
        {
            list.add(null);
            return list;
        }

        if(start == end)
        {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end ; i++) {
            left = genTree(start,i - 1); //构建左边
            right = genTree(i + 1, end); //构建右边

            for (TreeNode nodel:left) {
                for (TreeNode noder:right) {
                    TreeNode root = new TreeNode(i);
                    root.left = nodel;
                    root.right = noder;
                    list.add(root);
                }
            }
        }

        return list;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        List<TreeNode> ans = s.generateTrees(3);
        for (int i = 0; i < ans.size(); i++) {
            String a = TreeNode.treeNodeToString(ans.get(i));
            System.out.println(a);
        }
    }
}