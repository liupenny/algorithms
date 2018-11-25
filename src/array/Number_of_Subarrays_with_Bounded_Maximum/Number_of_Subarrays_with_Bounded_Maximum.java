package array.Number_of_Subarrays_with_Bounded_Maximum;

/**
 * Created by PennyLiu on 2018/5/24.
 */
public class Number_of_Subarrays_with_Bounded_Maximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R)
    {
        if(A == null || A.length == 0 || L > R) {
            return 0;
        }

        int head = 0, count = 0, res = 0;

        for(int i = 0; i < A.length; i++)
        {
            if(A[i] >= L && A[i] <= R)
            {
                res += i - head + 1; //res表示A[head:i]是有效的，此时考虑以A[i]结尾的字符串有 i-head+1个, 注意这里是每个有效数字都算进去
                count = i - head + 1;
            }
            else if(A[i]<L)
            {
                res += count; //count表示此时A[head:i]也是有效的，但一定要包含前面的某个数，所以有效数组的个数是i-head+1
            }
            else
            {
                head = i + 1;
                count = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Number_of_Subarrays_with_Bounded_Maximum t = new Number_of_Subarrays_with_Bounded_Maximum();
        int[] A = {2, 1, 4, 3};
        int L = 2 , R = 3;
        System.out.println(t.numSubarrayBoundedMax(A,L, R));
    }
}
