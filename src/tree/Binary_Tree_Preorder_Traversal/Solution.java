package tree.Binary_Tree_Preorder_Traversal;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by PennyLiu on 2018/6/27.
 */

public class Solution{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty())
        {
            TreeNode tmp = stack.pop();
            ans.add(tmp.val);
            if(tmp.right != null) {
                stack.push(tmp.right);
            }
            if(tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
    
    }
}