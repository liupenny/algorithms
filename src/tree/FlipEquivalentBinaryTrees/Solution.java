package tree.FlipEquivalentBinaryTrees;

import tools.TreeNode;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/2
 */
public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        } else if ((root1 == null) || (root2 == null)) {
            return false;
        } else if (root1.val != root2.val) {
            return false;
        }

        return ( flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left) );
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = TreeNode.stringToTreeNode("[1,2,3,4,5,6,null,null,null,7,8]");
        TreeNode root2 = TreeNode.stringToTreeNode("[1,3,2,null,6,4,5,null,null,null,null,8,7]");
        System.out.println(s.flipEquiv(root1,root2));
    }
}
