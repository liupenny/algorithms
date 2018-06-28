package tree.Path_SumIII;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/27.
 */

public class Solution{

//    public int pathSum(TreeNode root, int sum) {
//        if(root == null)
//            return 0;
//
//        //Integer paths = 0;
//        return paths(root, sum) + paths(root.left, sum) + paths(root.right, sum);
//    }
//
//    public int paths(TreeNode node, int sum)
//    {
//        if(node == null)
//            return 0;
//
//        return (node.val == sum ? 1 : 0) + paths(node.left, sum - node.val) + paths(node.right, sum - node.val);
//    }

    int path = 0;
    public int pathSum1(TreeNode root, int sum) {
        if(root == null)
            return 0;

        //Integer paths = 0;
        paths1(root, sum, 0);
        pathSum1(root.left, sum);
        pathSum1(root.right, sum);
        return path;
    }

    public void paths1(TreeNode node, int sum, int tmpSum)
    {
        if(node == null)
            return;

        tmpSum += node.val;
        if(tmpSum == sum)
        {
            path += 1;
        }

        paths1(node.left, sum, tmpSum);
        paths1(node.right, sum, tmpSum);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String line = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        //String line = "[1,null,2,null,3,null,4,null,5]";

        // String line = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        int ans = s.pathSum1(root,22);
        System.out.println(ans);
    }
}