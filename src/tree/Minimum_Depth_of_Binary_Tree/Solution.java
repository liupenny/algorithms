package tree.Minimum_Depth_of_Binary_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/22.
 */

public class Solution{
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 || right == 0)
            return left + right + 1; //反正有一个是0，所以加起来也无所谓
        else
            return Math.min(left,right) + 1;
    }

    public static void main(String[] args) {
        String line = "[1,2]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        Solution s = new Solution();
        int res = s.minDepth(root);
        System.out.println(res);
    }
}