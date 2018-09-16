package tree.Binary_Tree_Pruning;

import tools.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Solut {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        boolean isZeroRoot = isZero(root);
        if(isZeroRoot == true) {
            return null;
        } else {
            return root;
        }
    }

    public boolean isZero(TreeNode root)
    {
        if(root == null) {
            return true;
        }

        boolean isLeftZero = isZero(root.left);
        boolean isRightZero = isZero(root.right);

        // 这里一旦设置了root == null , 下面就没法返回了
        if(isLeftZero) {
            root.left = null;
        }
        if(isRightZero) {
            root.right = null;
        }

        return isLeftZero && isRightZero && root.val == 0;
    }
}

public class Solution {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!"null".equals(item)) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!"null".equals(item)) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        if((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            TreeNode ret = new Solut().pruneTree(root);
            String out = treeNodeToString(ret);
            System.out.print(out);
        }
    }
}