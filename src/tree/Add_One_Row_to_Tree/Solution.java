package tree.Add_One_Row_to_Tree;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/7/2.
 */

public class Solution{
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null || d < 1)
            return root;

        if (d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        while (!queue.isEmpty() && level < d - 1)
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            level++;
        }

        // 因为queue的size是一直在变的，所以循环判断条件不能写queue.size
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode temp = queue.poll();
            TreeNode left = new TreeNode(v);
            left.left = temp.left;
            temp.left = left;
            TreeNode right = new TreeNode(v);
            right.right = temp.right;
            temp.right = right;
        }
        root.printTree_format(root);
        return root;
    }

    // 用递归的写法，好像快一些,d=1的情况要单独考虑
    public TreeNode addOneRow_recur(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        insert(v, t, 1, d);
        return t;
    }

    // depth就是当前的深度
    public void insert(int val, TreeNode node, int depth, int d) {
        if (node == null)
            return;
        if (depth == d - 1) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            insert(val, node.left, depth + 1, d);
            insert(val, node.right, depth + 1, d);
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode treeNode = TreeNode.stringToTreeNode("[4,2,6,3,1,5]");
        s.addOneRow(treeNode, 1,3);
    }
}