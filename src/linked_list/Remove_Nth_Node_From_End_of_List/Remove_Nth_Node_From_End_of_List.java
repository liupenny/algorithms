package linked_list.Remove_Nth_Node_From_End_of_List;
import tools.*;

/**
 * Created by PennyLiu on 2017/10/14.
 * 19. Remove Nth Node From End of List
 * 思路：让快指针先比慢指针多走n步，这样快指针到头时，慢指针正好在倒数第n个节点前面一个节点
 */
public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {  //通过快慢指针确定要删除的元素，因为没法从后往前数
        if(head.next == null || head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        for (int i = 1; i <= n; i++)
        {
            fast = fast.next;
        }
        while (fast!=null && fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        if(fast==null) {
            return head.next;
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n){
        if (head == null) {
            return null;
        }
        int i = 1;
        ListNode dummyHead = new ListNode(0), tmp = dummyHead;
        dummyHead.next = head;
        while (tmp != null && i <= n) {
            tmp = tmp.next;
            i++;
        }
        if (tmp == null) {
            return head;
        }

        ListNode slow = dummyHead;
        while (tmp.next != null) {
            tmp = tmp.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new tools.Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
        citations2.addNode(6);
        citations2.addNode(4);
        citations2.addNode(5);
        Remove_Nth_Node_From_End_of_List t = new Remove_Nth_Node_From_End_of_List();
        ListNode ans = t.removeNthFromEnd(citations2.first,4);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
