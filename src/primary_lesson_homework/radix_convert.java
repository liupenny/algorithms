package primary_lesson_homework;

/**
 * Created by PennyLiu on 2017/11/16.
 * 一： 10进制的数和别的进制的数相互转化：辗转相处法
 * 一个十进制的数 ÷ r = 商 …… 余数
 如果商＜r，那么r进制数 = 商 × 10 + 余数
 如果商≥r 继续除，至到商＜r，
 r进制数 = 最小的商 & 余数 & 余数 & … & 余数
 十进制的数127,5进制 如下:
 127 ÷ 5 = 25 …… 2
 25＞5
 25 ÷ 5 = 5 …… 0
 5 = 5
 5 ÷ 5 = 1 …… 0
 5进制数为1002
 二： java的输入输出

 * System.in和System.out方法
 * 缺点一: 该方法能获取从键盘输入的字符，但只能针对一个字符的获取
 * 缺点二: 获取的只是char类型的。如果想获得int,float等类型的输入,比较麻烦。


 * InputStreamReader和BufferedReader方法
 * 优点: 可以获取键盘输入的字符串
 * 缺点: 如何要获取的是int,float等类型的仍然需要转换


 * Scanner类中的方法
 * 优点一: 可以获取键盘输入的字符串
 * 优点二: 有现成的获取int,float等类型数据，非常强大，也非常方便；

 三：还要考虑输入数据的正负问题
 */

import java.util.Scanner;


public class radix_convert {
    public static void main(String[] algs)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int radix = sc.nextInt();
        String s = "0123456789ABCDEF";
        boolean negative = false;
        if(num<0)  negative = true;
        StringBuilder sb = new StringBuilder();
        num = Math.abs(num);
        while(num>=radix)
        {
            sb.insert(0,s.charAt(num%radix));
            num = num%radix;
        }
        sb.insert(0,s.charAt(num));
        System.out.println((negative?"-":""+sb.toString()));
    }

}
