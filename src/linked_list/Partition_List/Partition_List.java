package linked_list.Partition_List;
import tools.*;
import tools.Sort_List;

/**
 * Created by PennyLiu on 2017/10/15.
 * 86. Partition List
 * 思路：设定两个指针大、小。在遍历链表的时候将大于x和小于x的链接在大小链表上，然后将小链表的尾链接大链表的头
 */
public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        if (head==null) {
            return null;
        }
        ListNode small = new ListNode(0),bigger = new ListNode(0);
        ListNode smallhead = small, biggerhead = bigger;
        while (head!=null)
        {
            if(head.val<x)
            {
                small.next = head;
                small = small.next;
            }
            else
            {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        bigger.next = null;
        small.next = biggerhead.next;
        return smallhead.next;
    }

    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new Sort_List.Linklist();
        citations2.addFirstNode(1);
//        citations2.addNode(1);
//        citations2.addNode(4);
//        citations2.addNode(4);
//        citations2.addNode(5);
        Partition_List t = new Partition_List();
        ListNode ans = t.partition(citations2.first,0);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
