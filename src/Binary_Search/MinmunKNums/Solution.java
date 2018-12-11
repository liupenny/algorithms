package Binary_Search.MinmunKNums;

import java.util.ArrayList;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/11
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (input == null || input.length <= 0 || k <= 0 || input.length < k) {
            return ans;
        }

        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k-1) {
            if (index == k) {
                break;
            } else if (index > k -1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(input, start, end);
        }
        for (int i = 0; i < k; i++) {
            ans.add(input[i]);
        }
        return ans;
    }

    // 修改了数组中的元素
    public int partition(int[] input, int start, int end) {
        int index = (int)(Math.random()*(end - start + 1));
        swap(input, start, index);
        int pivot = input[start];
        while (start < end) {
            while (start < end && input[end] >= pivot) {
                end--;
            }
            input[start] = input[end];
            while (start < end && input[start] <= pivot) {
                start++;
            }
            input[end] = input[start];
        }
        input[start] = pivot;
        return start;
    }

    private void swap(int[] input, int start, int index) {
        int tmp = input[start];
        input[start] = input[index];
        input[index] = tmp;
    }

    public int partition1(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    //如果不能修改元素，采用堆

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {4,5,1,6,2,7,3,8};
        System.out.println(s.GetLeastNumbers_Solution(input,4));
    }
}
