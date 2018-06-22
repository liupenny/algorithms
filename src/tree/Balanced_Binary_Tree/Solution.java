package tree.Balanced_Binary_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/22.
 */

public class Solution{
    // 自上往下，有很多地方会重复计算
    public boolean isBalanced(TreeNode root)
    {
        if(root == null)
            return true;

        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root)
    {
        if(root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }

    //自下往上
    public boolean isBalanced_bottomToUp(TreeNode root)
    {
        if (root == null)
            return true;

        return dfsDpeth(root) != -1;
    }

    public int dfsDpeth(TreeNode root)
    {
        if(root == null)
            return 0;

        int leftDepth = dfsDpeth(root.left);
        if(leftDepth == -1)
            return -1;
        int rightDepth = dfsDpeth(root.right);
        if(rightDepth == -1)
            return -1;

        if(Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth,rightDepth) + 1;
    }
}