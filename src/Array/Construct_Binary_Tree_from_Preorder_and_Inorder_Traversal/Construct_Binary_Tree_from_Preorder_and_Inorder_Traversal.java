package Array.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import tools.TreeNode;

import java.util.*;

/**
 * Created by PennyLiu on 2018/6/2.
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    // 递归做
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        int[][] tree = root.printTree(root);
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[i].length; j++) {
                System.out.print(tree[i][j] + " ");
            }
            System.out.println();
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd)
    {
        if(preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]) {
                //i-startIn是左子树节点的个数，前序遍历起始值加上这个就是终点值
                //i-1就是中序遍历左子树的终点，起始值是从0一直从0开始
                root.left = buildTree(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
                root.right = buildTree(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
            }
        }

        return root;
    }

    // 存在Map里
    public TreeNode buildTree_map(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map)
    {
        if(ps > pe || is > ie) return null;
        if(pe >= preorder.length || ie >= inorder.length) return null;
        int rootVal = preorder[ps];

        int index = map.get(rootVal);
        int leftCnt = index - is;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, ps + 1, ps + leftCnt, inorder, is, index - 1, map);
        root.right = build(preorder, ps + leftCnt + 1, pe, inorder, index + 1, ie, map);
        return root;
    }

    // 堆栈做
    public TreeNode buildTree_stack(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;

        Stack<TreeNode> stk = new Stack<>();
        TreeNode result = new TreeNode(preorder[0]);
        stk.push(result);
        int i = 1, j = 0;
        while(i < preorder.length){
            while(i < preorder.length && !stk.isEmpty() && stk.peek().val != inorder[j]){
                TreeNode tmp = new TreeNode(preorder[i++]);
                stk.peek().left = tmp;
                stk.push(tmp);
            }
            TreeNode root = null;
            while(j < inorder.length && !stk.isEmpty() && stk.peek().val == inorder[j]){
                root = stk.pop();
                j++;
            }
            if(i < preorder.length && root != null) {
                TreeNode tmp = new TreeNode(preorder[i++]);
                root.right = tmp;
                stk.push(tmp);
            }
        }
        return result;

    }

    public static void printTree() {
        TreeNode root = new TreeNode(10);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        root.left = null; root.right = a1;
        a1.left = a2;
        int[] tree = root.printTreeIncludeNull(root);
        int index = 0;
        while (index <= tree.length)
        {

        }
    }

        public static void main(String[] args) {
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal t = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        // int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        int[] preorder = {3,9,6,4,20,15,7}, inorder = {6,9,4,3,15,20,7};
            //int[] preorder = {1,2,3}, inorder = {1,3,2};
        System.out.println(t.buildTree_stack(preorder, inorder));
        //t.printTree();
        }
}
