package heap.MaxQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/13
 */
public class MaxQueue {
    class InternalData{
        int key;
        int index;
        public InternalData(int key, int index){
            this.key = key;
            this.index = index;
        }
    }

    private Deque<InternalData> queue = new LinkedList<>();
    private Deque<InternalData> maxQueue = new LinkedList<>();
    private int currentIndex = 0;

    public void offer(int key) {
        while (!maxQueue.isEmpty() && maxQueue.peekLast().key <= key) {
            maxQueue.pollLast();
        }
        InternalData data = new InternalData(key,currentIndex);
        maxQueue.offerLast(data);
        queue.offerLast(data);
        currentIndex++;
    }

    // 保存队列最大值的这个队列一直保存的都是当前数字往后中的可能的最大值，所以第一个数字保存的就是截止目前的最大值
    // 当前面的元素要弹出时：如果包含在最大队列中，那最大队列也要弹出这个值
    public Integer poll() {
        if (maxQueue.isEmpty()) {
            return null;
        }
        if (maxQueue.peekFirst().index == queue.peekFirst().index) {
            maxQueue.pollFirst();
        }
        return queue.pollFirst().key;
    }

    public Integer max(){
        if (maxQueue.isEmpty()) {
            return -1;
        } else {
            return maxQueue.peekFirst().key;
        }
    }
}

class t {
    public static void main(String[] args) {
        MaxQueue a = new MaxQueue();
        int[] arr = {1,5,2,4,7,8};
        for (int i = 0; i < arr.length; i++) {
            a.offer(arr[i]);
            System.out.println(a.max());
//            if((i%2) == 1) {
//                System.out.println("弹出" + a.poll() + "; 此时最大值是"+ a.max());
//            }
        }
    }
}