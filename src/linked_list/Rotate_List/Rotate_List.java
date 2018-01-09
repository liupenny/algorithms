package linked_list.Rotate_List;
import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/19.
 * 61. Rotate List
 * 思路：k可能是大于链表长度的，所以先获取链表长度，再进行取模处理
 */
public class Rotate_List {
    public ListNode rotateRight1(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        int len = 1;
        for(; fast.next != null ; len++) //获取链表长度len
            fast = fast.next;
        for(int j = len-k%len; j >1 ; j--)  //k可能是负数，所以直接取模会得到负数，所以用减去的方法得知前面多少个应该向后移
            slow = slow.next;

        fast.next = head;  //不用多余的变量，直接移动
        head = slow.next;
        slow.next = null;
        return head;
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }


    public static void main(String[] algs)
    {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
//        ListNode a4 = new ListNode(6);
//        ListNode a5 = new ListNode(7);
//        ListNode a6 = new ListNode(8);
//        ListNode a7 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;
//        a5.next = a6;
//        a6.next = a7;
        a3.next = null;
        Rotate_List t = new Rotate_List();
        ListNode ans = t.rotateRight1(a1,4);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
