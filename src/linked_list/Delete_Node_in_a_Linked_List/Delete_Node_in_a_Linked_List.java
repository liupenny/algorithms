package linked_list.Delete_Node_in_a_Linked_List;
import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/4.
 * leetcode: 237. Delete Node in a Linked List
 * 思路：需要删除链表中某个节点（不是尾节点），但并没有给原链表。所以要删除的节点后一个节点一定不是null，那么通过把下一个节点的值赋给当前节点，当前节点的next改成下一个节点的next即可。
 */
public class Delete_Node_in_a_Linked_List {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] algs)
    {
        Delete_Node_in_a_Linked_List t = new Delete_Node_in_a_Linked_List();
        ListNode node = new ListNode(8);
        t.deleteNode(node);
    }
}
