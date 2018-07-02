package tree.Find_Mode_in_Binary_Search_Tree;

import tools.TreeNode;

import java.util.*;

/**
 * Created by PennyLiu on 2018/6/30.
 */

public class Solution{
    int biggest;
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];

        biggest = 0;
        HashMap<Integer, Integer> ans = new HashMap();
        helper(root, ans);
        List<Integer> ret = new ArrayList<>();
        Iterator<HashMap.Entry<Integer, Integer>> iterator = ans.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if(entry.getValue().equals(biggest))
                ret.add(entry.getKey());
        }
        int[] ints = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            ints[i] = ret.get(i);
            System.out.print(ints[i] + " ");
        }
        return ints;
    }

    public void helper(TreeNode root, HashMap<Integer, Integer> ans)
    {
        if(root == null)
            return;
        else
        {
            ans.put(root.val, ans.getOrDefault(root.val, 0) + 1);
            biggest = Math.max(biggest, ans.get(root.val));
        }

        if(root.left != null)
            helper(root.left, ans);
        if(root.right != null)
            helper(root.right, ans);
    }

    // 中序遍历，
    // num:当前的数
    // cnt:当前的数的个数
    // maxCnt：目前为止出现次数最多的数出现的个数
    int num = 0, cnt = 0, maxCnt = 0;
    List<Integer> list = new ArrayList();
    public int[] findMode_recur(TreeNode root) {
        helper(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先序遍历也没关系，反正都要跟前一个数比较
        helper(root.left);
        if (root.val == num) {
            cnt++;
            if (cnt > maxCnt) {
                maxCnt = cnt;
                list.clear();
            }
            if (cnt == maxCnt) {
                list.add(root.val);
            }
        } else {
            num = root.val;
            cnt = 1;
            if (cnt > maxCnt) {
                maxCnt = cnt;
                list.clear();
            }
            if (cnt == maxCnt) {
                list.add(root.val);
            }
        }
        helper(root.right);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode root = TreeNode.stringToTreeNode("[2,2,2,2,2,2,2]");
        s.findMode_recur(root);
    }
}