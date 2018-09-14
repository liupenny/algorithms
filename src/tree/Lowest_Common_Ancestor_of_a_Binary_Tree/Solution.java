package tree.Lowest_Common_Ancestor_of_a_Binary_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/28.
 */

public class Solution{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 走到底或者找到了其中一个就返回当前的节点
        if(root == null || root == p || root == q) {
            return root;
        }
        // 没到底，也没找到p,q就继续在左边和右边找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左边没有找到的话返回右边，左边找到了在看右边找到没，右边没找到就返回左边，右边也找到了就返回root
        return left == null ? right : right == null ?  left : root;
    }

//    // 通过记录通向p和q的路径来比较
//    public TreeNode lowestCommonAncestor_path(TreeNode root, TreeNode p, TreeNode q) {
//        // 记录所有节点的父节点,键是孩子，值是父亲
//        Map<TreeNode, TreeNode> parent = new HashMap<>();
//        Stack<TreeNode> stack = new Stack<>();
//        parent.put(root, null);
//
//        // 一直添加路径，直到parent包含了p和q的父亲
//        while (!parent.containsKey(p) || !parent.containsKey(q))
//        {
//            TreeNode node = stack.pop();
//            if(node.left != null)
//            {
//                parent.put(node.left, node);
//                stack.push(node.left);
//            }
//            if(node.right != null)
//            {
//                parent.put(node.right, node);
//                stack.push(node.right);
//            }
//        }
//
//        Set<TreeNode> ancestors = new HashSet<>();
//        while (p != null)
//        {
//
//        }
//    }

        public static void main(String[] args)
    {
    
    }
}