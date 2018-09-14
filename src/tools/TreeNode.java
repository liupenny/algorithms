package tools;

import java.util.*;

/**
 * Created by PennyLiu on 2017/10/14.
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    // 将数组打印出来,形式如下
    /*
    Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
     */
    public void printTree_format(TreeNode root) {
        if (root == null) {
            return;
        }

        // 获取树的深度和宽度
        int depth = getDepth(root);
        int width = (int) Math.pow(2, depth) - 1;
        String[][] ans = new String[depth][width];
        for (String[] arr : ans) {
            Arrays.fill(arr, "");
        }

        fill(root, ans, 0, 0, width - 1);
        List<List<String>> ret = new ArrayList<>();
        for (String[] arr : ans) {
            ret.add(Arrays.asList(arr));
        }

        String[][] result = new String[ret.size()][];
        for (int i = 0; i < ret.size(); i++) {
            result[i] = new String[ret.get(i).size()];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = ret.get(i).get(j);
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        //return ret;
    }

    public void fill(TreeNode root, String[][] ans, int level, int begin, int end) {
        if (begin > end || root == null) {
            return;
        }

        ans[level][(begin + end) / 2] = "" + root.val;
        fill(root.left, ans, level + 1, begin, (begin + end) / 2 - 1);
        fill(root.right, ans, level + 1, (begin + end) / 2 + 1, end);
    }

    // 将树用数组打印出来，但是null的节点不打印
    /*
    Input:
     1
    / \
   2   3
    \
     4
Output:
[[1],
 [2,3],
 [4]]
     */
    public static int[][] printTree(TreeNode root) {
        // 用双端链表实现队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<TreeNode>> res = new ArrayList<>();

        // now表示现在正在访问的节点，默认是null；nextlast表示下一层的最后一个节点，默认是null;nowlast表示这一层的结尾
        TreeNode temp = root;
        TreeNode nowlast = root;
        TreeNode nextlast = null;

        // 创建一个集合存放当前遍历的这一层的所有节点
        ArrayList<TreeNode> level = new ArrayList<>();

        queue.add(root);
        while (queue.size() != 0) {
            temp = queue.poll();
            level.add(temp);
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

        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = new int[res.get(i).size()];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = res.get(i).get(j).val;
            }
        }
        return result;
    }

    // 将一棵树转换成数组保存，打印的时候要先获取树的深度，再根据深度每行打印2^i个
    public static Object[] treeNodeToIntegerArray(TreeNode root) {
        if (root == null) {
            return new Object[0];
        }

        int depth = getDepth(root);
        double num = Math.pow(2.0, depth + 0.0);
        int number = (int) num - 1;
        Object[] output = new Object[number];
        Arrays.fill(output, null);

        output[0] = root.val;
        insert(root.left, output, 1);
        insert(root.right, output, 2);

        return output;
    }

    private static void insert(TreeNode root, Object[] output, int index) {
        if (root == null) {
            return;
        }

        output[index] = root.val;
        insert(root.left, output, 2 * index + 1);
        insert(root.right, output, 2 * index + 2);
    }

    // 不能通过这样二维数组的形式保存二叉树，因为一到null就停止了，不能继续下去
//    public static ArrayList<Object[]> treeNodeToIntegerArray(TreeNode root) {

    // 获取树的深度
    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return left >= right ? left + 1 : right + 1;
    }

    // 字符串转换成数组
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    // TreeNode ---> string
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
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

    // string ---> TreeNode
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
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}