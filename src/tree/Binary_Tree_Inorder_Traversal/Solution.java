package tree.Binary_Tree_Inorder_Traversal;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/6/19.
 */

public class Solution{
    // 递归写的
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> ans)
    {
        if(root == null) {
            return;
        }

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        inorder(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        String a = " [1,null,2,3]";
        TreeNode root = TreeNode.stringToTreeNode(a);
        Solution s = new Solution();
        List<Integer> ans = s.inorderTraversal_iterative(root);
        System.out.println(ans);
    }
}