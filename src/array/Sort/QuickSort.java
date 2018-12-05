package array.Sort;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/4
 */
public class QuickSort {
    void quickSort(int[] arr) {
        if (arr == null) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int[] p = partition1(arr, low, high);
        //a[lo...p[0] - 1] < a[p[0]] = a[p[0]...p[1]] < a[p[1] + 1 ... high]
        quickSort(arr, low, p[0] - 1);
        quickSort(arr, p[1] + 1, high);
    }

    // 前后交换,返回pivot位置
    public int partition(int[] arr, int low, int high) {
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

    //没法知道pivot位置
    int[] partition1(int[] arr, int low, int high) {
        //not swap pivot, only for numbers
        int index = 2;
        int pivot = arr[index];
        int small = low - 1;
        int cur = low;
        int big = high + 1;
        while (cur < big) {
            if (arr[cur] < pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        return new int[]{small + 1, big - 1};
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] a = {-1,1,1,1,2,1};
        s.quickSort(a);
    }
}
