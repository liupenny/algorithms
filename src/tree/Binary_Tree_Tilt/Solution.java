package tree.Binary_Tree_Tilt;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/24.
 */

public class Solution{
    public int findTilt(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = findTilt(root.left);
        int right = findTilt(root.right);

        return left + right + Math.abs(sumSubtree(root.left) - sumSubtree(root.right));
    }

    public int sumSubtree(TreeNode root)
    {
        if(root == null) {
            return 0;
        }
        return root.val + sumSubtree(root.left) + sumSubtree(root.right);
    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        String line = "[1,3,6,2,7,1,0,2]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        int ans = s.findTilt(root);
        System.out.println(ans);
    }
}