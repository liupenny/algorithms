package linked_list.Merge_Two_Sorted_Lists;
import tools.*;

/**
 * Created by PennyLiu on 2017/10/9.
 * 21. Merge Two Sorted Lists
 * 非递归(20ms)：mergeTwoLists1
 * 递归(19ms)：mergeTwoLists2
 */
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null || l2== null)
            return l1==null?l2:l1;
        ListNode newhead = new ListNode(0),tmp = newhead; // 声明newhead要新建一个节点，不能给成l1或者l2.否则会循环进去
        while (l1!=null && l2!=null)
        {
            if (l1.val<=l2.val)
            {
                newhead.next = l1;
                l1 = l1.next;
            }
            else
            {
                newhead.next = l2;
                l2 = l2.next;
            }
            newhead = newhead.next;
        }
        newhead.next = l1!=null?l1:l2;  // 这里直接赋值就行，不用再循环找下去了
        return tmp.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null || l2== null)
            return l1==null?l2:l1;
        ListNode newhead = new ListNode(0); // 声明newhead要新建一个节点，不能给成l1或者l2.否则会循环进去
        newhead.next = getNext(l1,l2,newhead);
        return newhead.next;
    }

    public ListNode getNext(ListNode l1,ListNode l2, ListNode head)
    {
        if (l1==null || l2==null)
            return l1==null?l2:l1;
        if (l1.val<=l2.val)
        {
            head.next = l1;
            l1 = l1.next;
        }
        else
        {
            head.next = l2;
            l2 = l2.next;
        }
        head = head.next;
        head.next = getNext(l1,l2,head); // 先改变当前顺序，再进行递归操作
        return head;
    }

    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations1 = new tools.Sort_List.Linklist();
        citations1.addFirstNode(1);
        citations1.addNode(3);
        citations1.addNode(5);
        citations1.addNode(7);
        citations1.addNode(9);
        tools.Sort_List.Linklist citations2 = new tools.Sort_List.Linklist();
        citations2.addFirstNode(2);
        citations2.addNode(4);
        citations2.addNode(6);
        citations2.addNode(8);
        citations2.addNode(10);
        Merge_Two_Sorted_Lists t = new Merge_Two_Sorted_Lists();
        ListNode ans = t.mergeTwoLists2(citations1.first,citations2.first);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
