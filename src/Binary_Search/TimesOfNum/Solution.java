package Binary_Search.TimesOfNum;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/28
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int number = 0;
        if(array == null && array.length == 0) {
            return 0;
        }
        int first = getFirst(array, k);
        int second = getSecond(array, k);
        if (first == -1 && second != -1) {
            number = second - first + 1;
        }
        return number;
    }

    public int getFirst(int[] array, int k) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (array[mid] == k) {
                if (mid == 0 || array[mid-1] < k) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else if (array[mid] > k){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int getSecond(int[] array, int k) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (array[mid] == k) {
                if (mid == array.length-1 || array[mid+1] > k) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else if (array[mid] > k){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,3,3,3,3,4,5};
        int k = 3;
        s.GetNumberOfK(a,k);

    }
}