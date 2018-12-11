package array.MediumOfFlow;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/11
 */
public class Solution {
    PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
    int index = 0;
    int tmp;
    /**
     * @Author liu Ruiqing
     * @Description  奇数时向小根堆插入，偶数时向大根堆插入
     * @Date 2018/12/11
     * @Param [num]
     * @return void
     **/
    public void Insert(Integer num) {
        index++;
        if ((index&1) == 0) {
            smallHeap.offer(num);
            tmp = smallHeap.poll();
            bigHeap.offer(tmp);
        } else {
            bigHeap.offer(num);
            tmp = bigHeap.poll();
            smallHeap.offer(tmp);
        }
    }

    public Double GetMedian() {
        if((index&1)==1){
            return (double)smallHeap.peek();
        } else {
            double res = ((double)smallHeap.peek() + (double)bigHeap.peek()) / 2;
            return res;
        }
    }

    public static void main(String[] args) {
        int[] a = {5,2,3,4,1,6,7,0,8};
        Solution s = new Solution();
        for (int num : a) {
            s.Insert(num);
            System.out.println(s.GetMedian());
        }
    }
}
