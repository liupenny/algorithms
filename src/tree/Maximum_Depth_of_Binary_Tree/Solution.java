package tree.Maximum_Depth_of_Binary_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/19.
 */

public class Solution 
{
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
