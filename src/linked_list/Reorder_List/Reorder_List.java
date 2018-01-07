import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/19.
 * 143. Reorder List
 * 1:Find the middle of the list
 * 2:Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
 * 3:Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
 */
public class Reorder_List {
    public void reorderList(ListNode head) {
        //Find the middle of the list
        if(head == null || head.next == null)  return;
        ListNode fast = head,slow = head;
        while (fast.next != null && fast.next.next != null)  //如果这样判断，是取得了上中位数，可以用下面的方法反转/否则是下中位数，用新加一个null指针的方法反转
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4,借助Reverse Linked List II中的尾插法
        ListNode mid = slow, help = slow.next, cur = help.next;
        while (help.next != null)
        {
            help.next = cur.next;
            cur.next = mid.next;
            mid.next = cur;
            cur = help.next;
        }

        //Start reorder one by one,参考答案的写法，很精简
        ListNode p1=head;
        ListNode p2=slow.next;
        while(p1!=slow){
            slow.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=slow.next;
        }

    }

    public static void main(String[] algs)
    {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(6);
//        ListNode a5 = new ListNode(7);
//        ListNode a6 = new ListNode(8);
//        ListNode a7 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
//        a4.next = a5;
//        a5.next = a6;
//        a6.next = a7;
        a4.next = null;
        Reorder_List t = new Reorder_List();
        t.reorderList(a1);
        while (a1!=null)
        {
            System.out.println(a1.val);
            a1 =a1.next;
        }
    }
}
