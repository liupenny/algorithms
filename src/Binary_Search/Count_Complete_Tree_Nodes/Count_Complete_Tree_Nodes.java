package Binary_Search.Count_Complete_Tree_Nodes;
import tools.TreeNode;

/**
 * Created by PennyLiu on 2018/1/17.
 */
public class Count_Complete_Tree_Nodes {   //root所在的层为1
    public int countNodes(TreeNode root)
    {
        if(root == null) {
            return 0;
        }
        return bs(root, 1, MostLeftLevel(root,1));
    }

    public int bs(TreeNode root, int level, int depth)
    /**
     * @param root
     * @param level 根节点root所在的层
     * @param depth  root的左子树所在的层
     * @return
     */
    {
        if(level == depth) {
            return 1;
        }
        if(MostLeftLevel(root.right,level+1) == depth) {
            return (1 << (depth - level)) + bs(root.right, level + 1, depth);
        } else {
            return (1 << (depth - level - 1)) + bs(root.left, level + 1, depth);
        }
    }


    public int MostLeftLevel(TreeNode root, int level)
    /**
     *
     * @param root 根节点
     * @param level 根节点root所在的层次
     * @return 根节点root左子树所能到达的最深层
     */
    {
        while (root!=null)
        {
            level++;
            root = root.left;
        }
        return level-1;
    }

    public static void main(String[] algs)
    {
        TreeNode root = new TreeNode(10);
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode b1 = new TreeNode(8);
        TreeNode b2 = new TreeNode(7);
        TreeNode c1 = new TreeNode(6);
        TreeNode c2 = new TreeNode(9);
        root.left = a1; root.right = a2;
        a1.left = b1; a1.right = b2;
        a2.left = c1; a2.right = c2;
        Count_Complete_Tree_Nodes t = new Count_Complete_Tree_Nodes();
        int ans = t.countNodes(root);
        System.out.println(ans);
    }
}
