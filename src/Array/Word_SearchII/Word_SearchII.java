package Array.Word_SearchII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PennyLiu on 2018/6/7.
 */
public class Word_SearchII {
    public List<String> findWords_likeI(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if(board == null || board.length == 0 || words == null || words.length == 0) {
            return ans;
        }

        for (int i = 0; i < words.length; i++) {
            if (exist_savemem(board, words[i]) == true && !ans.contains(words[i])) //这里注意不添加重复值
            {
                ans.add(words[i]);
            }
        }
        return ans;
    }
    
    public boolean exist_savemem(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (exist(board, y, x, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) {
            return true;
        }
        if (y<0 || x<0 || y == board.length || x == board[y].length) {
            return false;
        }
        if (board[y][x] != word[i]) {
            return false;
        }
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x+1, word, i+1)
                || exist(board, y, x-1, word, i+1)
                || exist(board, y+1, x, word, i+1)
                || exist(board, y-1, x, word, i+1);
        board[y][x] ^= 256;
        return exist;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if(board == null || board.length == 0 || words == null || words.length == 0) {
            return ans;
        }

        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }
        return ans;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res)
    {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) {
            return;    //标记Board这个位置是已经访问过，或者没有以这个字符开头的String
        }
        p = p.next[c - 'a'];
        if(p.word != null)   //通过Null来判断，找到一个string
        {
            res.add(p.word);
            p.word = null;   //找到一个就设置为Null
        }

        board[i][j] = '#';  //有一个或多个String中的某个字符是board[i][j]
        if(i > 0) {
            dfs(board, i - 1, j, p, res);
        }
        if(j > 0) {
            dfs(board, i, j - 1, p, res);
        }
        if(i < board.length - 1) {
            dfs(board, i + 1, j, p, res);
        }
        if(i < board[0].length - 1) {
            dfs(board, i, j + 1, p, res);
        }
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words)
    {
        TrieNode root = new TrieNode();  //root有一个数组，数组长度26，
        for (String word: words) {
            TrieNode p = root;  //所以要插入一个新的word的时候，要从root开始找word的第一个字母
            for (char c: word.toCharArray()) {
                int i = c - 'a';
                if(p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = word;  //不断往下插，最后的节点的word值是这个word
        }
        return root;
    }

    class TrieNode
    {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        Word_SearchII t = new Word_SearchII();
        char[][] board = {{'o','a','a','n'},
                          {'e','t','a','e'},
                           {'i','h','k','r'},
                          {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(t.findWords(board, words));
    }
}
