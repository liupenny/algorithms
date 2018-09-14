package Dynamic_Programming.Palindrome_Pairs;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by PennyLiu on 2018/1/24.
 *
 Case 1: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.
 Case 2: If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.
 */
public class Palindrome_Pairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0)
        {
            return ans;
        }

        HashMap<String, Integer> map = new HashMap<>();
        String left, right;
        for (int i = 0; i < words.length; i++)
        {
            map.put(reverseStr(words[i]),i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++)   //最后一轮循环left:S[0,n-2] 右边：S[n-1].而不是全部的子串和 空
            {
                left = words[i].substring(0, j);
                right = words[i].substring(j);
                if (isPalindrome(left) && map.containsKey(right) && map.get(right) != i) {
                    ans.add(Arrays.asList(map.get(right), i));
                }

                if (isPalindrome(right) && map.containsKey(left) && map.get(left) != i) {
                    ans.add(Arrays.asList(i, map.get(left)));
                    if (left.isEmpty())  // 不能用==“” 。如果这个加在上面左边是回文的情况下，找不到右边的对称是不会进去循环体，所以加在这里
                    {
                        ans.add(Arrays.asList(map.get(left), i));
                    }
                }
            }
        }

        return ans;
    }

    public boolean isPalindrome(String s)
    {
        if(s==null || s.length()==0 || s.length()==1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i<s.length() && j>=0; i++, j--)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }

    public String reverseStr(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) {
            return ret;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) {
            map.put(words[i], i);
        }
        for (int i=0; i<words.length; i++) {
            // System.out.println(words[i]);
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                        System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) {
                    // if (map.containsKey(str1rvs) && map.get(str1rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                        System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] algs)
    {
        Palindrome_Pairs t = new Palindrome_Pairs();
        System.out.println(t.palindromePairs(new String[]{"cbc", ""}));
        //t.palindromePairs1(new String[]{"aba", " "});
    }
}
