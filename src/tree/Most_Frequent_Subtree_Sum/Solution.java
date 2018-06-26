package tree.Most_Frequent_Subtree_Sum;

import tools.TreeNode;

import java.util.*;

/**
 * Created by PennyLiu on 2018/6/24.
 */

public class Solution{
    int highfreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[0];

        Map<Integer,Integer> map = new HashMap<>();
        freq(root,map);

        List<Integer> ans = new ArrayList<>();
        for (Integer key : map.keySet())
        {
            if(map.get(key) == highfreq)
                ans.add(key);
        }

        int[] ret = new int[ans.size()];
        Iterator<Integer> iterator = ans.iterator();
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = iterator.next().intValue();
        }

        System.out.println(ans);
        return ret;
    }

    public int freq(TreeNode root, Map<Integer,Integer> map)
    {
        int frequen = 0;
        if(root == null)
            return 0;

        int left = freq(root.left, map);
        int right = freq(root.right, map);

        int sum = left + right + root.val;
        map.put(sum, frequen = map.getOrDefault(sum,0) + 1);

        if(frequen > highfreq)
            highfreq = frequen;

        return sum;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode treeNode = TreeNode.stringToTreeNode("[3,1,5,0,2,4,6,null,null,null,3]");
        System.out.println(s.findFrequentTreeSum(treeNode));
    }
}