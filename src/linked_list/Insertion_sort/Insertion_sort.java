import edu.princeton.cs.algs4.StdOut;

/**
 * Created by PennyLiu on 2017/8/8.
 * 插入排序
 */

public class Insertion_sort {
    public static void sort(Comparable[] array)
    {
        // 通过交换实现
        int length = array.length;
        for (int i = 1; i < length; i++)
        {
            for(int j = i; j>0 && less(array[j],array[j-1]); j--)
                exch(array,j,j-1);
        }
    }

    public static void move(Comparable[] array)
    {
        // 通过右移元素实现
        int length = array.length;
        int j;
        for (int i = 1; i < length; i++)
        {
            Comparable tmp = array[i];
            for (j = i; j>0 && less(array[j],array[j-1]); j--)
                array[j] = array[j-1];
            array[j] = tmp;
        }
    }

    public static void GuardSort(Comparable[] array)
    {
        //有哨兵且通过移动实现的插入排序,需要数组空出下标为0的元素，从下标为1开始输入
        int length = array.length;
        int j;
        //下面开始用新的数组装载原数组
        Comparable[] tmp_array = new Comparable[length+1];
        for(int i = 0; i < length; i++)
            tmp_array[i+1] = array[i];
        for (int i = 2; i < length + 1; i++)
        {
            tmp_array[0] = tmp_array[i];
            for(j = i -1 ; less(tmp_array[0], tmp_array[j]); j--)
                tmp_array[j] = tmp_array[j-1];
            tmp_array[j] = tmp_array[0];
        }
    }

    public static boolean less(Comparable varA, Comparable varB)
    {
        return varA.compareTo(varB) < 0;
    }

    public static void exch(Comparable[] array, int i, int j)
    {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    public static void show(Comparable[] array)
    {
        for(int i = 0; i < array.length; i++)
            StdOut.print(array[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] array)
    {
        for(int i = 1; i < array.length; i++)
        {
            if(less(array[i],array[i-1]))
                return false;
        }
        return true;
    }

}
