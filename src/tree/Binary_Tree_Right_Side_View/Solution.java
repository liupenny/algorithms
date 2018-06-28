package tree.Binary_Tree_Right_Side_View;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/6/27.
 */

public class Solution{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;

        while (!queue.isEmpty())
        {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                if(i == size - 1)
                    ans.add(node.val);
            }

        }
        return ans;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String line = "[1,2,3,null,5,null,4]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        List<Integer> ans = s.rightSideView(root);
        System.out.println(ans);
    }
}