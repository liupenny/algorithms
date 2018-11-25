package array.Surrounded_Regions;

import java.util.LinkedList;

/**
 * Created by PennyLiu on 2018/4/16.
 */
public class Surrounded_Regions {

    public void solve(char[][] board)
    {
        if(board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        for (int i = 0; i < board[0].length; i++)
        {
            fill(board, 0, i); //上边缘
            fill(board,board.length-1,i); //下边缘
        }
        for (int i = 0; i < board.length; i++)
        {
            fill(board, i, 0); //左边缘
            fill(board, i,board[0].length-1);  //右边缘
        }
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if(board[i][j]=='O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void fill(char[][] board, int i, int j)
    {
        if(board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        LinkedList<Integer> queue = new LinkedList<>();
        int pos = i * board[0].length + j;
        queue.offer(pos);
        while (!queue.isEmpty())
        {
            pos = queue.poll();
            int row = pos/board[0].length;
            int col = pos%board[0].length;
            if(row > 0 && board[row - 1][col] == 'O')  //判断上面位置的值是不是O
            {
                queue.offer((row - 1) * board[0].length + col);
                board[row - 1][col] = '#';
            }
            if(row < board.length - 1 && board[row + 1][col]=='O') //判断下面位置的值是不是O
            {
                queue.offer((row + 1) * board[0].length + col);
                board[row + 1][col] = '#';
            }
            if(col > 0 && board[row][col-1]=='O')  //判断左边位置的值是不是O
            {
                queue.offer(row * board[0].length + col - 1);
                board[row][col - 1] = '#';
            }
            if(col < (board[0].length -1 ) && board[row][col + 1]=='O')  //判断右边位置的值是不是O
            {
                queue.offer(row * board[0].length + col + 1);
                board[row][col + 1] = '#';
            }
        }
    }

    public static void main(String[] args)
    {
        char[][] num = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        // char[][] num1 = {{0,1},
        //        {1,1}};
        Surrounded_Regions a = new Surrounded_Regions();
        //System.out.println(a.solve(num));
        a.solve(num);
    }
}
