package test;

/**
 * Created by PennyLiu on 2018/5/13.
 */
public class test {
    public static void main(String[] args)
    {
        // 可以直接调用静态函数
        fun1();

        // 非静态函数，必须声明对象
        test t = new test();
        t.fun2();

        // 这里是错的，静态方法中不能new内部类的实例对象
        // Person p = new Person();

        // 内部类的实例对象，必须先定义一个外部类的实例对象
        t.init();
    }

    class Person {
        int index;
        double score;
    }

    public static void fun1()
    {
        int a = 0;
    }

    public void fun2()
    {
        int a = 0;
    }

    public void init()
    {
        Person p = new Person();
    }

}

class Dup{
    private static int findDup(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int count = countNum(arr, start, mid);
            if (start == end) {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count <= (mid - start + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    private static int countNum(int[] arr, int start, int end) {
        int count = 0;
        for (int a:arr) {
            if (a>=start && a<=end) {
                count++;
            }
        }
        return count;
    }
}