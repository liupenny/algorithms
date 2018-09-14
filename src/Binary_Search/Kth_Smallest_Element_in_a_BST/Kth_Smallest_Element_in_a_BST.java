package Binary_Search.Kth_Smallest_Element_in_a_BST;

import tools.TreeNode;

import java.util.Stack;

/**
 * Created by PennyLiu on 2017/10/22.
 * 230. Kth Smallest Element in a BST
 */
public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int num = 0;
        while (root!=null)
        {
            while (!stack.empty() || root!=null)
            {
                if(root!=null)
                {
                    stack.push(root);
                    root = root.left;
                }
                else
                {
                    root = stack.pop();
                    num++;
                    if(num==k) {
                        return root.val;
                    }
                    root = root.right;
                }
            }
        }
    return 0;
    }

    public int kthSmallest2(TreeNode root, int k) {
        int nums = count(root.left);
        if (k <= nums) {
            return kthSmallest2(root.left, k);
        } else if(k > nums +1) {
            return kthSmallest2(root.right, k - nums - 1);
        }
        return root.val;
    }

    public int count(TreeNode root)
    {
        if (root==null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public static void main(String[] algs)
    {
        Kth_Smallest_Element_in_a_BST t = new Kth_Smallest_Element_in_a_BST();
        TreeNode root = new TreeNode(10);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(6);
        TreeNode b1 = new TreeNode(8);
        TreeNode b2 = new TreeNode(7);
        TreeNode b3 = new TreeNode(9);
        root.left = a1; root.right = a2;
        a1.left = a2; a1.right = a3;
        b1.left = b2; b1.right = b3;
        int ans = t.kthSmallest2(root,3);
        System.out.println(ans);
    }
}
