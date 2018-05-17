package Backtracking.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PennyLiu on 2018/5/11.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        help(nums, temp, res, visited);
        return res;
    }

    public void help(int[] nums, ArrayList<Integer> list, List<List<Integer>> res, boolean[] visited)
    {
        if (list.size() == nums.length)
        {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            while (i>0 && nums[i] == nums[i-1] && visited[i-1]) //>0是防止i-1溢出，visited[i-1]是已经访问过就过去了
                i++;
            if(i == nums.length)
                return;

            if(visited[i])
                continue;

            list.add(nums[i]);
            visited[i] = true;
            help(nums, list, res, visited);

            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute1(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;

        ArrayList<Integer> temp = new ArrayList<Integer>();
        help1(nums, temp, res);
        return res;
    }

    public void help1(int[] nums, ArrayList<Integer> list, List<List<Integer>> res)
    {
        if (list.size() == nums.length)
        {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
           if(list.contains(nums[i]))
               continue;

            list.add(nums[i]);
            help1(nums, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations t = new Permutations();
        int[] nums = {1,2,3};
        System.out.println(t.permute1(nums));
    }
}
