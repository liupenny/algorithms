package linked_list.Linked_List_Cycle_II;
import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/10.
 * 	142	Linked List Cycle II
 */
public class Linked_List_Cycle_II {  //详细证明看左神笔记，或者上网看
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode fast=head,slow=head,encounter=null;
        while (fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                encounter = slow;
                break;
            }
        }
        if(encounter==null)
            return null;
        while (head!=encounter)
        {
            head = head.next;
            encounter = encounter.next;
        }
        return encounter;
    }

    public static void main(String[] algs)
    {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(6);
        ListNode a5 = new ListNode(7);
        ListNode a6 = new ListNode(8);
        ListNode a7 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a3;
        Linked_List_Cycle_II t = new Linked_List_Cycle_II();
        ListNode res = t.detectCycle(a1);
        System.out.println(res.val);
    }
}
