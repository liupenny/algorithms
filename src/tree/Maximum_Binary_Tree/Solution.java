package tree.Maximum_Binary_Tree;

import tools.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/6/14.
 * 示例：[3,2,1,6,0,5]
 * 结果：[6, 3, 5, null, 2, 0, null, null, 1, null, null, null, null]，后面这些多余的Null是正常的
 */

class sol {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        // TreeNode root = new TreeNode(0);
        return generateChild(nums, 0, nums.length - 1);
        // return root;
    }

    public TreeNode generateChild(int[] nums, int left, int right){
        if (left < 0 || right < 0 || left > right || right > nums.length - 1 || left > nums.length - 1) {
            return null;
        }
//        if(right - left < 0)
//            return null;

        int center = getMaxPos(nums, left, right);
        TreeNode root = new TreeNode(nums[center]);
        root.left = generateChild(nums, left, center - 1);
        root.right = generateChild(nums,center + 1, right);

        return root;
    }

    public int getMaxPos(int[] nums, int begin, int end)
    {
        if(begin == end ) {
            return begin;
        }

        int ans = begin;
        for (int i = begin; i <= end; i++) {
            if(nums[i] > nums[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}


public class Solution {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
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
            int[] nums = stringToIntegerArray(line);

            TreeNode ret = new sol().constructMaximumBinaryTree(nums);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
