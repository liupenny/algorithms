package linked_list.Intersection_of_Two_Linked_Lists;
import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/17.
 * 160. Intersection of Two Linked Lists
 * getIntersectionNode1：根据链表长度来做的
 * getIntersectionNode2：不用知道链表长度，借助环的思想。因为两个指针走的距离一定一样长，此时就会相遇。所以两个指针都是两条链表都走到末尾的时候相等。
 * 如果没有交点：两个指针都走到链表的末尾，都等于null。
 * 如果有交点：正好走到交点处
 */
public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lengthA = 0, lengthB = 0;
        ListNode listA = headA, listB = headB;

        // 先计算出两个链表的长度
        for (ListNode tmpA = headA; tmpA != null; lengthA++, tmpA = tmpA.next);
        for (ListNode tmpB = headB; tmpB != null; lengthB++, tmpB = tmpB.next);

        // 长的先走一点，让两个表长度相等，然后两个表同时走
        if(lengthA >= lengthB)
        {
            for (int i = lengthA-lengthB; i>0; i--)
                listA = listA.next;
        }
        else
        {
            for (int i = lengthB-lengthA; i>0; i--)
                listB = listB.next;
        }

        // 判断对象是否相等，使用 == 即可
        while (listA!=listB && listA!=null && listB!=null)
        {
            listA = listA.next;
            listB = listB.next;
        }

        if(listA==null || listB==null)
            return null;
        else
            return listA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode tmpA = headA, tmpB = headB;

        while (tmpA!=tmpB)
        {
            tmpA = tmpA != null ? tmpA.next : headB;
            tmpB = tmpB != null ? tmpB.next : headA;
        }

        return tmpA;
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
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(7);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a3.next = null;
        b1.next = b2;
        //b2.next = null;
        b2.next = a3;
        Intersection_of_Two_Linked_Lists t = new Intersection_of_Two_Linked_Lists();
        // t.reverse(a2,a5);
        ListNode ans = t.getIntersectionNode1(a1,b1);
        if(ans == null)
            System.out.println("null");
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
