package tree.Longest_Univalue_Path;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/29.
 */

public class Solution{
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;

        count(root, root.val);
        return ans;
    }

    // 统计node子树上跟val值一样的节点路径的最大值
    public int count(TreeNode root, int val)
    {
        if(root == null)
            return 0;

        int left = count(root.left, root.val);
        int right = count(root.right, root.val);
        // 严格按照定义来，此时left,right就是跟当前节点值一样的最长路径值，那对于本节点的最长路径就是left+right
        ans = Math.max(ans, left + right);
        // 返回给上一层的应该是：当前节点跟要求的一样的话就返回左右两边最大值+1
        if(root.val == val)
            return Math.max(left, right) + 1;
        // 不一样就返回0
        return 0;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode p = TreeNode.stringToTreeNode("[5,4,5,1,1,null,5]");
        // TreeNode q = TreeNode.stringToTreeNode("[1,null,2]");
        System.out.println(s.longestUnivaluePath(p));
    }
}