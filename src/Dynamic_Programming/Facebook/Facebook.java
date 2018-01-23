package Dynamic_Programming.Facebook;

/**
 * Created by PennyLiu on 2018/1/23.
 */
public class Facebook {
    public static int number(char[] chs, int i) //chs字符串从i位置开始有多少种可能性
    {
        if(i == chs.length)  //前面都正确转换到底了，任务已经正确找到了一种
            return 1;
        if(chs[i] == '0')
            return 0;
        if(chs[i] == '1')
        {
            int res = number(chs,i+1);
            if(i+1<chs.length)
                res += number(chs,i+2);
            return res;
        }
        if(chs[i] == '2')
        {
            int res = number(chs,i+1);
            if(i+1<chs.length && chs[i+1]>='0' && chs[i+1]<='6')
                res += number(chs,i+2);
            return res;
        }
        return number(chs,i+1);
    }

}
