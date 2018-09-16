package array.Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import tools.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by PennyLiu on 2018/6/4.
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        TreeNode root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    public TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if(postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        for (int i = inStart; i <= inEnd ; i++) {
            if(inorder[i] == postorder[postEnd])
            {   //i-startIn是左子树节点的个数
                root.left = buildTree(postorder, postStart, postStart + i - inStart - 1, inorder, inStart, i - 1);
                root.right = buildTree(postorder, postStart + i - inStart, postEnd - 1, inorder, i + 1, inEnd);
            }
        }
        return root;
    }

    public TreeNode buildTree_map(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> order = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i ++) {
            order.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = postorder.length - 2; i >= 0; i --) {
            TreeNode curr = new TreeNode(postorder[i]);
            if (order.get(curr.val) > order.get(stack.peek().val)) {
                stack.peek().right = curr;
            } else {
                TreeNode parent = stack.pop();
                while (!stack.isEmpty() && (order.get(curr.val) < order.get(stack.peek().val))) {
                    parent = stack.pop();
                }
                parent.left = curr;
            }
            stack.push(curr);
        }

        return root;
    }

    public TreeNode buildTree_stack(int[] inorder, int[] postorder) {

        if( inorder.length == 0 ) {
            return null;
        }
        // last element in the postorder is the root of the tree
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        for(int i=postorder.length-2, j = inorder.length-1;i>=0;--i){
            //postorder[i] is the right child till the element in inorder traversal is not equal (i.e.rightmost node)
            if( st.peek().val != inorder[j] ){
                st.push(st.peek().right = new TreeNode(postorder[i]));
            }else{
                TreeNode temp = null;
                //pop  till all the elements matching inorder elements are removed
                while(!st.empty() && st.peek().val == inorder[j]){
                    temp = st.pop(); j--;
                }
                st.push(temp.left =  new TreeNode(postorder[i])); //continue in post-order fashion
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal t = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
    }
}
