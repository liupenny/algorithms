package linked_list.Swap_Nodes_in_Pairs;
import tools.ListNode;

/**
 * Created by PennyLiu on 2017/10/9.
 * 24. Swap Nodes in Pairs
 * 非递归(4ms)：swapPairs1
 * 递归(5):swapPairs2
 */
public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs1(ListNode head) {
        if(head==null || head.next==null)  // 排除了0个和1个元素的情况
            return head;
        ListNode first,second;
        ListNode newhead = new ListNode(0), current = newhead;
        newhead.next = head;
        while (current.next!=null && current.next.next!=null)  //按照之前从head开始会忽略两个元素的情况，所以从head之前就是newhead开始改
        {
            first = current.next;  //要互换的第一个元素
            second = current.next.next; //要互换的第二个元素
            first.next = second.next;
            second.next = first;
            current.next = second;
            current = first;
        }
        return newhead.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head==null || head.next==null)      // 没有节点/只有一个节点:不用交换，直接返回它即可。
            return head;
        ListNode tmp = head.next;
        head.next = swapPairs2(tmp.next);  //第三个节点当参数
        tmp.next = head;
        return tmp;  //返回当前参数，即上一轮中第一个节点的下一个节点
    }

    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations2 = new tools.Sort_List.Linklist();
        citations2.addFirstNode(1);
        citations2.addNode(2);
//        citations2.addNode(6);
//        citations2.addNode(4);
//        citations2.addNode(5);
        Swap_Nodes_in_Pairs t = new Swap_Nodes_in_Pairs();
        ListNode ans = t.swapPairs2(citations2.first);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }
}
