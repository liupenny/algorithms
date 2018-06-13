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
