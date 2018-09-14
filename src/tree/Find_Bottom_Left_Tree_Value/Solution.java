package tree.Find_Bottom_Left_Tree_Value;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/6/19.
 */

public class Solution{
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0, size = 0;
        queue.add(root);

        while (!queue.isEmpty())
        {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if(i == 0) {
                    ans = temp.val;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String line = "[1,2,3,4,null,5,6,null,null,7]";
        // if((line = in.readLine()) != null) {
        TreeNode root = TreeNode.stringToTreeNode(line);
        int ans = s.findBottomLeftValue(root);
        System.out.println(ans);
        //}
    }
}