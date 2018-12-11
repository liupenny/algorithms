package tree.ConvertBSTtoLinkedList;

import tools.TreeNode;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/11
 */
public class Solution {
    private TreeNode head = null, last = null;
    public TreeNode convert(TreeNode root) {
        visit(root);
        return head;
    }

    private void visit(TreeNode root) {
        if (root == null) {
            return;
        }
        visit(root.left);
        createList(root);
        visit(root.right);
    }

    private void createList(TreeNode node) {
        //当前结点左结点连接上一个
        node.left = last;
        //为空说明当前结点是第一个结点
        if(last==null) {
            head=node;
        } else {
            //不为空要将当前结点赋给上个结点的右结点
            last.right=node;
        }
        //更新last
        last=node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String line = "[10,6,14,4,8,12,16]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        TreeNode tmp = s.convert(root);
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.right;
        }
    }
}
