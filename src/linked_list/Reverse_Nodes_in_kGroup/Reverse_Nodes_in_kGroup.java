import tools.*;
import tools.Sort_List;

/**
 * Created by PennyLiu on 2017/10/16.
 * 25. Reverse Nodes in k-Group
 * 非递归：reverseKGroup1
 * 递归：reverseKGroup2
 */
public class Reverse_Nodes_in_kGroup {
    public ListNode reverseKGroup1(ListNode head, int k) {
        if(head==null || head.next == null || k==1) return head;
        ListNode newhead = new ListNode(0), tmp = head, ans = newhead;
        newhead.next = head;
        ListNode front,tail,newtmp;
        while (tmp!=null)   //挨个轮流
        {
            front = tmp;  //赋值后，front并不会因为tmp一直改变而改变。
            for (int i = 1; i<k && tmp!=null; i++)
            {
                tmp = tmp.next;
            }
            tail = tmp;
            if(tail!=null)
            {
                newtmp = tmp.next;  //因为下面reverse函数会将tail传进去，就会改变tail的连接顺序，因此tmp的连接顺序也会跟着变。因此要先保留tmp.next
                tmp = newtmp;
                ListNode newfront = reverse(front, tail);
                ans.next = tail;
                ans = newfront;
            }
            else
                ans.next = front;
        }
        return newhead.next;
    }

    public ListNode reverse(ListNode front, ListNode tail)
    {
        ListNode tmp, rettail = front, end = null;
        tail.next = null;
        while (front!=null)
        {
            tmp = front.next;
            front.next = end;
            end = front;
            front = tmp;
        }
        return rettail;
    }

    public ListNode reverseKGroup3(ListNode head, int k) {  //先算出来链表的总长度，每k个做一次逆转
        int n = 0;
        for (ListNode i = head; i != null; n++, i = i.next);

        ListNode dmy = new ListNode(0);
        dmy.next = head;
        for(ListNode prev = dmy, tail = head; n >= k; n -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }

            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup2(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
    public static void main(String[] algs)
    {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(9);
        ListNode a5 = new ListNode(19);
        ListNode a6 = new ListNode(21);
        ListNode a7 = new ListNode(33);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a2.next = null;
        Reverse_Nodes_in_kGroup t = new Reverse_Nodes_in_kGroup();
        // t.reverse(a2,a5);
        ListNode ans = t.reverseKGroup1(a1,2);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
