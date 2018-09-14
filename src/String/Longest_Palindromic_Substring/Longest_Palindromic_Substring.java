package String.Longest_Palindromic_Substring;

/**
 * Created by PennyLiu on 2018/1/22.
 * 思路：code是将左神那个思路合并了
 */
public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s)
    {
        if(s==null || s.length()==0) {
            return "";
        }
        char[] arrStr = manacherString(s);
        int[] indexarr = new int[arrStr.length];   //记录每个位置的字符能扩出去多少
        int R=-1, C=-1;     //R回文右边界，是具体的第几个数，角标上指向下一个数；C回文中心，是数组角标
        int ansindex = 0, anslen = Integer.MIN_VALUE;
        for (int i=0; i<arrStr.length; i++)
        {
            indexarr[i] = i<R ? Math.min(R-i,indexarr[2*C-i]) : 1; //当R>i,给出起码拥有的回文右边界是C和R分别到自己的长度,便于后续尝试; i在R外部时，i本身肯定不用验证
            while (i + indexarr[i] < arrStr.length && i - indexarr[i]>-1)   //看还能不能扩，扩多远，首先看左右有没有越界
            {
                if(arrStr[i + indexarr[i]] == arrStr[i - indexarr[i]]) {
                    indexarr[i]++;
                } else {
                    break;
                }
            }
            if(i + indexarr[i] > R)  //回文右边界如果被扩展地更远了，就更新R C
            {
                R = i + indexarr[i];
                C = i;
            }
            if(indexarr[i] > anslen)  //更新最大回文子串中心和半径
            {
                ansindex = i;
                anslen = indexarr[i];
            }
        }
        return s.substring(ansindex/2 - (anslen-1)/2, ansindex/2 + (anslen-2)/2+1);  //注意这里角标的选取
    }


    public char[] manacherString(String s)   //构造manacher字符串
    {
        char[] charStr = s.toCharArray();
        char[] help = new char[s.length()*2+1];
        for (int i=0; i<help.length; i++) {
            help[i] = i % 2 == 0 ? '#' : charStr[(i - 1) / 2];
        }
        return help;
    }

    public static void main(String[] algs)
    {
        String A="eabcb";
        Longest_Palindromic_Substring t = new Longest_Palindromic_Substring();
        System.out.println(t.longestPalindrome(A));
    }
}
