package tree.Sum_of_Left_Leaves;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/24.
 */
// 只加上整棵树的所有左叶子节点

public class Solution{
    // 用一个Boolean值去判断是左边还是右边
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root, false);
    }

    //进入函数后就知道当前节点是否是左子节点
    public int sumOfLeftLeavesHelper(TreeNode root, boolean b) {
        if (root == null) return 0;

        // 如果是左子节点，并且该节点没有子节点了，说明是左子叶
        if (root.left == null && root.right == null) {
            if (b) return root.val;
            else return 0;
        }
        //否则继续算
        return sumOfLeftLeavesHelper(root.left, true) + sumOfLeftLeavesHelper(root.right, false);
    }

    public int sumOfLeftLeaves_onefunc(TreeNode root) {
        if(root == null)
            return 0;
        // 当前节点的左孩子不是Null，但左孩子没有叶子节点了，就对当前节点的右孩子进行遍历计算即可
        if(root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves_onefunc(root.right);

        // 否则两边都计算
        return sumOfLeftLeaves_onefunc(root.left) + sumOfLeftLeaves_onefunc(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String line = "[3,9,20,8,6,15,7,3,2,5,7,1,0,5,8]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        int ans = s.sumOfLeftLeaves(root);
        System.out.println(ans);
    }
}