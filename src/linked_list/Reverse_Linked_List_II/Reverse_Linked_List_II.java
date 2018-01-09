package linked_list.Reverse_Linked_List_II;
import tools.*;
import tools.Sort_List;

/**
 * Created by PennyLiu on 2017/10/12.
 * 92. Reverse Linked List II
 * 题意：题意是对m-n这一段进行反转。
 * reverseBetween1:第m-1个数的位置不变，使用尾插法，每次把后面的数字放在第m-1个数后面（头插法：在节点前面插入节点/尾插法：在节点后插入）
 * reverseBetween2:使用两个指针将m-n这一段的连接顺序逆序，然后将逆序好的结果接到原来的串上
 */
public class Reverse_Linked_List_II {
    public ListNode reverseBetween1(ListNode head, int m, int n) { //第m-1个数的位置不变，使用尾插法，每次把后面的数字放在第m-1个数后面
        if(head==null)
            return head;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode cur = newhead;

        for (int i=0;i<m-1;i++)   //这里注意一下，结点个数是从1开始算，但1位置是链表开头，每次交换的时候是需要 前 1 2 三个位置的指针
            cur = cur.next;
        ListNode start = cur.next,second = start.next;

        for (int i=m;i<=n;i++)  //反转m-n之间的数，是从第m+1个数开始尾插，所以一共n-m-1次
        {
            start.next = second.next;
            second.next = cur.next;
            cur.next = second;
            second = start.next;
        }
        return newhead.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n)
    {
        if(head==null)
            return head;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode cur = head,precur = newhead;

        ListNode subhead = new ListNode(0);  //作为中间要旋转的那段的辅助变量
        ListNode subtail = new ListNode(0);

        for (int i=1;i<=n;i++)
        {
            ListNode tmp = cur.next;  //先保存下一位
            if(i<m)  //前面这段正常连接
                precur = cur;
            else if(i==m)   //
            {
                subhead.next = cur;
                subtail = cur;
            }
            else if(i>m)
            {
                cur.next = subhead.next;
                subhead.next = cur;
            }
            cur = tmp;
        }
        precur.next = subhead.next;
        subtail.next = cur;
        return newhead.next;
    }

    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
        citations2.addNode(6);
        citations2.addNode(4);
        citations2.addNode(5);
        Reverse_Linked_List_II t = new Reverse_Linked_List_II();
        ListNode ans = t.reverseBetween2(citations2.first,2,4);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
