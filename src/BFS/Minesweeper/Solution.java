package BFS.Minesweeper;/**
 * Created by PennyLiu on 2018/9/5.
 */

public class Solution{
//    public char[][] updateBoard(char[][]board, int[] click) {
//        if(board == null || board.length == 0 || click == null || click.length == 0)
//            return null;
//
//        int heighth = board.length - 1, width = board[0].length - 1;
//        int x = click[0], y = click[1];
//        if(board[x][y] == 'M') {
//            board[x][y] = 'X';
//            return board;
//        }
//        else if(board[x][y] == 'E'){
//            int mines = 0;
//            if (x - 1 >= 0){
//                if(y - 1 >= 0 && board[x - 1][y - 1] == 'M')
//                    mines++;
//                if(board[x-1][y] == 'M')
//                    mines++;
//                if (y + 1 <= width && board[x - 1][y + 1] == 'M')
//                    mines++;
//            }
//            if(x + 1 <= heighth){
//                if(y - 1 >= 0 && board[x + 1][y - 1] == 'M')
//                    mines++;
//                if(board[x+1][y] == 'M')
//                    mines++;
//                if (y + 1 <= width && board[x + 1][y + 1] == 'M')
//                    mines++;
//            }
//            if(y - 1 >= 0 && board[x][y - 1] == 'M')
//                mines++;
//            if(y + 1 <= width && board[x][y + 1] == 'M')
//                mines++;
//            if(mines != 0){
//                board[x][y] = (char)('0' + mines);
//                return board;
//            }
//            else {
//                board[x][y] = 'B';
//                if (x - 1 >= 0){
//                    if(y - 1 >= 0)
//                        updateBoard(board, new int[]{x - 1,y - 1});
//                    if (y + 1 <= width)
//                        updateBoard(board, new int[]{x - 1,y + 1});
//                    updateBoard(board, new int[]{x - 1,y});
//                }
//                if(x + 1 <= heighth){
//                    if(y - 1 >= 0 )
//                        updateBoard(board, new int[]{x + 1,y - 1});
//                    if (y + 1 <= width)
//                        updateBoard(board, new int[]{x + 1,y + 1});
//                    updateBoard(board, new int[]{x + 1,y});
//                }
//                if(y - 1 >= 0)
//                    updateBoard(board, new int[]{x,y - 1});
//                if(y + 1 <= width)
//                    updateBoard(board, new int[]{x,y + 1});
//            }
//        }
//        return board;
//    }

    public char[][] updateBoard(char[][]board, int[] click) {
        if(board == null || board.length == 0 || click == null || click.length == 0) {
            return null;
        }

        int heighth = board.length - 1, width = board[0].length - 1;
        int x = click[0], y = click[1];
        if(board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        else if(board[x][y] == 'E'){
            int mines = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if(i == 0 && j == 0) {
                        continue;
                    }
                    int xtmp = x + i, ytmp = y + j;
                    if(xtmp < 0 || xtmp > heighth || ytmp < 0 || ytmp > width) {
                        continue;
                    }
                    if(board[xtmp][ytmp] == 'M' || board[xtmp][ytmp] == 'X') {
                        mines++;
                    }
                }
            }
            if(mines != 0){
                board[x][y] = (char)('0' + mines);
                return board;
            }
            else {
                board[x][y] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(i == 0 && j == 0) {
                            continue;
                        }
                        int xtmp = x + i, ytmp = y + j;
                        if(xtmp < 0 || xtmp > heighth || ytmp < 0 || ytmp > width) {
                            continue;
                        }
                        if(board[xtmp][ytmp] == 'E') {
                            updateBoard(board, new int[]{xtmp, ytmp});
                        }
                    }
                }
            }
        }
        return board;
    }

    public static void main(String[] args){
        char[][] board = new char[][]
                {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3,0};
        Solution s = new Solution();
        char[][] ret = s.updateBoard(board,click);
        for (char[] a : ret){
            System.out.println(a);
        }
    }
}