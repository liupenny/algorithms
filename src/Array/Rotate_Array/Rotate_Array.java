package Array.Rotate_Array;

/**
 * Created by PennyLiu on 2018/5/31.
 */
public class Rotate_Array {
    // 暴力旋转1
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0)
            return;

        int prev;
        for (int i = 0; i < k; i++) { //轮换k次
            prev = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0 ; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = prev;
        }

        for (int num: nums) {
            System.out.print(num + " ");
        }
    }

    // 暴力旋转2
    public void rotate1(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];  //这种是直接转个圈，也要学习一下
                nums[j] = previous; //记住最后一个，从第一个数开始转圈，想链表
                previous = temp;
            }
        }
    }

    // 使用额外数组
    public void rotate3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return;

        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) { //这里是对旧数组的循环
            num[(i + k) % nums.length] = nums[i];  //这个取模关系对照：
        }                                          // 1 2 3 4 5 6 7
        for (int i = 0; i < nums.length; i++) {    // 5 6 7 1 2 3 4
            nums[i] = num[i];                      // 即，因为原来后面的k个数要挪到前面去，所以原来的数要每个都往后移k位
        }
    }

    // Cyclic Replacements
    public void rotate_Cyclic(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    //  Using Reverse先翻转前n-k个，再反转后面k个，在整体翻转
    public void rotate3_reverse(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return;

        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        Rotate_Array t = new Rotate_Array();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        t.rotate_Cyclic(nums, k);
    }
}
