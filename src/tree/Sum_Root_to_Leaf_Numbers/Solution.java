package tree.Sum_Root_to_Leaf_Numbers;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/28.
 */

public class Solution{
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;

        StringBuilder sb = new StringBuilder();
        addSum(root, sb);
        return sum;
    }

    public void addSum(TreeNode root, StringBuilder sb)
    {
        if(root == null)
            return;

        sb.append(root.val);
        if(root.left == null && root.right == null)
        {
            sum += Integer.parseInt(sb.toString());
            // 这里不应该写return，算完以后要退出 然后把最后一个加的字符删掉
        }
        else {
            addSum(root.left, sb);
            addSum(root.right, sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode p = TreeNode.stringToTreeNode("[4,9,0,5,1]");
        // TreeNode q = TreeNode.stringToTreeNode("[1,null,2]");
        System.out.println(s.sumNumbers(p));
    }
}