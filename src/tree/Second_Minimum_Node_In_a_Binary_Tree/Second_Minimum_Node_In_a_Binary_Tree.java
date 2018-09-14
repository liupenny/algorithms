package tree.Second_Minimum_Node_In_a_Binary_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2017/10/22.
 */
public class Second_Minimum_Node_In_a_Binary_Tree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null || root.left==null) {
            return -1;
        }

        int left = root.left.val, right = root.right.val;

        if(left == root.val) {
            left = findSecondMinimumValue(root.left);     //此函数的意义就是找到与根节点不同的数，没有就返回-1，所以下面直接判断即可
        }
        if(right == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] algs)
    {
        Second_Minimum_Node_In_a_Binary_Tree t = new Second_Minimum_Node_In_a_Binary_Tree();
        TreeNode root = new TreeNode(2);
        TreeNode a1 = new TreeNode(2);
//        TreeNode a2 = new TreeNode(3);
//        TreeNode a3 = new TreeNode(6);
        TreeNode b1 = new TreeNode(2);
//        TreeNode b2 = new TreeNode(3);
//        TreeNode b3 = new TreeNode(7);
        root.left = a1; root.right = b1;
        //a1.left = a2; a1.right = a3;
        //b1.left = b2; b1.right = b3;
        int ans = t.findSecondMinimumValue(root);
        System.out.println(ans);
    }
}
