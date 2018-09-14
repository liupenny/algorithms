package tree.Binary_Tree_Level_Order_Traversal;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/6/22.
 */

public class Solution{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        // 用双端链表实现队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        // now表示现在正在访问的节点，默认是null；nextlast表示下一层的最后一个节点，默认是null;nowlast表示这一层的结尾
        TreeNode temp = root;
        TreeNode nowlast = root;
        TreeNode nextlast = null;

        // 创建一个集合存放当前遍历的这一层的所有节点
        ArrayList<Integer> level = new ArrayList<>();

        queue.add(root);
        while (queue.size() != 0)
        {
            temp = queue.poll();
            level.add(temp.val);
            if (temp.left != null) {  //这个方法会忽略掉为空的叶子节点，显示不直观
                queue.add(temp.left);
                nextlast = temp.left;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nextlast = temp.right;
            }
            //到了一行的末尾，需要更新
            if (temp == nowlast) {
                res.add(level);
                level = new ArrayList<>(); //如果不新建的话，每次添加的就都是同一个地址的内容了
                nowlast = nextlast; //此时，新的一行的末尾就是刚刚一直更新出来的
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String line = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(line);
        Solution s = new Solution();
        List<List<Integer>> res = s.levelOrder(root);
        System.out.println(res);
    }

}