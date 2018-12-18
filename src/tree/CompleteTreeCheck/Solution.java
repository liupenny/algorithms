package tree.CompleteTreeCheck;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        while (cur!=null) {
            queue.offer(cur.left);
            queue.offer(cur.right);
            cur = queue.poll();
        }
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }
}
