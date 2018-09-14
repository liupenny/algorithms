package tree.Binary_Tree_Zigzag_Level_Order_Traversal;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/6/22.
 */

public class Solution{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // dir表示方向，true是左->右,false是右向左
        boolean dir = true;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++)
            {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }

                if(dir == true) {
                    level.add(temp.val);
                } else {
                    level.addFirst(temp.val);
                }
            }
            ans.add(level);
            dir = !dir;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String line = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        List<List<Integer>> ans = s.zigzagLevelOrder(root);
        System.out.println(ans);
    }
}