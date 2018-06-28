package tree.Serialize_and_Deserialize_BST;

import tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by PennyLiu on 2018/6/27.
 */

class Codec {
    private static final String spliter = ",";
    private static final String NN = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";

        StringBuilder output = new StringBuilder("");
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty())
        {
            TreeNode node = stack.pop();
            output.append(node.val + spliter);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return output.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals(""))
            return null;
        String[] parts = data.split(spliter);
        Queue<Integer> queue = new LinkedList<>();
        for (String part: parts) {
            queue.add(Integer.parseInt(part));
        }
        return getNode(queue);
    }

    public TreeNode getNode(Queue<Integer> queue)
    {
        if(queue.isEmpty())
            return null;
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallQueue = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < root.val)
        {
            smallQueue.add(queue.poll());
        }

        root.left = getNode(smallQueue);
        root.right = getNode(queue);
        return root;
    }
}

public class Solution{
    public static void main(String[] args)
    {
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(3);
        // TreeNode a4 = new TreeNode(3);
        a1.left = a2;
        a1.right = a3;
        // a2.right = a4;
        Codec t = new Codec();
        System.out.println(t.serialize(a1));
        String s = "2,1,3,";
        t.deserialize(s);
    }
}