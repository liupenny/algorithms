package linked_list.Reverse_Linked_List;
import tools.ListNode;
import tools.Sort_List;

/**
 * Created by PennyLiu on 2017/10/5.
 * 206. Reverse Linked List
 * 思路：迭代版本（reverseList1）:只是改变指针的方向，而不新建多个节点。
 *      递归版本（reverseList2）:思路同上，先保存下一个节点，对当前节点的连接顺序进行处理。再处理后续节点
 */
public class Reverse_Linked_List {
    public ListNode reverseList1(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode tail = null;  //只是声明并没有新建，所以不会有额外的空间复杂度
        while (head!=null)
        {
            ListNode tmp = head.next;  //如果令tmp = head,再改变tmp.next的话，此时head.next也会改变，所以先保存head.next去改变head
            head.next = tail;
            tail = head;
            head = tmp;
        }
        return tail;
    }

    public ListNode reverseList2(ListNode head) {  // 递归版本的是一样的思路，在往下递归之前，先处理当前步骤的，最后到了尾节点，直接返回就行
        if(head==null || head.next==null) {
            return head;
        }
        return next(head,null);
    }

    public ListNode next(ListNode head,ListNode tail)
    {
        if(head==null) {
            return tail;
        }
        ListNode node = head.next;
        head.next = tail;
        return next(node,head);  // 先处理完，返回最后的节点
    }

    public static void main(String[] algs)
    {
        Sort_List.Linklist citations2 = new Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
        citations2.addNode(6);
        citations2.addNode(4);
        citations2.addNode(5);
        Reverse_Linked_List t = new Reverse_Linked_List();
        ListNode ans = t.reverseList2(citations2.first);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
