package Array.Global_and_Local_Inversions;

/**
 * Created by PennyLiu on 2018/6/4.
 */
public class Global_and_Local_Inversions {
    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length <= 1) {
            return true;
        }

        return mergeMethod(A);
    }

    // 判断每个数跟角标的偏移
    public boolean indexoffect(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            if(Math.abs((i - array[i])) > 1) {
                return false;
            }
        }
        return true;
    }

    // 判断是否只有局部Inver
    public boolean isAllLocal(int[] array)
    {
        for (int i = 1; i < array.length; i++) {
            if(array[i - 1] == array[i] + 1)
            {
                int tmp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = tmp;
            }
            else if(array[i - 1] != (i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 判断是否有全局Inver
    public boolean hasGlobal(int[] array)
    {
        int max = array[0];
        for (int i = 2; i < array.length; i++) {
            if(array[i] < max) {
                return false;
            }
            max = Math.max(max, array[i]);
        }
        return true;
    }

    // 用归并排序的思想
    public boolean mergeMethod(int[] array)
    {
        int local = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[i] < array[i-1]) {
                local++;
            }
        }
        int global = findGlobalInversion(array);
        System.out.println("global:" + global);
        System.out.println("local:" + local);
        return local == global;
    }

    public int findGlobalInversion(int[] array)
    {
        int len = array.length;
        int[] copy = new int[len];
        System.arraycopy(array, 0, copy, 0, len);
        int num = findGlobalInversion(array, copy, 0, len - 1);
        return num;
    }

    // 求全局逆序对
    public int findGlobalInversion(int[] array, int[] copy, int start, int end)
    {
        if (start == end) {
            return 0;
        }
        //递归调用自己
        int mid = start + (end - start) / 2;
        int leftAns = findGlobalInversion(copy, array, start, mid);
        int rightAns = findGlobalInversion(copy, array, mid + 1, end);

        //归并数组
        int left = start, right = mid + 1, pos = start, ans = 0;
        while (left <= mid && right <= end)
        {
            if(array[left] > array[right])
            {
                copy[pos++] = array[right++];
                ans += mid - left + 1;
            }
            else
            {
                copy[pos++] = array[left++];
            }
        }

        while (left <= mid)
        {
            copy[pos++] = array[left++];
        }

        while (right <= end)
        {
            copy[pos++] = array[right++];
        }

        return leftAns + rightAns + ans;
    }




    public static void main(String[] args) {
        Global_and_Local_Inversions t = new Global_and_Local_Inversions();
        int[] A = {1,0,2};
        System.out.println(t.isIdealPermutation(A));
    }
}
