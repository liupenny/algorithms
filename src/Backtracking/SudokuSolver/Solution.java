package Backtracking.SudokuSolver;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/20
 */

class Solution {
    private static int ROW = 9;
    private static int COL = 9;

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        solve(board);

    }
    public boolean solve(char[][] board) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) {
                return false; //check row
            }
            if(board[row][i] != '.' && board[row][i] == c) {
                return false; //check column
            }
        }

        for(int i=0; i<3; i++ ) {
            for(int j=0; j<3; j++ ) {
                int x = i + (row/3) * 3;
                int y = j + (col/3) * 3;
                if(board[x][y] != '.')
                {
                    if(board[x][y] == c)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}

class Solution2 {
    // row[x][y]=1表示第x行用过y这个数
    // col[x][y]=1表示第x列用过y这个数
    private boolean[][] row;
    private boolean[][] col;
    // 一共有9个box, box[x][y]=1表示第x个box中已经有了y这个数。box的索引通过
    private boolean[][] box;

    public void solveSudoku(char[][] board) {
        row = new boolean[9][10];
        col = new boolean[9][10];
        box = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];

                if (c != '.') {
                    int n = c -'0';

                    int bx = i/3;
                    int by = j/3;
                    row[i][n] = true;
                    col[j][n] = true;
                    box[3*bx + by][n] = true;
                }
            }
        }
        solve(board,0,0);
    }

    public boolean solve(char[][] board, int x, int y) {
        if (x == 9) {
            return true;
        }

        int ny = (y + 1) % 9;
        int nx = (ny == 0) ? x + 1 : x;

        if(board[x][y] != '.') {
            return solve(board, nx, ny);
        }
        for (int i = 1; i <= 9; i++) {
            int bx = x/3;
            int by = y/3;
            int boxNum = bx * 3 + by;

            if (!row[x][i] && !col[y][i] && !box[boxNum][i]) {
                row[x][i] = true;
                col[y][i] = true;
                box[boxNum][i] = true;
                board[x][y] = (char) (i + '0');
                if (solve(board,nx, ny)) {
                    return true;
                }
                row[x][i] = false;
                col[y][i] = false;
                box[boxNum][i] = false;
                board[x][y] = '.';
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution2 a = new Solution2();
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
            , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
            , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
            , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
            , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
            , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
            , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
            , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
            , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        a.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print((int)(board[i][j] - '0') + " ");
            }
            System.out.println();
        }
    }
}

