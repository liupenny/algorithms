package primary_lesson_homework;

import java.util.Scanner;

/**
 * Created by PennyLiu on 2017/11/16.
 * 计算一个数的阶乘有多少个0。

 最简单的思路就是把所有的数字进行分解质因数，例如：
 6 = 2*3
 15 = 3*5
 64 = 2*2*2*2*2*2 = 2^6
 100 = 2^2 * 5^2
 576 = 2^6 * 3^2
 那么我们在计算n的阶乘时，实际上就是把所有小于等于n的正整数分解成质因数，然后再将其乘到一起，那么末尾0的个数实际上就是2*5的个数，
 而2的个数明显是很多很多的，所以问题就转化成了5的个数。而只有5的倍数才有5这个因数，
 所以，问题就进一步简化为小于等于n的数中有多少个数是5的倍数，当然25的倍数，125的倍数，625还要单独考虑。
 考虑5/5=1,25/5=5,125/5=25.所以即，5是一个5,25是两个五。125十三个5.所以有n/5 直到n为零
 */
public class factorial {
    public static int main()
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        while (num!=0)
        {
            count += num/5;
            num = num/5;
        }
        return count;
    }
}
