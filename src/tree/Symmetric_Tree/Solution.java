package tree.Symmetric_Tree;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/6/28.
 */

public class Solution{
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> tmp = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();

                if(temp == null)
                {
                    tmp.add("null");
                    continue;
                }

                tmp.add("" + temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }

            int len = tmp.size();
            for (int i = 0; i < len/2; i++) {
                if(!tmp.get(i).equals(tmp.get(len - 1 - i)))
                    return false;
            }
            tmp.clear();
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode p = TreeNode.stringToTreeNode("[1,2,2,null,3,null,3]");
        // TreeNode q = TreeNode.stringToTreeNode("[1,null,2]");
        System.out.println(s.isSymmetric(p));
    }
}