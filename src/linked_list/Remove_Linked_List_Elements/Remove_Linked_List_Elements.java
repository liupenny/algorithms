import tools.*;
import tools.Sort_List;

/**
 * Created by PennyLiu on 2017/10/16.
 * 203. Remove Linked List Elements
 * 非递归：removeElements1 要将不等于val的连起来，这样好处理，不然遇到两个连续都等于val的情况不好处理。
 *       removeElements3 将等于val的删去
 * 递归：removeElements2 这里没有多余的空间消耗
 */
public class Remove_Linked_List_Elements {
    public ListNode removeElements1(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode tmp = new ListNode(0), newhead = tmp;
        while (head!=null)
        {
            if(head.val != val)
            {
                tmp.next = head;
                tmp = tmp.next;
            }
            head = head.next;
        }
        tmp.next = null;
        return newhead.next;
    }

    public ListNode removeElements3(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;  //如果当前等于，就看下一个，但是下一个不确定，所以新链表还不能包含下一个（也就不能有pre = pre.next这样的语句）
            } else {
                prev = prev.next;  //在当前值不等于的情况下，可以添加当前值了，
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }

    public ListNode removeElements2(ListNode head, int val) {  //也是从后往前判断
        if(head==null)  return head;
        head.next = removeElements2(head.next,val);
        return head.val==val?head.next:head;

    }
    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(1);
        citations2.addNode(1);
        citations2.addNode(4);
        //citations2.addNode(1);
        Remove_Linked_List_Elements t = new Remove_Linked_List_Elements();
        ListNode ans = t.removeElements2(citations2.first,1);
        if(ans==null)
            System.out.println("null");
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
