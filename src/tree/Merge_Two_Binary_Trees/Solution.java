package tree.Merge_Two_Binary_Trees;

import tools.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class solu {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left); //让他的左右孩子=接下来递归的返回值
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

//	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//		if(t1 == null || t2 == null)
//			return t1 == null ?  ( t2 == null ? null : t2) : t1;
//
//		int depth1 = getDepth(t1);
//		int depth2 = getDepth(t2);
//
//		if(depth1 >= depth2) //把层数多一些的数放在前面，另一棵树的值直接加在这棵树上
//			merge(t1, t2);
//		else
//			merge(t2, t1);
//
//		return t1;
//	}
//
//	public  int getDepth(TreeNode root) {
//		if(root == null)
//			return 0;
//
//		int left = getDepth(root.left);
//		int right = getDepth(root.right);
//
//		return left >= right ? left + 1: right + 1;
//	}
//
//	public void merge(TreeNode t1, TreeNode t2)
//	{
//		if(t1 == null && t2 == null)
//			return;
//		else if(t1 == null && t2 != null)
//		{
//		    // 这里没法操作，t1 = null，意味着他的父亲节点的某个孩子是空，需要给null赋一个新值，并且父亲节点的孩子指向这个节点才行。但是现在只能赋值，没法指向就有问题。
//			t1 = t2;
//			// t1 = new TreeNode(t2.val);
//			return;
//		}
//		else if(t1 != null && t2 != null)
//			t1.val = t1.val + t2.val;
//		else if(t1 != null && t2 == null)
//			return;
//
//		merge(t1.left, t2.left);
//		merge(t1.right, t2.right);
//	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		if ((line = in.readLine()) != null) {
			TreeNode t1 = TreeNode.stringToTreeNode(line);
			line = in.readLine();
			TreeNode t2 = TreeNode.stringToTreeNode(line);

			TreeNode ret = new solu().mergeTrees(t1, t2);

			String out = TreeNode.treeNodeToString(ret);

			System.out.print(out);
		}
	}
}