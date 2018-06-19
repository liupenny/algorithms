package tools;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by PennyLiu on 2017/10/14.
 */

public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }

      public int[][] printTree(TreeNode root)
      {
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
          while (queue.size() != 0)
          {
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
    public Object[] treeNodeToIntegerArray(TreeNode root) {
        if(root == null)
            return new Object[0];

        int depth = this.getDepth(root);
        double num = Math.pow(2.0, depth + 0.0);
        int number = (int)num - 1;
        Object[] output = new Object[number];
        Arrays.fill(output, null);

        output[0] = root.val;
        insert(root.left, output, 1);
        insert(root.right, output, 2);

        return output;
    }

    public static void insert(TreeNode root, Object[] output, int index)
    {
        if(root == null)
            return;

        output[index] = root.val;
        insert(root.left, output, 2 * index + 1);
        insert(root.right, output, 2 * index + 2);
    }

    // 不能通过这样二维数组的形式保存二叉树，因为一到null就停止了，不能继续下去
//    public static ArrayList<Object[]> treeNodeToIntegerArray(TreeNode root) {

    // 获取树的深度
    public int getDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return left >= right ? left + 1: right + 1;
    }


}