package tree.Print_Binary_Tree;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2018/6/25.
 */

public class Solution{
    public List<List<String>> printTree(TreeNode root) {
        if(root == null)
            return new ArrayList<List<String>>();

        // 获取树的深度和宽度
        int depth = getDepth(root);
        int width = (int) Math.pow(2, depth) - 1;
        String[][] ans = new String[depth][width];
        for(String[] arr : ans)
            Arrays.fill(arr, "");

        fill(root, ans, 0,0, width - 1);
        List<List<String>> ret = new ArrayList<>();
        for (String[] arr:ans) {
            ret.add(Arrays.asList(arr));
        }

        return ret;
    }

    public void fill(TreeNode root, String[][] ans, int level, int begin, int end)
    {
        if(begin > end || root == null)
            return;

        ans[level][(begin + end)/2] = "" + root.val;
        fill(root.left, ans, level + 1, begin, (begin +end)/2 - 1);
        fill(root.right, ans, level + 1, (begin + end)/2 + 1, end);
    }

    public int getDepth(TreeNode root)
    {
        if(root == null)
            return 0;

        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String line = "[1,2]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        // List<List<Integer>> ans = s.zigzagLevelOrder(root);
        // System.out.println(s.getDepth(root));
        System.out.println(s.printTree(root));
    }
}