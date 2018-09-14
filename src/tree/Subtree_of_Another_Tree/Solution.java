package tree.Subtree_of_Another_Tree;

import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/6/25.
 */

public class Solution{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }
        if(t == null) {
            return true;
        }

        if (isSame(s,t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // isSame那道题，判断两棵树完全相同的那个题
    public boolean isSame(TreeNode s, TreeNode t)
    {
        if(s == null && t == null) {
            return true;
        } else if(s == null || t == null) {
            return false;
        } else if(s.val != t.val) {
            return false;
        }

        return isSame(s.left,t.left) && isSame(s.right,t.right);
    }

    // 将树用序列化的形式表示出来，判断是不是子串
    public boolean isSubtree_serialize(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }
        if(t == null) {
            return true;
        }

        StringBuilder ss = new StringBuilder();
        StringBuilder st = new StringBuilder();

        serialize(s,ss);
        serialize(t,st);

        String sss = ss.toString();
        String sst = st.toString();

        return sss.indexOf(sst) != -1;
    }

    // 传递stringbuilder是因为这是可变的，string是不可变的
    public void serialize(TreeNode s, StringBuilder ss)
    {
        if(s == null) {
            ss.append(",#");
        } else {
            ss.append("," + s.val);
            serialize(s.left, ss);
            serialize(s.right, ss);
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeNode treeNode1 = TreeNode.stringToTreeNode("[3,4,5,1,2,null,null,null,null,0]");
        TreeNode treeNode2 = TreeNode.stringToTreeNode("[4,1,2]");
        System.out.println(s.isSubtree(treeNode1,treeNode2));
        System.out.println(s.isSubtree_serialize(treeNode1,treeNode2));
    }
}