package Dynamic_Programming.House_RobberIII;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/5/5.
 */
public class House_RobberIII {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;

        int[] res = getMoney(root);
        return Math.max(res[0], res[1]);
    }

    public int[] getMoney(TreeNode root)
    {
        int[] res = new int[2];
        if (root == null)
            return res;
        int[] lres = getMoney(root.left);
        int[] rres = getMoney(root.right);
        // 下标0表示要root节点，1表示不要
        res[0] = lres[1] + rres[1] + root.val;
        res[1] = Math.max(lres[0],lres[1]) + Math.max(rres[0], rres[1]);
        return res;
    }
        public static void main(String[] args) {
        House_RobberIII t = new House_RobberIII();
        TreeNode root = new TreeNode(3);
        TreeNode a2 = new TreeNode(2);
        TreeNode b1 = new TreeNode(3);
        TreeNode a1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(1);
        root.left = a2; root.right = b1;
        a2.right = a1; b1.right = b2;
    }
}
