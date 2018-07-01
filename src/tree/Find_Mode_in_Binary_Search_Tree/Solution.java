package tree.Find_Mode_in_Binary_Search_Tree;

import tools.TreeNode;

import java.util.*;

/**
 * Created by PennyLiu on 2018/6/30.
 */

public class Solution{
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];

        Set<Integer> ans = new HashSet<>();
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE, ans);
        int[] ret = new int[ans.size()];
        Iterator iterator = ans.iterator();
        int index = 0;
        while (iterator.hasNext())
            ret[index++] = (int)iterator.next();
        return ret;
    }

    public void helper(TreeNode root, int min, int max, Set<Integer> ans)
    {
        if(root == null)
            return;

        if(root.val == min || root.val == max)
            ans.add(root.val);

        helper(root.left, min, root.val, ans);
        helper(root.right, root.val, max, ans);
    }

    public static void main(String[] args)
    {
    
    }
}