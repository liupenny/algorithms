import tools.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by PennyLiu on 2017/10/17.
 * k路归并，使用堆（heap）来实现
 */
public class Merge_k_Sorted_Lists {
    class Heap
    {
        public List<ListNode> heap;

        private int getLimit()
        {
            return heap.size() - 1;  //第0个节点没有用
        }

        public Heap(ListNode[] lists)
        {
            heap = new ArrayList<ListNode>();
            heap.add(new ListNode(0));
            int i = 0;
            while (i<lists.length)
            {
                if (lists[i]!=null)
                    heap.add(lists[i]);
                i++;
            }
        }


        public void heapAdjust(int n,int m)
        {
            for(int i=2*n; i<=m; i*=2)
            {
                if (i<m && heap.get(i).val > heap.get(i+1).val)
                    i++;
                if (heap.get(i).val >= heap.get(n).val)
                    break;
                //exch(heap.get(i),heap.get(n));
                {
                    ListNode tmp = heap.get(i);
                    heap.set(i,heap.get(n));
                    heap.set(n,tmp);
                }
                n = i;
            }
        }

        public void creatMinHeap() {
            for (int i = getLimit() / 2; i > 0; --i)
                heapAdjust(i, getLimit());
        }

        public ListNode getsmall()
        {
            if(heap.size() == 1 || heap.get(1)==null) return null;
            ListNode ans ;
            ans = heap.get(1);
            if(heap.get(1).next!=null)
                heap.set(1,heap.get(1).next);  //java要求函数返回值只能给变量，所以前面的heap.get(1)是错的。
            else
            {
                ListNode tmp = heap.get(1);
                heap.set(1,heap.get(heap.size()-1));
                heap.set(heap.size()-1,tmp);
                heap.remove(heap.size()-1);
            }
            if(heap.size()!=1)
                heapAdjust(1,getLimit());
            return ans;
        }

        public int getlen() {
            return heap.size() - 1;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        Heap h = new Heap(lists);
        h.creatMinHeap();
        ListNode ans = new  ListNode(0), newhead = ans;
        while (h.getlen()!=0)
        {
            ListNode tmp = h.getsmall();
            ans.next = tmp;
            ans = tmp;
        }
        return newhead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }



    public static void main(String[] algs)
    {
        tools.Sort_List.Linklist citations1 = new tools.Sort_List.Linklist();
        citations1.addFirstNode(1);
        citations1.addNode(3);
//        citations1.addNode(5);
//        citations1.addNode(7);
//        citations1.addNode(9);
        tools.Sort_List.Linklist citations2 = new tools.Sort_List.Linklist();
        citations2.addFirstNode(2);
        citations2.addNode(4);
//        citations2.addNode(6);
//        citations2.addNode(8);
//        citations2.addNode(10);
        tools.Sort_List.Linklist citations3 = new tools.Sort_List.Linklist();
        citations3.addFirstNode(0);
//        citations3.addNode(11);
//        citations3.addNode(12);
//        citations3.addNode(15);
//        citations3.addNode(19);
        Merge_k_Sorted_Lists t = new Merge_k_Sorted_Lists();
        ListNode[] lists = new ListNode[3];
        lists[0] = citations1.first;
        lists[1] = citations2.first;
        lists[2] = citations3.first;
        ListNode ans = t.mergeKLists2(lists);
        while (ans!=null)
        {
            System.out.println(ans.val);
            ans =ans.next;
        }
    }

}
