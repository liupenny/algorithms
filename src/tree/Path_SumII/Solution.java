package tree.Path_SumII;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/6/27.
 */

public class Solution{
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        List<Integer> temp = new ArrayList<>();
        addSum(root, ans, temp, sum);
        return ans;
    }

    public void addSum(TreeNode node, List<List<Integer>> ans, List<Integer> temp, int target)
    {
        temp.add(node.val);
        target -= node.val;
        if(node.left == null && node.right == null && target == 0)
        {
            ans.add(new ArrayList<>(temp));
        }
        if(node.left != null)
            addSum(node.left, ans, temp, target);
        if(node.right != null)
            addSum(node.right, ans, temp, target);

        temp.remove(temp.size()-1);
    }

    public static void main(String[] args)
    {
    
    }
}