package Array.Word_Search;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by PennyLiu on 2018/6/7.
 */
public class Word_Search {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public boolean exist_4dir(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;

        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                    if (find1(board, i, j, word, 0, visited) == true)
                        return true;
                }
            }
        return false;
    }

    public boolean find1(char[][] board, int row, int col, String word, int index, int[][] visited)
    {
        if(index == word.length())  //这几个判断条件的顺序也很重要，当数组只有一个数的时候，就直接返回true
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if(board[row][col] != word.charAt(index) || visited[row][col] == 1)
            return false;

        visited[row][col] = 1;
        boolean exit = find1(board, row, col - 1, word, index + 1, visited)
                || find1(board, row, col + 1, word, index + 1, visited)
                || find1(board, row - 1, col, word, index + 1, visited)
                || find1(board, row + 1, col, word, index + 1, visited);
        visited[row][col] = 0;
        return exit;
    }

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null)
            return false;

        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, word, 0, visited) == true)
                    return true;
            }
        }
        return false;
    }

    public boolean find(char[][] board, int i, int j, String word, int index, int[][] visited)
    {
        if(index >= word.length())
            return true;

        //这样子循环是八个方向，但是题目里只有四个方向,所以不能用这样的循环
//        for (int i = Math.max(0, row - 1); i <= Math.min(board.length - 1, row + 1); i++) {
//            for (int j = Math.max(0, col - 1); j <= Math.min(board[0].length - 1, col + 1); j++) {
//                if(visited[i][j] == 1)
//                    continue;
//                if(board[i][j] == word.charAt(index)) {
//                    visited[i][j] = 1;
//                    if(find(board, i, j, word, index + 1, visited) == true)
//                        return true;
//                }
//                visited[i][j] = 0;
//            }
//        }
//        return false;

        if(index == word.length())
            return true;
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && visited[i][j] != 1 && word.charAt(index) == board[i][j]){
            visited[i][j]=1;
            for(int diff =0; diff<dx.length ; diff++){
                if(find(board, i+dx[diff], j+dy[diff], word, index+1, visited)){ //用dx dy把四个方向表示一下
                    return true;
                }
            }
            visited[i][j]=0;
        }
        return false;

    }

    public boolean exist_savemem(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        Word_Search t = new Word_Search();
        char[][] board = {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};
        String word = "ABCCED";
        char[][] board1 = {{'a'}};
        String word1 = "a";
        char[][] board2 = {{'a','a'}};
        String word2 = "aaa";


        System.out.println(t.exist_savemem(board2, word2));
    }
}
