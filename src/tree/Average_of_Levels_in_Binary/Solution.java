package tree.Average_of_Levels_in_Binary;

import tools.TreeNode;

import java.io.IOException;
import java.util.*;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Arrays.asList(0.0);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        // ans.add(root.val);

        TreeNode nowLineEnd = root, nextLineEnd = null, temp = null;

        double sum = 0;
        int num = 0;
        queue.add(root);

        while (!queue.isEmpty())
        {
           temp = queue.poll();
           if(temp.left != null)
           {
               queue.add(temp.left);
               nextLineEnd = temp.left;
           }
           if(temp.right != null)
           {
               queue.add(temp.right);
               nextLineEnd = temp.right;
           }
           if(temp == nowLineEnd)
            {
                num += 1;
                sum += temp.val;
                ans.add(sum/num);
                nowLineEnd = nextLineEnd;
                num = 0;
                sum = 0.0;
            }
            else
            {
                num += 1;
                sum += temp.val;
            }
        }
        return ans;
    }

    public int getDepth(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node == null ? 0 : 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        TreeNode nextEnd = null, nowEnd = node;
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.left != null) {
                queue.offer(tmp.left);
                nextEnd = tmp.left;
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
                nextEnd = tmp.right;
            }
            if (tmp == nowEnd) {
                depth++;
                nowEnd = nextEnd;
            }
        }

        return depth;
    }

    public int getWidth(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node == null ? 0 : 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int width = 0;
        TreeNode nextEnd = null, nowEnd = node;
        queue.offer(node);
        while (!queue.isEmpty()) {
            width = Math.max(width, queue.size());
            TreeNode tmp = queue.poll();
            if (tmp.left != null) {
                queue.offer(tmp.left);
                nextEnd = tmp.left;
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
                nextEnd = tmp.right;
            }
            if (tmp == nowEnd) {
                nowEnd = nextEnd;
            }
        }

        return width;
    }

    public int getDepth1(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return node == null ? 0 : 1;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        int depth = 0;

        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = q.poll();
                if (tmp.left != null) {
                    q.add(tmp.left);
                }

                if (tmp.right != null) {
                    q.add(tmp.right);
                }
            }
        }

        return depth;
    }

	public static void main(String[] args) throws IOException {
		Solution s = new Solution();
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "[3,9,20,6,null,15,7,1]";
        // if((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            //List<Double> ans = s.averageOfLevels(root);
            int a = s.getDepth1(root);
            System.out.println(a);
        //}
	}
}