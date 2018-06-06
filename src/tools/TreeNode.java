package tools;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

    public int[] printTreeIncludeNull(TreeNode root)
    {
        ArrayList<Integer> tree = new ArrayList<>();
        tree.add(0,root.val);
        addNode(tree,0 * 2 + 1, root.left);
        addNode(tree,0 * 2 + 2, root.right);

        int level = getLevel(root), num = 0;
        char[][] result = new char[level][];
        for (int i = 0; i < level; i++) {
            int len = (int) Math.pow(2.0, (double)i);
            result[i] = new char[len];
            for (int j = 0; j < len; j++) {
                result[i][j] = tree.get()
            }
        }

        int[] res = new int[tree.size()];
        for (int i = 0; i < tree.size(); i++) {
            res[i] = tree.get(i);
        }
        return res;
    }

    private int getLevel(TreeNode root)
    {
        int leftLevel, rightLevel;
        if(root == null)
            return 0;
        else
        {
            leftLevel = getLevel(root.left);
            rightLevel = getLevel(root.right);
            return (leftLevel > rightLevel) ? (leftLevel + 1) : rightLevel + 1;
        }
    }

    private void addNode(ArrayList<Integer> tree, int index, TreeNode node)
    {
        if(node == null) {
            tree.add(index, -1);
            return;
        }
        tree.add(index, node.val);
        while (node.left != null)
            addNode(tree, 2 * index + 1, node.left);
        while (node.right != null)
            addNode(tree, 2 * index + 2, node.right);
    }
}