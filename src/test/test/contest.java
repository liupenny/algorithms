package test;

import edu.princeton.cs.algs4.Stack;

import java.util.*;

public class contest {
    public static void main(String[] args) {
//        int[] a = {22268,18793,35885,37643,39320,21173,11650,3777,851,11059,1581,28703,19120,32792,33349,18906,19273};
//        contest c = new contest();
//        System.out.println(c.minIncrementForUnique(a));
        test();
    }

    private static void test(){
        int[] pushed = {0,3,3,3};
        System.out.println(largestTimeFromDigits(pushed));
    }

    private static String largestTimeFromDigits(int[] A) {
        StringBuilder sb = new StringBuilder();
        int[] max = new int[4];
        int bigTime = -1;
        int[] time = new int[4];
        for (int i = 0; i < A.length; i++){
            time[0] = A[i];
            for (int j = 0; j < A.length; j++) {
                if (j != i) {
                    time[1] = A[j];
                }
                if (isHourTime(time)) {
                    for (int k = 0; k < A.length; k++) {
                        if (k != i && k != j) {
                            time[2] = A[k];
                            for (int l = 0; l < A.length; l++) {
                                if (l != i && l != j && l != k) {
                                    time[3] = A[l];
                                    if (isMinTime(time)) {
                                        int tmpTime = trans2Time(time);
                                        if (tmpTime > bigTime) {
                                            max = time;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            sb.append(max[i]);
            if (i == 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    private static boolean isHourTime(int[] time) {
        int hour = time[0] * 10 + time[1];
        if (hour < 0 || hour > 23) {
            return false;
        }
        return true;
    }

    private static boolean isMinTime(int[] time) {
        int min = time[2] * 10 + time[3];
        if (min < 0 || min > 59) {
            return false;
        }
        return true;
    }

    private static int trans2Time (int[] time) {

    }

    private int[] bucket = new int[40001];
    public int minIncrementForUnique(int[] A) {
        if(A.length == 0 || A.length == 1) {
            return 0;
        }
        int ans = 0;
        int max = 0, min = 40001;
        for (int i = 0; i < A.length; i++) {
            bucket[A[i]]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                queue.offer(i);
            } else if (bucket[i] > 1) {
                map.put(i,bucket[i]-1);
            }
        }
        for (Integer a:map.keySet()) {
            int times = map.get(a);
            for (int i = 0; i < times; i++) {
                while (queue.peek() < a) {
                    queue.poll();
                }
                ans = ans + (queue.poll() - a);
            }
        }
        return ans;
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) {
            return true;
        } else if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popedIndex=0;
        for(int p:pushed) {
            stack.push(p);
            while (!stack.isEmpty() && stack.peek() == popped[popedIndex]) {
                stack.pop();
                popedIndex++;
            }
        }
        return stack.isEmpty();
    }
    public int minIncrementForUnique1(int[] A) {
        if(A.length == 0 || A.length == 1) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            if(set.isEmpty() || !set.contains(A[i])) {
                set.add(A[i]);
            } else {
                int tmp = A[i];
                while (set.contains(tmp)) {
                    tmp = tmp + 1;
                }
                ans += tmp - A[i];
                set.add(tmp);
            }
        }
        return ans;
    }

}
