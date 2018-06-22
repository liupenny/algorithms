package tree.Minimum_Depth_of_Binary_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/22.
 */

public class Solution{
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        String line = "[1,2]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        Solution s = new Solution();
        int res = s.minDepth(root);
        System.out.println(res);
    }
}