package tree.Path_Sum;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/27.
 */

public class Solution{
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        return addSum(root, sum, 0);
    }

    public boolean addSum(TreeNode node, int target, int sum)
    {
        // 如果当前节点是null，证明到了一个只有一个孩子的父节点的另一边，返回false即可
        if(node == null)
            return false;
        // 考虑累加和的时候必须是在当前节点的左右孩子都为Null的时候，这才是叶子节点。
        // 当[1,2],sum = 1的时候，是不符合情况的。
        if(node.left == null && node.right == null)
            return ( sum + node.val) == target;

        sum += node.val;
        boolean left = addSum(node.left, target, sum);
        boolean right = addSum(node.right, target, sum);
        return left || right;
    }

    public boolean hasPathSum_3line(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum_3line(root.left, sum - root.val) || hasPathSum_3line(root.right, sum - root.val);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String line = "[1,2]";
        // String line = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        boolean ans = s.hasPathSum(root,1);
        System.out.println(ans);
    }
}