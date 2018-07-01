package tree.Delete_Node_in_a_BST;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/30.
 */

public class Solution{
    // 递归
    // 首先查找到val=key节点的所在位置，在查找的过程中，利用递归重建BST。
    // 查找到之后，需要将当前节点重新赋值，然后重新构建右子树，方式是将右子树的最左叶结点的值付给当前节点，然后删除该最左叶结点。
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null )
            return null;

        if(root.val > key)
            root.left = deleteNode(root.left, key);
        if(root.val < key)
            root.right = deleteNode(root.right, key);
        else
        {
            // 先判断当前节点是不是只有一个孩子节点
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else
            {
                TreeNode node = search(root.right);
                root.val = node.val;
                // 在右子树递归删除最小节点
                root.right = deleteNode(root.right, node.val);
            }
        }
        return root;
    }

    public TreeNode search(TreeNode root)
    {
        while (root.left != null)
            root = root.left;
        return root;
    }


    public TreeNode deleteNode_iter(TreeNode root, int key) {
        if(root == null || root.val == key)
            return deleteRoot(root);

        TreeNode node = root;
        while (true)
        {
            if(key > node.val)
            {
                if(node.right == null || node.right.val == key) {
                    node.right = deleteRoot(node.right);
                    break;
                }
                break;
            }
            else {
                if (node.left == null || node.left.val == key)
                {
                    node.left =  deleteRoot(node.left);
                    break;
                }
                node = node.left;
            }
        }
        return root;
    }

    public TreeNode deleteRoot(TreeNode node)
    {
        if(node == null)
            return null;
        if(node.right == null)
            return node.left;
        if(node.left == null)
            return node.right;

        TreeNode x = node.right;
        while (x.left != null)
            x = x.left;

        // 直接找到左边子树最小值x，把父亲节点的左子树放在x左边即可。
        x.left = node.left;
        return node.right;
    }

    public TreeNode deleteNode_root(TreeNode root, int key) {
        if(root == null)
            return root;

        TreeNode father = null;
        TreeNode cur = root;

        // 这里保留father，循环到最后一步的时候，是cur.val = key，但father还是cur的father
        while (cur != null && cur.val != key)
        {
            father = cur;
            if(key > cur.val)
                cur = cur.right;
            else if(key < cur.val)
                cur = cur.left;
        }

        // 删除root
        if(father == null)
            return deleteRootNode(cur);
        if(father.left == cur)
            father.left = deleteRootNode(cur);
        if(father.right == cur)
            father.right = deleteRootNode(cur);
        return root;
    }

    public TreeNode deleteRootNode(TreeNode node)
    {
        // 有可能给的key不在BST中
        if(node == null)
            return null;
        if(node.right == null)
            return node.left;
        if(node.left == null)
            return node.right;

        TreeNode x = node.right;
        while (x.left != null)
            x = x.left;

        // 直接找到左边子树最小值x，把父亲节点的左子树放在x左边即可。
        x.left = node.left;
        return node.right;
    }
        public static void main(String[] args)
    {
    
    }
}