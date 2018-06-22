package tree.Trim_a_Binary_Search_Tree;

import tools.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static tools.TreeNode.treeNodeToString;

class solu {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root == null || L > R)
			return root;

		if (root.val < L) {
			return trimBST(root.right, L, R);
		}
		if (root.val > R) {
			return trimBST(root.left, L, R);
		}

		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}


}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		if ((line = in.readLine()) != null) {
			TreeNode root = TreeNode.stringToTreeNode(line);
			line = in.readLine();
			int L = Integer.parseInt(line);
			line = in.readLine();
			int R = Integer.parseInt(line);

			TreeNode ret = new solu().trimBST(root, L, R);

			String out = treeNodeToString(ret);

			System.out.print(out);
		}
	}
}