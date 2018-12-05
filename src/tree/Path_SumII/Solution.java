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
        if(root == null) {
            return ans;
        }

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
        if(node.left != null) {
            addSum(node.left, ans, temp, target);
        }
        if(node.right != null) {
            addSum(node.right, ans, temp, target);
        }

        temp.remove(temp.size()-1);
    }

    ArrayList<ArrayList<Integer>> ans;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        find(root, target, tmp);
        return ans;
    }

    public void find(TreeNode root, int target, ArrayList<Integer> tmp) {
        target -= root.val;
        tmp.add(root.val);

        if (root.left == null && root.right == null) {
            if (target == 0) {
                ans.add(new ArrayList<>(tmp));
            }
        }
        if (root.left != null) {
            find(root.left, target, tmp);
        }
        if (root.right != null) {
            find(root.right, target, tmp);
        }
        tmp.remove(tmp.size()-1);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String line = "[10,5,12,4,7]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        ArrayList<ArrayList<Integer>> ans = s.FindPath(root,22);
        System.out.println(ans);
    }
}