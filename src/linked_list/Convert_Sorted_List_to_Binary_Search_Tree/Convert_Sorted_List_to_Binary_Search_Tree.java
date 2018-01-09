package linked_list.Convert_Sorted_List_to_Binary_Search_Tree;

import tools.TreeNode;
import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/14.
 * 109. Convert Sorted List to Binary Search Tree
 * 思路：
 BST，二叉搜索树，小的在左边，大的在右边。
 怎样从一个有序的单向链表转化为BST呢？其实挺简单的，首先从BST原理出发
 BST的根节点其实就是等于一个有序数组中的中间那个大兄弟
 比喻，现在要转化为BST的不是链表，而是一个有序的数组，一共有n个数。这样的话就更加简单，我们来分析一下
 1，首先我们通过下标找出中间的那个数作为根节点，假设下表为x
 2，那么下标0~x-1的数肯定比x小，x+1~n-1的数比x大，将其分成三段
 3 新建根节点root的值为 下标X的数值，然后root的左孩子的值就是等于下标0~x-1的中间的下标的值，而右孩子就是x+1~n中间的下标的值，去到这一步大家都知道其实就是重复着1跟2，不停的递归下去，只要设置好递归的退出就能轻易转化好这个BST

 好了，回到我们的问题
 单向链表跟数组转化为BST唯一的不同就是找他的中间那个兄弟比较麻烦。
 这时我们就需要动用单向链表最喜欢用的快慢指针了，一快一慢，轻轻松松找到中间的
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode fast = head;
        ListNode slow = head;
        ListNode preMid = null;
        while (fast!=null && fast.next!=null)
        {
            preMid = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode mid = new TreeNode(slow.val);
        preMid.next = null;
        mid.left = sortedListToBST(head);
        mid.right = sortedListToBST(slow.next);
        return mid;
    }

    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new tools.Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
        citations2.addNode(3);
        citations2.addNode(4);
        citations2.addNode(5);
        Convert_Sorted_List_to_Binary_Search_Tree t = new Convert_Sorted_List_to_Binary_Search_Tree();
        TreeNode ans = t.sortedListToBST(citations2.first);
        preOrderRecur(ans);
    }

    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");  //先打印
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
}
