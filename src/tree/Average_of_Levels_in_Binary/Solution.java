package tree.Average_of_Levels_in_Binary;

import tools.TreeNode;

import java.io.IOException;
import java.util.*;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return Arrays.asList(0.0);

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

	public static void main(String[] args) throws IOException {
		Solution s = new Solution();
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "[3,9,20,null,null,15,7]";
        // if((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            List<Double> ans = s.averageOfLevels(root);
            System.out.println(ans);
        //}
	}
}