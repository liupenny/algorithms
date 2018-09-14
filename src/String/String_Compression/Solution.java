package String.String_Compression;

/**
 * Created by PennyLiu on 2018/7/10.
 */

public class Solution{
    // 错的，答案不仅要数字，还要把结果直接修改到原数组上
//    public int compress(char[] chars) {
//        if(chars == null || chars.length == 0)
//            return 0;
//
//        int res = 0;
//        for (int i = 0; i < chars.length; ) {
//            int j = i + 1;
//            while (j < chars.length && chars[j] == chars[i])
//                j++;
//            if(j - i == 1)
//                res += 1;
//            else if(j - 1 < 10)
//                res += 2;
//            else if(j - 1 < 100)
//                res += 3;
//            else if(j - 1 < 1000)
//                res += 4;
//            else
//                res += 5;
//            i = j;
//        }
//        return res;
//    }

    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) {
            return 0;
        }

        // 两个index,i去读,j去写。i，j都从0开始
        int j = 0;
        for (int i = 0; i < chars.length; ) {
            // 记录当前字符和个数
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current)
            {
                i++;
                count++;
            }

            chars[j] = current;
            if(count > 1)
            {
                String countStr = String.valueOf(count);
                for (char a: countStr.toCharArray()) {
                    chars[++j] = a;
                }
            }
            ++j;
        }
        return j;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        char[] c = {'a','a','b','b','c','c','c'};
         //char[] c = {'a'};
        //char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
//        char[] c = {'b','l','l','l','l','l','l','4','4','W','W','&','d','d','d','@','D','D','.','.','.','8','8','8','U','V','>','J','J','k','H','H','=','l','[','[','[','[','[','[','[','a','a','\'','<','[','[','y','V','l','l','\'','$','E','`','v','k','E','E','t','t','t','t','t','=','=','0','C','a','l','l','l','r','R','M','M','c','c','c','A','A','S','9','9','9','9',')',')','\\','s','\\','\\','y','W','W','W','J','J','J','J','6','6','<','<','E','u','e','e','e','e','e','e','e','e','e','9','9','9','9','R','8','?','F','3','&','&','&','&','f','%','%','2','2','2',')',')',')','J','p','|','D','D','D','s','t','V','V','?','^','^','S','3','3','3','3','h','*','|','|','b','b','a','a','a','r','r','r','r','J','.','^','^','~','g',':',':',':','(','4','4','4','4','w','w','w','w','w','w','w','C','?','=','d','L',':','0','0','c','w','w','w','w','w','w','{','{','t','k','k','k','&','&','&','h','j','j','j','0','3','l',';',';',';',';',';','.','.','.','%','1','1','1','l','9','?','?','?','t','>','E','N','N','@','>','.','.','I','a','a','a','a','B','7','7','{','o','o','-','+','+','+','+','o','o','}','B','B','r','r','r','q','4','4','4','9','W','W','W','W','W','\'','\'','\'','g','J','(','(','(','(','t','t','?',';','g','g','g','0',']',']',']'};
        System.out.println(s.compress(c));
    }
}