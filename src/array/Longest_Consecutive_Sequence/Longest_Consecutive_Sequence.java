package array.Longest_Consecutive_Sequence;

import java.util.*;

/**
 * Created by PennyLiu on 2018/5/28.
 */
public class Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int res = 0;

        Iterator<Integer> iterator = numSet.iterator();
        while (iterator.hasNext())  //这样的删除会报并发错误
        {
            int num = iterator.next();
            int len = 1;

            int low = num - 1;
            while (numSet.contains(low)) {
                numSet.remove(low);
                len++;
                low--;
            }

            int high = num + 1;
            while (numSet.contains(high)) {
                numSet.remove(high);
                len++;
                high++;
            }
            res = Math.max(res, len);
        }

        return res;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int res = 0;
        for (int num : numSet) {  //foreach利用的就是iterator去遍历，所以两者的问题是一致的
            if (numSet.contains(num)) {
                int len = 1;
                numSet.remove(num);

                int low = num - 1;
                while (numSet.contains(low)) {
                    numSet.remove(low);
                    len++;
                    low--;
                }

                int high = num + 1;
                while (numSet.contains(high)) {
                    numSet.remove(high);
                    len++;
                    high++;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }

    public int longestConsecutive1(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            hs.add(num[i]);
        }
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            if (hs.contains(num[i])) {
                int count = 1;
                hs.remove(num[i]);

                int low = num[i] - 1;
                while (hs.contains(low)) {
                    hs.remove(low);
                    low--;
                    count++;
                }

                int high = num[i] + 1;

                while (hs.contains(high)) {
                    hs.remove(high);
                    high++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public void test() {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }
        for(String s:a) {
            System.out.println(s);
        }
    }



    public static void main(String[] args) {
        Longest_Consecutive_Sequence t = new Longest_Consecutive_Sequence();
        int[] num = {100, 4, 200, 1, 3, 2};
        //System.out.println(t.longestConsecutive1(num));
        t.test();
    }
}
