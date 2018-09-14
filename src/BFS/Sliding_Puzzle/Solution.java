package BFS.Sliding_Puzzle;

import java.util.*;

/**
 * Created by PennyLiu on 2018/9/6.
 */

public class Solution{
    public int slidingPuzzle(int[][] board) {
        // 先找到0所在的位置
        int row = 2, col = 3;
        String goal = "123450";
        String origin = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", "");

        if(origin.equals(goal)) {
            return 0;
        }
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Set<String> visited = new HashSet<>();
        visited.add(origin);
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        queue.offer(origin);
        while (!queue.isEmpty()){
            ++step;
            int size = queue.size();
            while (size-- > 0){
                String tmp = queue.poll();
                int idx = tmp.indexOf('0');
                int x = idx / col, y = idx % col;
                for (int i = 0; i < 4; i++) {
                    int tx = x + dir[i][0];
                    int ty = y + dir[i][1];
                    if(tx < 0 || tx >= row || ty < 0 || ty >= col) {
                        continue;
                    }
                    int pos = tx * col + ty;
                    String newString = swap(tmp, idx, pos);
                    if(visited.contains(newString)) {
                        continue;
                    }
                    if(newString.equals(goal)) {
                        return step;
                    }
                    visited.add(newString);
                    queue.add(newString);
                }
            }
        }
       return -1;
    }

    public String swap(String a, int x, int y){
        StringBuilder sb = new StringBuilder(a);
        sb.setCharAt(x,a.charAt(y));
        sb.setCharAt(y,a.charAt(x));
        return sb.toString();
    }

    public static void main(String[] args){
        int[][] board = {{1,2,3},{4,5,0}};
        Solution s = new Solution();
        System.out.println(s.slidingPuzzle(board));
    }
}