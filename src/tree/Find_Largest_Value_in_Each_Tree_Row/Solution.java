package tree.Find_Largest_Value_in_Each_Tree_Row;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode nowEnd = root, nextEnd = null, temp = root;

        int max = Integer.MIN_VALUE;
        queue.add(root);

        while (!queue.isEmpty())
        {
            temp = queue.poll();
            if(temp.left != null)
            {
                queue.add(temp.left);
                nextEnd = temp.left;
            }
            if(temp.right != null)
            {
                queue.add(temp.right);
                nextEnd = temp.right;
            }
            if(temp == nowEnd)
            {
                max = Math.max(max, temp.val);
                ans.add(max);
                nowEnd = nextEnd;
                max = Integer.MIN_VALUE;
            }
            else if (temp.val > max) {
                max = temp.val;
            }
        }
        return ans;
    }

    // bfs实现的层次遍历
    public List<Integer> largestValues_bfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE, size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.val > max) {
                    max = node.val;
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            ans.add(max);
        }
        return ans;
    }

	public static void main(String[] args) {
        Solution s = new Solution();
        String line = "[1,3,2,5,3,null,9]";
        // if((line = in.readLine()) != null) {
        TreeNode root = TreeNode.stringToTreeNode(line);
        List<Integer> ans = s.largestValues(root);
        System.out.println(ans);
        //}
	}
}