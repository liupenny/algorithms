package Sort.Largest_Number;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by PennyLiu on 2017/10/2.
 * leetcode:Largest Number
 * 思路：利用字符串的比较，将整数转换成字符串，因为字符串
 */
public class Largest_Number {
    public String largestNumber(int[] nums)
    {
        if(nums==null || nums.length==0)  // 处理异常情况
        {
            return "";
        }
        if(nums.length == 1) {
            return Integer.toString(nums[0]);
        }

        String[] numstring = new String[nums.length];
        for (int i=0; i< nums.length; i++) {
            numstring[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numstring,new StringCompartor());  //比较排序
        if(numstring[0].charAt(0) == '0')  // 因为已经排好序，所以如果第一个就是0那就没必要了
        {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for(String item:numstring) {
            ans.append(item);
        }
        return ans.toString();
    }

    class StringCompartor implements Comparator<String> //比较器,按照从大到小进行排序
    {
        @Override
        public int compare(String str1, String str2)
        {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1);  //s2 > s1返回1，相等返回0
        }
    }

    public static void main(String[] algs)
    {
        Largest_Number t = new Largest_Number();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(t.largestNumber(nums));
    }
}
