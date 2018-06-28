package tree.Binary_Tree_Maximum_Path_Sum;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/28.
 */

public class Solution{
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;

        addSum(root);
        return ans;
    }

    public int addSum(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = Math.max(0, addSum(root.left));
        int right = Math.max(0, addSum(root.right));
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode p = TreeNode.stringToTreeNode("[4,9,0,5,1]");
        // TreeNode q = TreeNode.stringToTreeNode("[1,null,2]");
        System.out.println(s.maxPathSum(p));
    }
}