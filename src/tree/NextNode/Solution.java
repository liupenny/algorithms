package tree.NextNode;


/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/21
 */
class TreeNode {
    Integer value;
    TreeNode left, right, father;
}
public class Solution {
    public TreeNode getNext(TreeNode root) {
        if (root.right != null) {
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        } else if (root.father != null) {
            TreeNode current = root;
            TreeNode father = root.father;
            while (father != null && current == father.right) {
                current = father;
                father = father.father;
            }
            return father;
        }
        return null;
    }
}
