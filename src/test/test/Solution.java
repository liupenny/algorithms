package test;

import tools.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by PennyLiu on 2018/9/4.
 */

class MaxHeap<T extends Comparable>{

    private T[] data;
    private int count;
    private int capacity;

    //两个初始化函数
    public MaxHeap(int capacity){
        // 接口类型变量
        data = (T[]) new Comparable[capacity+1];
        this.capacity = capacity;
        count = 0;
    }

    public MaxHeap(T arr[]){
        capacity = arr.length;
        data = (T[])new Comparable[capacity+1];

        for (int i = 0; i < capacity; i++)
            data[i+1] = arr[i];
        count = arr.length;

        for (int i = count/2 ; i >= 1; i--) {
            ShiftDown(i);
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public int getCount(){
        return count;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public void insert(T item){
        assert count+1 <= capacity;
        data[count+1] = item;
        count++;
        ShiftUp(count);
    }

    public T getMax(){
        assert count>0;
        T ret = data[1];
        swap(1,count);
        ShiftDown(1);
        return ret;
    }
    //辅助函数
    private void ShiftUp(int i){
        while (i > 1 && data[i/2].compareTo(data[i]) < 0){
            swap(i,i/2);
            i /= 2;
        }
    }

    private void ShiftDown(int i){
        while (i*2 <= count) {
            int j = i*2;
            if(j + 1 <= count && data[j+1].compareTo(data[j]) > 0)
                j++;
            if(data[i].compareTo(data[j]) >= 0)
                break;
            swap(i,j);
            i = j;
        }
    }
}

class Solution{
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val)
                    return -1;
                else if(o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        for (ListNode node:lists) {
            if(node!=null)
                priorityQueue.add(node);
        }

        while (!priorityQueue.isEmpty()){
            ListNode tmp = priorityQueue.poll();
            ret.next = tmp;
            ret = tmp;
            tmp = tmp.next;
            if (tmp!=null)
                priorityQueue.add(tmp);
        }
        return dummy.next;
    }


}

// 会导致超出内存限制
class Solution1{
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val)
                    return -1;
                else if(o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;

        for (ListNode tmp: lists) {
            while (tmp!=null) {
                priorityQueue.add(tmp);
                tmp = tmp.next;
            }
        }
        while (!priorityQueue.isEmpty()){
            ret.next = priorityQueue.poll();
            ret = ret.next;
        }
        return dummy.next;
    }

}

