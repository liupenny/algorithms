import tools.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2017/10/1.
 */
public class test {

    class Heap {
        public List<ListNode> heap;

        private int getLimit() {
            return heap.size() - 1;
        }

        public Heap(ListNode[] lists)
        {
            heap = new ArrayList<ListNode>();
            int i = 0;
            while (i<lists.length)
            {
                if (lists[i]!=null) {
                    heap.add(lists[i]);
                }
                i++;
            }
        }
    }

    public void main(String[] algs)
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
        tools.Sort_List.Linklist citations3 = new tools.Sort_List.Linklist();
        citations2.addFirstNode(0);
        citations2.addNode(11);
        citations2.addNode(12);
        citations2.addNode(15);
        citations2.addNode(19);
        ListNode[] lists = new ListNode[3];
        test t = new test();
        lists[0] = citations1.first;
        lists[1] = citations2.first;
        lists[2] = citations3.first;
        Heap h = new Heap(lists);
        System.out.println(h.getLimit());
    }
}
