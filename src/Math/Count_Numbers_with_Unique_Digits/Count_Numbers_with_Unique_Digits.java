package Math.Count_Numbers_with_Unique_Digits;

public class Count_Numbers_with_Unique_Digits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return 10;
        }

        int val = 9, sum = 10;
        for (int i = 2; i <= n; i++)
        {
            val *= ( 9 - i + 2);  //从不同的数入手，第一位有9个选择（不等于0），第二位也有9个选择（不等于第一位，加上0）
            sum += val;           //第三位有八个选择，跟前两个都不一样，依次是7 6 5.
        }                         //前两个都是9，所以从第2位开始算。第i位应有9-i+2
        return sum;
    }


    public static void main(String[] args) {
        Count_Numbers_with_Unique_Digits t = new Count_Numbers_with_Unique_Digits();
        System.out.println(t.countNumbersWithUniqueDigits(4));
    }
}
