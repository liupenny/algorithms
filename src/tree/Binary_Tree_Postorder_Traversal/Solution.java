package tree.Binary_Tree_Postorder_Traversal;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by PennyLiu on 2018/6/22.
 */

public class Solution{
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curVisited = root, lastVisited = null;
        while (curVisited != null)
        {
            stack.push(curVisited);
            curVisited = curVisited.left;
        }
        while (!stack.empty())
        {
            curVisited = stack.pop();
            if(curVisited.right == null || curVisited.right == lastVisited)
            {
                ans.add(curVisited.val);
                lastVisited = curVisited;
            }
            else
            {
                stack.push(curVisited);
                curVisited = curVisited.right;
                while (curVisited != null)
                {
                    stack.push(curVisited);
                    curVisited = curVisited.left;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "[1,null,2,3]";
        // if((line = in.readLine()) != null) {
        TreeNode root = TreeNode.stringToTreeNode(line);
        List<Integer> ans = s.postorderTraversal(root);
        System.out.println(ans);
        //}
    }
}