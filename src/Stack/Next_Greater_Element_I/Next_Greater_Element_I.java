package Stack.Next_Greater_Element_I;

import javafx.util.Pair;

import java.util.*;

public class Next_Greater_Element_I {
    public static void main(String[] args) {
        SolutionII a = new SolutionII();
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = a.dailyTemperatures(nums);
        System.out.println(Arrays.toString(ans));
    }
}

// I
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[nums1.length];
        int length2 = nums2.length - 1;
        int index = 0;
        stack.push(nums2[index]);
        index++;
        while (index <= length2) {
            int top = nums2[index];
            if (top < stack.peek()) {
                stack.push(top);
            } else {
                while (!stack.empty() && stack.peek() < top) {
                    map.put(stack.pop(), top);
                }
                stack.push(top);
            }
            index++;
        }
        while (!stack.empty()) {
            map.put(stack.pop(),-1);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}



class SolutionI {
    public int nextGreaterElement(int n) {
        // 从后往前获取每一位的值
        char[] number = (n+"").toCharArray();

        int valley = -1;
        // 从右到左找到第一个山谷
        for (int i = number.length - 1; i > 0; i--) {
            if (number[i-1] < number[i]) {
                valley = i-1;
                break;
            }
        }

        if (valley == -1) {
            return -1;
        }

        // 找出最小的比山谷大的数
        int small = valley + 1;
        for (int i = small + 1; i < number.length; i++) {
            if (number[i] > number[valley] && number[i] <= number[small]) {
                small = i;
            }
        }

        //交换位置
        char temp = number[valley];
        number[valley] = number[small];
        number[small] = temp;

        //对后面的数排序
        Arrays.sort(number,valley+1,number.length);
        long ans = Long.parseLong(new String(number));
        return (ans <= Integer.MAX_VALUE) ? (int) ans : -1;
    }
}

class SolutionII {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length, next[] = new int[n];
        Arrays.fill(next,0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int t = T[i];
            while (!stack.empty() && T[stack.peek()] < t) {
                next[stack.peek()] = i - stack.pop();
            }
            if (i < n) {
                stack.push(i);
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        //map.putIfAbsent(map.getOrDefault(x,0) + 1);
        return next;
    }
}