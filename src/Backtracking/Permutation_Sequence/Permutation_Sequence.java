package Backtracking.Permutation_Sequence;

import java.util.ArrayList;

/**
 * Created by PennyLiu on 2018/5/12.
 */
public class Permutation_Sequence {
    public String getPermutation(int n, int k)
    {
        if (n == 0) {
            return "";
        }

        k--;  //这里先--是为了后面算除数和取模的时候，算出来的结果和数组角标对应0-（n-1）
        ArrayList<Integer> list = new ArrayList<>(); //用list把所有数字存起来，后面遍历的时候用过一个就删除一个
        for (int i = 1; i <= n; i++)
        {
            list.add(i);
        }
        StringBuilder res = new StringBuilder();
        int factorial = 1;
        for (int i = 2; i <= n-1 ; i++)
        {
            factorial *= i;
        }

        for (int i = n-1; i >= 0; i--)
        {
            int num = list.get(k/factorial);  //get 和 remove参数给int的话是删除这个Index对应的值，list数组是从0开始索引，解决了除的结果为0时对应的数字的问题，这里就直接对应Index
            res.append(num);
            list.remove(k/factorial);
            if(i > 0)
            {
                k = k%factorial;
                factorial /= i;
            }
        }
        return res.toString();
    }

    public String getPermutation1(int n, int k) {
        if(n<=0) {
            return "";
        }
        k--;
        StringBuilder res = new StringBuilder();
        int factorial = 1;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=2;i<n;i++)
        {
            factorial *= i;
        }
        for(int i=1;i<=n;i++)
        {
            nums.add(i);
        }
        int round = n-1;
        while(round>=0)
        {
            int index = k/factorial;
            k %= factorial;
            res.append(nums.get(index));
            nums.remove(index);
            if(round>0) {
                factorial /= round;
            }
            round--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Permutation_Sequence t = new Permutation_Sequence();
        int n = 1, k = 1;
        System.out.println(t.getPermutation(n,k));
    }
}
