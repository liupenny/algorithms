package tree.KthInBST;

import tools.TreeNode;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/4
 */
public class Solution {
    int leftK = 0;
    public int kthSmallest(TreeNode root, int k) {
        leftK = k;
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (leftK <= 0) {
            return left;
        }
        if (--leftK == 0) {
            return root.val;
        }
        return dfs(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode p = TreeNode.stringToTreeNode("[3,1,4,null,2]");
        //System.out.println(s.kthSmallest(p,1));
        System.out.println(s.trans(1,1));
    }

    public String trans(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return start + "->" + end;
    }
}
