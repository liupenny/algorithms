package tree.Maximum_Width_of_Binary_Tree;

import tools.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/6/29.
 */

public class Solution{
    // 超时
//    public int widthOfBinaryTree(TreeNode root) {
//        if(root == null)
//            return 0;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<String> level = new ArrayList<>();
//        queue.add(root);
//        int ans = 0;
//        int size;
//
//        while (!queue.isEmpty())
//        {
//            size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode temp = queue.poll();
//                if(temp == null) {
//                    level.add("null");
//                    queue.add(null);
//                    queue.add(null);
//                    continue;
//                }
//                level.add("" + temp.val);
//                queue.add(temp.left);
//                queue.add(temp.right);
//            }
//
//            int begin = 0, end = level.size() - 1;
//            while (begin <= end && level.get(begin) == "null")
//            {
//                begin++;
//            }
//            while (begin <= end && level.get(end) == "null")
//            {
//                end--;
//            }
//            if(begin == end + 1)
//                break;
//
//            ans = Math.max(ans, end - begin + 1);
//            level.clear();
//        }
//        return ans;
//    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<AnnotateNode> queue = new LinkedList<>();
        queue.add(new AnnotateNode(root, 0 ,1));
        int curDepth = 0, left = 1, ans = 0;
        while (!queue.isEmpty())
        {
            AnnotateNode temp = queue.poll();
            if(temp.node != null)
            {
                queue.add(new AnnotateNode(temp.node.left, temp.depth + 1, temp.pos * 2 + 1));
                queue.add(new AnnotateNode(temp.node.right, temp.depth + 1, temp.pos * 2 + 2));
                // 重新来一行的时候更新一下
                if(curDepth != temp.depth)
                {
                    curDepth = temp.depth;
                    left = temp.pos;
                }
                // 每一步都计算一下最大值，而不是等到最后
                ans = Math.max(ans, temp.pos - left + 1);
            }
        }
        return ans;
    }

    class AnnotateNode{
        TreeNode node;
        int depth, pos;
        AnnotateNode(TreeNode n, int d, int p)
        {
            node = n;
            depth = d;
            pos = p;
        }
    }


    int ans;
    Map<Integer, Integer> left;
    public int widthOfBinaryTree_dfs(TreeNode root) {
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0);
        return ans;
    }
    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }

        public static void main(String[] args)
    {
        Solution s = new Solution();
        //TreeNode p = TreeNode.stringToTreeNode("[1,3,2,5,3,null,9]");
        //TreeNode p = TreeNode.stringToTreeNode("[1,3,null,5,3]");
        TreeNode p = TreeNode.stringToTreeNode("[1,1,1,1,null,null,1,1,null,null,1]");
        // TreeNode q = TreeNode.stringToTreeNode("[1,null,2]");
        System.out.println(s.widthOfBinaryTree(p));

//        TreeNode a1 = new TreeNode(1);
//        TreeNode a2 = new TreeNode(1);
//        TreeNode a3 = new TreeNode(1);
//        TreeNode a4 = new TreeNode(1);
//        TreeNode a5 = new TreeNode(1);
//        TreeNode a6 = new TreeNode(1);
//        TreeNode a7 = new TreeNode(1);
//        a1.left = a2;
//        a1.right = a3;
//        a2.left = a4;
//        a3.right = a5;
//        a4.left = a6;
//        a5.right = a7;
//        System.out.println(TreeNode.treeNodeToString(a1));
    }
}