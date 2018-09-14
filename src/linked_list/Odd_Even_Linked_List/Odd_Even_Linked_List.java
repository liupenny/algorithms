package linked_list.Odd_Even_Linked_List;
import tools.*;
import tools.Sort_List;

/**
 * Created by PennyLiu on 2017/10/9.
 * 328. Odd Even Linked List
 * oddEvenList1:自己写的，用的变量有点多
 * oddEvenList2:看答案的，变量少
 */
public class Odd_Even_Linked_List {
    public ListNode oddEvenList1(ListNode head) {  //
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, second = even;
        head = head.next.next;
        int n =3;
        while (head!=null)
        {
            if(n%2==1)
            {
                odd.next = head;
                odd = odd.next;
            }
            else
            {
                even.next = head;
                even = even.next;
            }
            head = head.next;
            n++;
        }
        odd.next = second;
        even.next = null;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenhead = even;
        while (even!=null && even.next!=null)  // 没有判断even.next.next，是因为可以是null。只要even.next不是Null就行
        {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }

    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
        citations2.addNode(6);
        citations2.addNode(4);
        citations2.addNode(5);
        Odd_Even_Linked_List t = new Odd_Even_Linked_List();
        ListNode ans = t.oddEvenList2(citations2.first);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
