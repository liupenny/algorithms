package Math.NthDigit;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/11
 */
public class Solution {
    public int findNthDigit(int n) {
        if (n < 0) {
            return -1;
        }
        int index = 1;
        while (true) {
            long digit = countNums(index);
            long totalNums = digit * index;
            if (n < totalNums) {
                return digitAtIndex(n,index);
            } else {
                n -= totalNums;
                index++;
            }
        }
    }

    public long countNums(int index){
        if (index == 1) {
            return 10;
        }
        return (long) (9 * Math.pow(10, index - 1));
    }

    public long beginNum(int index) {
        if (index == 1) {
            return 0;
        }
        return (long) Math.pow(10, index - 1);
    }

    public int digitAtIndex(int n,int index) {
        //对应的起始数值：n是剩下的位数，n/index是这么些个index位数，即加上后能够最接近n。因为这里是从整数位开始加，所以后面是要从后往前走Index - n%index位
        //求1001，减到最后只剩811,811=270*3+1
        long number = beginNum(index) + n/index;
        //还剩下几个数
        int indexFromRight = index - n%index;
        //去除右边的indexFromRight-1个数字，使用除法找到相应位置
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        //求个位数字
        return (int) number%10;
    }

    public int findNthDigit1(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
        // tart记录当前循环区间的第一个数字,当n落到某一个确定的区间里了，那么(n-1)/len就是目标数字在该区间里的坐标，加上start就是得到了目标数字
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public static void main(String[] args) {
        int n = 1000000000;
        Solution s = new Solution();
        System.out.println(s.findNthDigit(n));
    }
}
