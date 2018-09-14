package String.Smallest_Range;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by PennyLiu on 2018/7/4.
 */

public class Solution{
    //暴力遍历每个数对，找出最小的
    public int[] smallestRange_bruce(List<List<Integer>> nums) {
        int minx = 0, miny = Integer.MAX_VALUE;
        // 找出第一个候选值
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
             //找第二个候选值,第i行之后
                for (int k = i; k < nums.size(); k++) {
                    // 如果是第二个候选值从第i行开始，l要跟j一样
                    for (int l = (k == i) ? j : 0; l < nums.get(k).size(); l++) {
                        // min和max组成候选range
                        int min = Math.min(nums.get(i).get(j), nums.get(k).get(l));
                        int max = Math.max(nums.get(i).get(j), nums.get(k).get(l));
                        // 遍历去查询是否满足条件
                        int n,m;
                        for (m = 0; m < nums.size(); m++) {
                            for (n = 0; n < nums.get(m).size(); n++) {
                                // 有一个满足条件
                                if(nums.get(m).get(n) >= min && nums.get(m).get(n) <= max) {
                                    break;
                                }
                            }
                            // 如果这一行没有满足条件的就证明这个range不符合条件，直接跳出
                            if(n == nums.get(m).size()) {
                                break;
                            }
                        }
                        // 到最后一行都满足条件
                        if(m == nums.size())
                        {
                            if(miny - minx > max - min || (miny - minx == max - min && minx > min)) {
                                minx = min;
                            }
                                miny = max;
                        }
                    }
                }
            }
        }
        return new int[]{minx, miny};
    }

    // 对上面的解法用二分查找进行优化，找一个最小的大于min的数
    // 如果返回的下标是这一行的个数，证明所有数都小于min，就不符合条件
    // 如果所有的数都>=min，我们会得到第一个数的角标，但如果第一个数大于max，那也不符合条件
    public int[] smallestRange_bs(List<List<Integer>> nums) {
        int minx = 0, miny = Integer.MAX_VALUE;
        // 找出第一个候选值
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                //找第二个候选值,第i行之后
                for (int k = i; k < nums.size(); k++) {
                    // 如果是第二个候选值从第i行开始，l要跟j一样
                    for (int l = (k == i) ? j : 0; l < nums.get(k).size(); l++) {
                        // min和max组成候选range
                        int min = Math.min(nums.get(i).get(j), nums.get(k).get(l));
                        int max = Math.max(nums.get(i).get(j), nums.get(k).get(l));
                        // 遍历去查询是否满足条件
                        int n,m;
                        for (m = 0; m < nums.size(); m++) {
                            // 如果存在这个数，就直接返回位置；
                            // 不存在，返回 -插入点-1；插入点即第一个比他大的数的索引
                            // 所有数都小于min -- (-a.length-1)
                            // 所有数都大于min -- (-0-1) = -1
                            n = Collections.binarySearch(nums.get(m), min);
                            if(n < 0) {
                                n = -1 - n;
                            }
                            if(n == nums.get(m).size() || nums.get(m).get(n) < min || nums.get(m).get(n) > max) {
                                break;
                            }
                        }
                        // 到最后一行都满足条件
                        if(m == nums.size())
                        {
                            if(miny - minx > max - min || (miny - minx == max - min && minx > min)) {
                                minx = min;
                            }
                            miny = max;
                        }
                    }
                }
            }
        }
        return new int[]{minx, miny};
    }

    public int[] smallestRange_pointers(List<List<Integer>> nums) {
        int minx = 0, miny = Integer.MAX_VALUE;
        int[] next = new int[nums.size()];
        boolean nolistOver = true;

        // 前面两个循环行和列的并不是要完全循环完，在中间会弹出。只是起到继续判断的作用，所以用while循环也可以
//        for (int i = 0; i < nums.size() && nolistOver; i++) {
//            for (int j = 0; j < nums.get(i).size() && nolistOver; j++) {
        while (nolistOver == true)
        {
                // 这里初始化最小的那一行和最大的一行都是0，
                int min_i = 0, max_i = 0;
                // 遍历k行，找出当前的最小值和最大值
                for (int k = 0; k < nums.size(); k++) {
                    if(nums.get(min_i).get(next[min_i]) > nums.get(k).get(next[k])) {
                        min_i = k;
                    }
                    if(nums.get(max_i).get(next[max_i]) < nums.get(k).get(next[k])) {
                        max_i = k;
                    }
                }
                //更新答案,这时候就没有minx = min_i,miny=max_i的情况了，因为即使有，前面也保存过了
                if(miny - minx > nums.get(max_i).get(next[max_i]) - nums.get(min_i).get(next[min_i])){
                    miny = nums.get(max_i).get(next[max_i]);
                    minx = nums.get(min_i).get(next[min_i]);
                }

                // 最小值后移，判断是否到结尾
                next[min_i]++;
                if(next[min_i] == nums.get(min_i).size()) {
                    nolistOver = false;
                }
            }
        //}
        return new int[]{minx, miny};
    }

    public int[] smallestRange_queue(List<List<Integer>> nums) {
        int minx= 0, miny = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        //移动后的位置
        int[] next = new int[nums.size()];
        boolean nolistOver = true;
        //小根堆，存储所有行号，比较方式是比较那一行的next位置的值。不断弹出最小值所在的那一行
        PriorityQueue<Integer> min_queue = new PriorityQueue<>((i,j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));

        for (int i = 0; i < nums.size(); i++) {
            // 把list的所有行号放进去
            min_queue.offer(i);
            // 找出第一列中最大的数
            max = Math.max(max, nums.get(i).get(0));
        }

        // 一直运行知道有一列走到最后
        while (nolistOver == true)
        {
            // 最小的数
            int min_i = min_queue.poll();
            if(miny - minx > max - nums.get(min_i).get(next[min_i]))
            {
                minx = nums.get(min_i).get(next[min_i]);
                miny = max;
            }
            next[min_i]++;
            if(next[min_i] == nums.get(min_i).size()){
                nolistOver = false;
                break;
            }

            // 再把这一行放回去
            min_queue.offer(min_i);
            // 因为max记录最大值，每次更新的是最小值，所以最小值更新了并不会导致最大值丢失
            // 所以每次更新最小值的时候判断当前位置是否是最大值即可
            max = Math.max(max,nums.get(min_i).get(next[min_i]));
        }

        return new int[]{minx,miny};
    }

    public int[] smallestRange_try(List<List<Integer>> nums) {
        if(nums == null || nums.size() == 0) {
            return new int[]{0, 0};
        }

        // 这里不要写minx=Integer.MIN_VALUE,因为miny-minx的时候会超出范围
        int minx = 0, miny = Integer.MAX_VALUE;
        int min = 0, max = Integer.MIN_VALUE;
        int[] next = new int[nums.size()];
        boolean nolistOver = true;
        PriorityQueue<Integer> min_queue = new PriorityQueue<>( (i,j) -> nums.get(i).get(next[i]) - nums.get(j).get(next[j]));

        for (int i = 0; i < nums.size(); i++) {
            min_queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }

        while (nolistOver)
        {
            min = min_queue.poll();
            if(max - nums.get(min).get(next[min]) < miny - minx)
            {
                minx = nums.get(min).get(next[min]);
                miny = max;
            }

            next[min]++;
            if(next[min] == nums.get(min).size())
            {
                nolistOver = false;
                break;
            }
            // 再把这一行放回去
            min_queue.offer(min);
            // 所以每次更新最小值的时候判断当前位置是否是最大值即可
            max = Math.max(max,nums.get(min).get(next[min]));
        }
        return new int[]{minx,miny};
    }

        public static void main(String[] args)
    {
        Solution s = new Solution();
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(4,10,15,24,26), Arrays.asList(0,9,12,20), Arrays.asList(5,18,22,30));
        int[] ans = s.smallestRange_try(lists);
        System.out.println(ans[0] + " " + ans[1]);
    }
}