package array.onebit_and_twobit_Characters;

/**
 * Created by PennyLiu on 2018/5/7.
 */
public class onebit_and_twobit_Characters {
    public boolean isOneBitCharacter(int[] bits)
    {
        if(bits == null || bits.length == 0 || bits.length == 1) {
            return true;
        }
        // 挨个判断即可
        int i;
        for (i = 0; i + 1 < bits.length;)
        {
            if(bits[i] == 0)
            {
                i++;
                continue;
            }
            else
            {
                i+=2;
                continue;
            }
        }
        if(i == bits.length - 1 && bits[i] == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 当前数是0，一定是由1位数组成；
    // 当前数是1，由2位组成
    // 我们将读指针i递增到适当的下一个字符的开头。如果到结尾处，指针在数组最后一个数，那最后一个数就是1位组成

    public boolean isOneBitCharacter1(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;  //适度增加位数
        }
        return i == bits.length - 1;
    }

    public static void main(String[] args)
    {
        onebit_and_twobit_Characters t = new onebit_and_twobit_Characters();
        int[] bits = {1,1,1,0};
        System.out.println(t.isOneBitCharacter(bits));
    }
}
