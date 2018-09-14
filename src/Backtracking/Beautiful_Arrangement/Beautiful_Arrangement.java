package Backtracking.Beautiful_Arrangement;

/**
 * Created by PennyLiu on 2018/4/30.
 */
public class Beautiful_Arrangement {
    int count = 0;
    public int countArrangement(int N)  //暴力法
    {
        int[] nums = new int[N];
        for (int i = 1; i <= N; i++) {
            nums[i - 1] = i;
        }
        permute(nums,0);
        return count;
    }

    public int countArrangement_backtracking(int N)  //回溯法
    {
        boolean[] visited = new boolean[N+1];
        calculate(N, 1, visited);
        return count;
    }

    public void calculate(int N, int pos, boolean[] visited) //visited[i]记录数字i是否被访问过
    {
        if(pos > N) {
            count++;
        }
        for (int i = 1; i <= N; i++)
        {
            if(!visited[i] && (pos % i == 0 || i % pos == 0))
            {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }

    public void permute(int[] nums, int index)
    {
        if(index == nums.length - 1) //已经排序完成
        {
            int i;
            for(i = 1; i <= nums.length; i++)
            {
                if(nums[i-1] % i != 0 && i % nums[-1] != 0) {
                    break;
                }
            }
            if( i == nums.length + 1)
            {
                count++;
            }
        }
        for (int i = index; i < nums.length; i++)
        {
            swap(nums, i, index);
            permute(nums, index + 1);
            swap(nums, i, index);  //换完了再换回来
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }



    public static void main(String[] args) {
        Beautiful_Arrangement t = new Beautiful_Arrangement();
        System.out.print(t.countArrangement(2));
    }
}
