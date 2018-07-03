package tree.Binary_Search_Tree_Iterator;

import tools.TreeNode;

import java.util.Stack;

/**
 * Created by PennyLiu on 2018/7/3.
 */

public class Solution{
    public static void main(String[] args)
    {
    
    }
}

class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = stack.pop();
        pushAll(tmp.right);
        return tmp.val;
    }

    private void pushAll(TreeNode node)
    {
        while (node != null)
        {
            stack.push(node);
            node = node.left;
        }
    }
}