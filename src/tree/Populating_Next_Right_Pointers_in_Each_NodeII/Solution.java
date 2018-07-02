package tree.Populating_Next_Right_Pointers_in_Each_NodeII;

import tools.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PennyLiu on 2018/7/2.
 */

public class Solution{
    public void connect_constant_space(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;

        while (root != null)
        {
            // 像链表一样，每一层创建一个临时的头结点
            TreeLinkNode levelHead = new TreeLinkNode(0);
            TreeLinkNode currentNode = levelHead;

            while (root != null)
            {
                if(root.left != null)
                {
                    // 用临时头结点去连接左右孩子，最后临时头结点也不返回，所以没影响。
                    currentNode.next = root.left;
                    currentNode = currentNode.next;
                }
                if(root.right != null)
                {
                    currentNode.next = root.right;
                    currentNode = currentNode.next;
                }
                root = root.next;
            }
            root = levelHead.next;
        }

        // preorder(root);
    }

    public void connect_queue(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i <size ; i++) {
                TreeLinkNode temp = queue.peek();
                queue.poll();
                // 在拿出某一个的时候就把当前节点的next赋值好；
                // 而不是保存当前的，在拿出下一个的时候将当前的next赋给下一个。
                if(i < size - 1)
                    temp.next = queue.peek();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

    public void preorder(TreeLinkNode root)
    {
        if(root.next == null)
            System.out.println("" + root.val + "->: null");
        else
            System.out.println( "" + root.val + "->: " + root.next.val);
        if(root.left != null)
            preorder(root.left);
        if(root.right != null)
            preorder(root.right);
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        TreeLinkNode a1 = new TreeLinkNode(1);
        TreeLinkNode a2 = new TreeLinkNode(2);
        TreeLinkNode a3 = new TreeLinkNode(3);
        TreeLinkNode a4 = new TreeLinkNode(4);
        TreeLinkNode a5 = new TreeLinkNode(5);
        TreeLinkNode a6 = new TreeLinkNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.right = a6;
        // s.connect(a1);
    }
}