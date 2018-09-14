package heap.Find_K_Pairs_with_Smallest_Sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by PennyLiu on 2017/10/22.
 *
 */
public class Find_K_Pairs_with_Smallest_Sums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();  //优先队列自动重排
        List<int[]> ans = new ArrayList<int[]>();
        if(nums1.length==0 || nums2.length==0 || k==0) {
            return ans;  //预处理
        }

        for (int i=0; i<nums2.length && i<k; i++) {
            pq.add(new Pair(0, i, nums1[0] + nums2[i]));  //这里并不是说一次就把所有最小的数对添加进去，而是先添加一些，但这里面一定能添加全局最小（num1[0]+nums2[0]）,然后每次取出当前最小再添加进去，队列会重排
        }
        for (int i=0; i<Math.min(k,nums1.length*nums2.length);i++)
        {
            Pair p = pq.poll();
            ans.add(new int[]{nums1[p.x1],nums2[p.x2]});
            if(p.x1== nums1.length-1) {
                continue;  //x到了最后一排，代表着这一行都添加完了
            }
            pq.add(new Pair(p.x1+1,p.x2,nums1[p.x1+1]+nums2[p.x2]));
        }
        return ans;
    }

    class Pair implements Comparable<Pair>
    {
        int x1,x2,sum;

        public Pair(int x1, int x2, int sum)
        {
            this.sum = sum;
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public int compareTo(Pair that)
        {
            return this.sum - that.sum;
        }
    }
}
