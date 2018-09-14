package tree.Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/28.
 */

public class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        int small = p.val < q.val ? p.val : q.val;
        int big = p.val < q.val ? q.val : p.val;

        TreeNode ans = root;
        while (ans != null)
        {
            if(ans.val >= small && ans.val <= big) {
                return ans;
            } else if(ans.val < small) {
                ans = ans.right;
            } else {
                ans = ans.left;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode ans = s.lowestCommonAncestor(root,p,q);
        System.out.println(ans.val);
    }
}