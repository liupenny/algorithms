package tree.Serialize_and_Deserialize_Binary_Tree;

import tools.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/6/27.
 */

class Codec {
    private static final String spliter = ",";
    private static final String NN = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null)
            return "";

        seria(root,sb);
        return sb.toString();
    }

    // 先序遍历存这棵树
    public void seria(TreeNode root, StringBuilder sb)
    {
        if(root == null)
            sb.append(NN).append(spliter);
        else
        {
            sb.append(root.val).append(spliter);
            seria(root.left, sb);
            seria(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data == "")
            return null;

        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(spliter)));
        return deseria(queue);
    }

    public TreeNode deseria(Queue<String> queue)
    {
        String val = queue.remove();
        if(val.equals(NN))
            return null;
        else
        {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = deseria(queue);
            node.right = deseria(queue);
            return node;
        }
    }
}

// 用leetcode本身的方式写的，层次遍历
class Code {
    private static final String spliter = ",";
    private static final String NN = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";

        StringBuilder output = new StringBuilder("");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node == null)
            {
                output.append(NN).append(spliter);
                continue;
            }

            output.append(node.val + spliter);
            queue.add(node.left);
            queue.add(node.right);
        }
        return output.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data == "")
            return null;
        String[] parts = data.split(spliter);
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 0;
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(index == parts.length)
                break;

            index++;
            if(!parts[index].equals(NN))
            {
                node.left = new TreeNode(Integer.parseInt(parts[index]));
                queue.add(node.left);
            }

            if(index == parts.length)
                break;

            index++;
            if(!parts[index].equals(NN))
            {
                node.right = new TreeNode(Integer.parseInt(parts[index]));
                queue.add(node.right);
            }
        }
        return root;
    }
}

public class Solution{
    public static void main(String[] args)
    {
        TreeNode a1 = new TreeNode(0);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(3);
        a1.left = a2;
        a1.right = a3;
        a2.right = a4;
        Code t = new Code();
        System.out.println(t.serialize(a1));
        String s = "0,1,2,null,3,null,null,null,null,";
        t.deserialize(s);

    }
}