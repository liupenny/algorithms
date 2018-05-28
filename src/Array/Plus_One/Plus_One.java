package Array.Plus_One;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/25.
 */
public class Plus_One {
    public int[] plusOne(int[] digits)
    {
        if(digits == null)
        {
            int[] ans = {1};
            return ans;
        }

        for(int i = digits.length-1; i>=0; i--)
        {
            //因为原数字当前位数是9的话就需要再往前走去处理，所以还需往前遍历
            if(digits[i] == 9)
            {
                // if we are at index 0
                // we need to create a new array
                // of length+1
                // 如果首位是0，那需要开一个数组长度加一，第一位是1，后面全是0即可
                if(i == 0)
                {
                    int[] resultArray = new int[digits.length + 1];
                    resultArray[0] = 1;
                    return resultArray;
                }
                // 中间位是9，这一位设置为0
                else
                {
                    digits[i] = 0;
                }
            }
            // 原数字的某一位不是9，直接加一返回即可
            else
            {
                digits[i]++;
                break;
            }
        }

        return digits;

    }

    public static void main(String[] args) {
        Plus_One t = new Plus_One();
        int[] digits = {1,9,9};
        // int[] digits = null;
        System.out.println(Arrays.toString(t.plusOne(digits)));
    }
}
