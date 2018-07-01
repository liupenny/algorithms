package tree.Find_Duplicate_Subtrees;

import tools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PennyLiu on 2018/6/30.
 */

public class Solution{
    Map<String, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node)
    {
        if (node == null)
            return "#";

        String s = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(s,count.getOrDefault(s,0) + 1);
        if(count.get(s) == 2)
            ans.add(node);
        return s;
    }

    int id;
    // stringID:给每个不同的（节点的中序遍历）字符串分配一个id
    // count:计算每个id出现的次数

    Map<String, Integer> stringId;
    Map<Integer, Integer> countId;
    public List<TreeNode> findDuplicateSubtreesId(TreeNode root) {
        stringId = new HashMap<>();
        count = new HashMap<>();
        ans = new ArrayList<>();
        childId(root);
        return ans;
    }

    public int childId(TreeNode node)
    {
        if(node == null)
            return 0;
        String s = node.val + "," + childId(node.left) + "," + childId(node.right);
        // computeIfAbsent函数自己会计算返回值，并执行插入操作，将返回值返回。
        int sid = stringId.computeIfAbsent(s, x->id++);
        countId.putIfAbsent(sid, countId.getOrDefault(sid, 0) + 1);
        if(countId.get(sid) == 2)
            ans.add(node);
        return sid;
    }

    public static void main(String[] args)
    {
    
    }
}