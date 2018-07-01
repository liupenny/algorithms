package tree.Validate_Binary_Search_Tree;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/6/30.
 */

public class Solution{
    List<Integer> ans;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        ans = new ArrayList<>();
        inOrder(root);
        for (int i = 1; i < ans.size(); i++) {
            if(ans.get(i) <= ans.get(i-1))
                return false;
        }
        return true;
    }

    public void inOrder(TreeNode treeNode)
    {
        if(treeNode == null)
            return;

        inOrder(treeNode.left);
        ans.add(treeNode.val);
        inOrder(treeNode.right);
    }

    public boolean isValidBST_minmax(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max){
        if(root == null)
            return true;

        if(root.val >= max || root.val <= min)
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static void main(String[] args)
    {
    
    }
}