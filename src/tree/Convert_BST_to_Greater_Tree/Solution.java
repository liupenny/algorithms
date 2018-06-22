package tree.Convert_BST_to_Greater_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/22.
 */

public class Solution{
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return root;

        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

}