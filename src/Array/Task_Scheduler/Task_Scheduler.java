package Array.Task_Scheduler;

import java.util.*;

/**
 * Created by PennyLiu on 2018/5/25.
 */
public class Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
            return 0;

        // 用0-25表示A-Z26个字母，map角标表示字母，Map的值表示字母出现次数
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        // 优先队列，使用逆序排序，大顶堆把每个任务的个数加进去
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int task: map) {
            if(task > 0)
                queue.add(task);
        }

        int time = 0;
        while (!queue.isEmpty())
        {
            int i = 0;
            // 要进行元素修改的话，只能先删除再插入，来保证正确顺序, 所以这里用arraylist保存
            List<Integer> temp = new ArrayList<>();
            while (i <= n) //一次减去n+1个数
            {
                if(!queue.isEmpty())
                {
                    if(queue.peek() > 1)
                        temp.add(queue.poll()-1);
                    else
                        queue.poll();
                }
                time++;
                if(queue.isEmpty() && temp.size()==0)
                    break;
                i++;
            }
            for (int m:temp) {
                queue.add(m);
            }
        }
        return time;
    }

//    private class valComparator implements Comparator<HashMap.Entry<Character, Integer>>
//    {
//        public int compare(HashMap.Entry<Character, Integer> m, HashMap.Entry<Character, Integer> n)
//        {
//            return n.getValue() - m.getValue();
//        }
//    }

    public static void main(String[] args) {
        Task_Scheduler t = new Task_Scheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(t.leastInterval(tasks, n));
    }
}
