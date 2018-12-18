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
        int[] a = {1,0,0,1,0,0,1,0};
        contest t = new contest();
        System.out.println(Arrays.toString(prisonAfterNDays(a,1000000000)));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) {
            return cells;
        }
        int before = 0, tmp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < cells.length; j++) {
                tmp = cells[j];
                if (j == 0 || j == cells.length - 1) {
                    cells[j] = 0;
                } else {
                    cells[j] = ~(before ^ cells[j + 1]) & 1;
                }
                before = tmp;
            }
        }
        return cells;
    }

    boolean[] used;
    public boolean canReorderDoubled(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        Arrays.sort(A);
        used = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            if (!used[i]) {
                int pos = 0;
                if (A[i] <= 0) {
                    pos = rightPos(A, A[i] / 2);
                } else {
                    pos = rightPos(A, A[i] * 2);
                }
                if (pos < 0) {
                    return false;
                } else {
                    used[pos] = true;
                }
            }
        }
        return true;
    }

    public int rightPos(int[] A, int k) {
        int firstPos = first(A,k);
        int lastPos = last(A,k);
        if (firstPos == -1 && lastPos == -1) {
            return -1;
        } else if (firstPos == -1 || lastPos == -1) {
            return firstPos == -1 ? lastPos : firstPos;
        } else {
            for (int i = firstPos; i <= lastPos; i++) {
                if(!used[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    public int first(int[] A, int k) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = l + ((r - l)>>1);
            if (A[mid] < k) {
                l = mid + 1;
            } else if (A[mid] > k) {
                r = mid - 1;
            } else {
                if (mid == 0 || (A[mid-1] != k)) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public int last(int[] A, int k) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = l + ((r - l)>>1);
            if (A[mid] < k) {
                l = mid + 1;
            } else if (A[mid] > k) {
                r = mid - 1;
            } else {
                if (mid == A.length - 1 || (A[mid+1] != k)) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    int[] ord;
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length <= 1) {
            return true;
        }
        ord = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            ord[c-'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];
            if (isBigger(word1,word2)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBigger(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        for (int i = 0; i < len1; i++) {
            if (i < len2) {
                if (ord[word1.charAt(i) - 'a'] < ord[word2.charAt(i) - 'a']) {
                    return false;
                } else if (ord[word1.charAt(i) - 'a'] > ord[word2.charAt(i) - 'a']) {
                    return true;
                } else {
                    continue;
                }
            } else {
                return true;
            }
        }
        return false;
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
