package tree.Same_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/24.
 */

public class Solution{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        if(left == true && right == true && p.val == q.val)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode p = TreeNode.stringToTreeNode("[1,2]");
        TreeNode q = TreeNode.stringToTreeNode("[1,null,2]");
        System.out.println(s.isSameTree(p,q));

    }
}