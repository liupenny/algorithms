package Binary_Search.Find_Smallest_Letter_Greater_Than_Target;

/**
 * Created by PennyLiu on 2018/1/3.
 * 745. Find Smallest Letter Greater Than Target
 */
public class Find_Smallest_Letter_Greater_Than_Target {
    public char nextGreatestLetter(char[] letters, char target) {
        int left=0, right = letters.length-1;
        int mid = 0;
        if(target >= letters[right] || target < letters[left]) return letters[left];  //先排除两边
        while (left<right)
        {
            mid = left + (right - left)/2;
            if(letters[mid] <= target)  //通过找出所有《target的数字的边界来找出第一个 > target的数
                left = mid + 1;
            else
                right = mid;
        }
        return letters[left];  //left此时已经是边界了
    }

    public static void main(String[] algs)
    {
        char[] letters = new char[]{'c','f','j'};
        char target = 'c';
        Find_Smallest_Letter_Greater_Than_Target test = new Find_Smallest_Letter_Greater_Than_Target();
        System.out.println(test.nextGreatestLetter(letters,target));
    }
}
