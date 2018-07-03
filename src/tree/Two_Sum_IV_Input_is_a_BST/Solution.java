package tree.Two_Sum_IV_Input_is_a_BST;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by PennyLiu on 2018/7/3.
 */

public class Solution{
    // 暴力法，并没有用到BST有序的性质
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;

        Set<Integer> set = new HashSet<>();
        return find(root, k , set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set)
    {
        if(root == null)
            return false;

        if(set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    // 用到BST有序的性质，将所有数存在list里面，然后二分查找
    public boolean findTarget_bst(TreeNode root, int k) {
        List< Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode treeNode = TreeNode.stringToTreeNode("[5,3,6,2,4,null,7]");
        s.findTarget(treeNode, 9);
    }
}