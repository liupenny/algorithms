package Backtracking.PathInSquare;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/11/27
 */
public class Solution {
    private boolean[] visited;
    private int row,col;
    private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        row = rows;
        col = cols;
        visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (contains(matrix,i,j,str,0) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean inArea(int i, int j) {
        return i >=0 && i < row && j >= 0 && j < col;
    }

    public boolean contains(char[] matrix, int i, int j, char[] str, int strIdx){
        if (strIdx == str.length - 1) {
            return matrix[i*col+j] == str[strIdx];
        }

        if (matrix[i*col+j] == str[strIdx]) {
            visited[i*col+j] = true;
            for (int k = 0; k < 4; i++) {
                int newi = i + d[k][0];
                int newj = j + d[k][1];
                if (inArea(newi,newj) && visited[newi*col+newj]==false && contains(matrix, newi, newj,str, strIdx+1)) {
                    return true;
                }
            }
            visited[i*col+j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        Solution s = new Solution();
        char[] str = {'b','c','c','e','d'};
        System.out.println(s.hasPath(matrix,3,4, str));
    }
}