package tree.Binary_Tree_Paths;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/6/29.
 */

public class Solution{
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        StringBuilder sb = new StringBuilder();
        addstring(root, sb, ans);
        return ans;
    }

    public void addstring(TreeNode node, StringBuilder sb, List<String> ans)
    {
        // 这里只考虑了到叶子节点的情况
        int length = sb.length();
        // 这个 node == null必须要加，因为如果是
        /*
           1
          / \
         2   3
          \
           5
         */
        // 如果是上面这种状况，2跳到他左边的时候就会有空指针，因为null没有 left or right。
        /*
        所以，要把所有情况考虑完，就是当前节点只有左，那就朝左边走；只有右，朝右边走；两边都有，判断结尾。其他情况不管
         */
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null)
        {
            sb.append(node.val);
            String tmp = new String(sb.toString());
            ans.add(tmp);
            return;
        }
        else {
            sb.append(node.val + "->");
        }

        addstring(node.left, sb, ans);
        addstring(node.right, sb, ans);

        sb.setLength(length);
    }

    public List<String> binaryTreePaths_1(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) {
            searchBT(root, "", answer);
        }
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        //把所有可能情况考虑玩，就是当前节点只有左，那就朝左边走；只有右，朝右边走；两边都有，判断结尾。其他情况不管
        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
        }

        // 这里在参数中修改string,返回的时候就直接返回上一个函数的参数，一步去掉 val + ->
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", answer);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", answer);
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode p = TreeNode.stringToTreeNode("[1,2,3,null,5]");
        // TreeNode q = TreeNode.stringToTreeNode("[1,null,2]");
        System.out.println(s.binaryTreePaths_1(p));
        //System.out.println(s.binaryTreePaths(p));
    }
}