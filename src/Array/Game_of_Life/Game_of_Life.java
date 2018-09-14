package Array.Game_of_Life;

/**
 * Created by PennyLiu on 2018/5/30.
 */
public class Game_of_Life {
    /*
    00(0)：表示当前是死，更新后是死； 这里的0是因为原来的数据中0就表示死
    10(1)：表示当前是生，更新后是生；
    11(2)：表示当前是生，更新后是死；  这里是为了好根据更新后的数据进行还原，通过取模操作还原，所以需要更新后1对应生，0对应死
    01(3)：表示当前是死，更新后是生.
     */
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int lives = getLives(board, i, j);
                // 因为只进行一轮更新，所以这一轮的初始只有0,1
                if(board[i][j] == 0 && lives == 3)  //当下死，更新后活
                {
                    board[i][j] = 3;
                } else if(board[i][j] == 1 && (lives < 2 || lives > 3)) //当下活，更新后死
                {
                    board[i][j] = 2;
                }

            }
        }

        // 将数据更新回其原本应该有的样子
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public int getLives(int[][] board, int x, int y)
    {
        int lives = 0;
        for (int i = Math.max(0, x -1); i <= Math.min(board.length - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(board[0].length - 1, y + 1) ; j++) {
                if(i == x && j == y) {
                    continue;
                }
                if(board[i][j] == 1 || board[i][j] == 2) {
                    lives++;
                }
            }
        }
        return lives;
    }

    public static void main(String[] args) {
        Game_of_Life t = new Game_of_Life();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
        t.gameOfLife(board);
    }
}
