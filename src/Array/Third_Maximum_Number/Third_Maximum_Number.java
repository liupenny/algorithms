package Array.Third_Maximum_Number;

/**
 * Created by PennyLiu on 2018/5/30.
 */
public class Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        // 不能用 Integer.MIN_VALUE ，因为给的数据有可能包含这个
        // int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        Integer first = null, second = null, third = null;

        for (Integer n : nums) {  //
            if(n.equals(first) || n.equals(second) || n.equals(third) )
                continue;
            if(first == null || n > first) //用null的话，如果只有一个nums[i] > first, 会报错，因为整数不能和null相比较
            {
                third = second;
                second = first;
                first = n;
            }
            else if(second == null || n > second)
            {
                third = second;
                second = n;
            }
            else if(third == null || n > third)
                third = n;
        }
        return third != null ? third : first;
    }

    public static void main(String[] args) {
        Third_Maximum_Number t = new Third_Maximum_Number();
        int[] nums = {3,2,1};
        System.out.println(t.thirdMax(nums));
    }
}
