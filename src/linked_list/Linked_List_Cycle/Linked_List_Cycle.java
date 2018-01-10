package linked_list.Linked_List_Cycle;
import tools.*;

/**
 * Created by PennyLiu on 2017/10/9.
 * 141. Linked List Cycle
 */
public class Linked_List_Cycle { //详细证明上网
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode fast=head,slow=head;
        while (fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }

    public static void main(String[] algs)
    {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = null;
        Linked_List_Cycle t = new Linked_List_Cycle();
        boolean res = t.hasCycle(a1);
        System.out.println(res);
    }
}
