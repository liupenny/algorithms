package Bit_Manipulation.Find_the_Difference;

/**
 * Created by PennyLiu on 2018/1/26.
 */
public class Find_the_Difference {
    public char findTheDifference(String s, String t) {
        char a = 0;  //因为字符也是可以赋值的，ascii码为0的值不好赋值，所以直接给整形，这就是他的ASCII码。所以后面异或的结果都对
        for (int i = 0; i < s.length(); i++)
        {
            a ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++)
        {
            a ^= t.charAt(i);
        }
        return a;
    }

    public static void main(String[] args) {
        Find_the_Difference t = new Find_the_Difference();
        System.out.println(t.findTheDifference("dsda","dasde"));
    }
}
