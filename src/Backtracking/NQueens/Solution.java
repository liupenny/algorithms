package Backtracking.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/20
 */
class Solution1 {
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private ArrayList<List<String>> res;

    public void test() {
        List<Integer> a = new ArrayList<>();
        a.add(2);
    }
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<Integer>();
        putQueen(n, 0, row);

        return res;
    }

    // 尝试在一个n皇后问题中, 摆放第index行的皇后位置.row存储每一行的皇后摆放在第几列的位置
    // 处理第index行
    private void putQueen(int n, int index, LinkedList<Integer> row){
        System.out.println("进行到第 " + index + " 行" + "row是" + String.valueOf(row));
        // 全部遍历完，生成解
        if(index == n){
            res.add(generateBoard(n, row));
            System.out.println("得到 " + String.valueOf(row) + " 返回");
            return;
        }

        for (int i = 0 ; i < n ; i ++) {
            // 尝试将第index行的皇后摆放在第i列
            // 纵方向和两个对角线方向都不冲突
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.addLast(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }

        System.out.println("第" + index + "行结束，返回");
        return;
    }

    // 将int数组转为string
    private List<String> generateBoard(int n, LinkedList<Integer> row){
        assert row.size() == n;

        ArrayList<String> board = new ArrayList<String>();
        for (int i = 0 ; i < n ; i++){
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    private static void printBoard(List<String> board){
        for(String s: board) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = (new Solution()).solveNQueens(n);
        for(List<String> board: res) {
            printBoard(board);
        }
    }
}


public class Solution {
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<>();
        solveNQueen(0, n, row);
        return ans;
    }

    private List<String> generateBoard(List<Integer> row, int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] charArray = new char[n];
            Arrays.fill(charArray,'.');
            charArray[row.get(i)] = 'Q';
            ret.add(new String(charArray));
        }
        return ret;
    }

    private void solveNQueen(int index, int n, LinkedList<Integer> row) {
        System.out.println("进行到第 " + index + " 行" + "row是" + String.valueOf(row));
        if (index == n) {
            ans.add(generateBoard(row,n));
            System.out.println("得到 " + String.valueOf(row) + " 返回");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n -1]) {
                row.addLast(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index -i + n -1] = true;
                solveNQueen(index + 1, n , row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index -i + n -1] = false;
                row.removeLast();
            }
        }

        System.out.println("第" + index + "行结束，返回");
        return;
    }

    private static void printBoard(List<String> board){
        for(String s: board) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = (new Solution()).solveNQueens(n);
        for(List<String> board: res) {
            printBoard(board);
        }
    }
}