package linked_list.Sort_List;
import tools.ListNode;

/**
 * Created by PennyLiu on 2017/8/18. 
 * leecode: Sort List
 * 思路：归并排序
 */
public class Sort_List {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static class Linklist
    {
        private ListNode first; // 定义一个头结点
        private ListNode now;// 节点的位置

        public Linklist()
        {
            this.first = null;
            now = null;
        }

        // 插入一个头节点
        public void addFirstNode(int data)
        {
            first = new ListNode(data);
            if (now == null) {
                now = first;
            }
        }

        public void addNode(int data)
        {
            now.next = new ListNode(data);
            now = now.next;
        }
    }

    public ListNode sortList(ListNode head) {  //归并排序
        if(head==null || head.next==null) {
            return head;
        }
        int sum = 0;
        ListNode cur = head;
        while(cur != null)
        {
            sum++;
            cur = cur.next;
        }

        ListNode ans = new ListNode(0);  //后面的所有排序都是在ans节点后进行操作，所以每一次排序完，ans都相当于 已经排好序的辅助数组
        ans.next = head;
        ListNode left, right, tail;
        for(int sz=1; sz < sum; sz += sz)
        {
            cur = ans.next;    //相当于辅助数组的开始
            tail = ans;
            while(cur!=null)  //需要三个指针表示位置关系
            {
                left = cur;
                right = split(left, sz);
                cur = split(right, sz);
                tail = merge(left, right, tail);
            }
        }
        return ans.next;
    }

    private ListNode split(ListNode cur, int sz)
    {
        ListNode end = cur;
        while((sz--!=1) && (end!=null))   //边界条件不会写end.next==null
        {
            end = end.next;
        }
        if(end == null) {
            return null;
        }
        ListNode tmp = end.next;  //真正结尾的是当前的节点，但是要返回的是下一个节点值，所以要两个node
        end.next = null;
        return tmp;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode now)
    {
        while(left!= null || right!= null)
        {

            if(left == null)
            {
                now.next = right;
                right = right.next;
            }
            else if(right == null)
            {
                now.next = left;
                left = left.next;
            }
            else if(left.val <= right.val)
            {
                now.next = left;
                left = left.next;
            }
            else
            {
                now.next = right;
                right = right.next;
            }
            now = now.next;
        }
        return now;
    }



    public static void main(String[] algs)
    {
        Linklist citations = new Linklist();
        citations.addFirstNode(5);
        citations.addNode(8);
        citations.addNode(4);
        citations.addNode(3);
        citations.addNode(7);
        Sort_List t = new Sort_List();
        ListNode ans = t.sortList(citations.first);
        while(ans != null)
        {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}