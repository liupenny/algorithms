package BFS.Word_Ladder;

import java.util.*;

/**
 * Created by PennyLiu on 2018/9/10.
 */

public class Solution{
    // 一个一个比较会超时
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第一次的变化作为key,剩下的变化作为val
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }

        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        int steps = 0;
        while (!q.isEmpty()) {
            ++steps;
            for (int s = q.size(); s > 0; --s) {
                String w = q.poll();
                for (String word:wordList) {
                    if(isOneDif(w,word)){
                        if(word.equals(endWord)) {
                            return steps + 1;
                        } else {
                            dict.remove(word);
                            q.offer(word);
                        }
                    }
                }
            }
        }
        return 0;
    }

    // 一次变换一个字符，最多也就26种可能性。
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }

        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        int l = beginWord.length();
        int steps = 0;

        while (!q.isEmpty()) {
            ++steps;
            for (int s = q.size(); s > 0; --s) {
                String w = q.poll();
                char[] chs = w.toCharArray();
                for (int i = 0; i < l; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == ch) {
                            continue;
                        }
                        chs[i] = c;
                        String t = new String(chs);
                        if (t.equals(endWord)) {
                            return steps + 1;
                        }
                        if (!dict.contains(t)) {
                            continue;
                        }
                        dict.remove(t);
                        q.offer(t);
                    }
                    chs[i] = ch;
                }
            }
        }
        return 0;
    }

    public boolean isOneDif(String a, String b){
        int dif = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) {
                dif++;
            }
            if(dif > 1) {
                return false;
            }
        }
        return dif==1;
    }

    public int ladderLengthBi(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }

        if (!dict.contains(endWord)) {
            return 0;
        }

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        int l = beginWord.length();
        int steps = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            ++steps;
            // 每次都交换一下，从对方的角度去扩展
            if (q1.size() > q2.size()) {
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            //扩展出的新set
            Set<String> q = new HashSet<>();

            for (String w : q1) {
                char[] chs = w.toCharArray();
                for (int i = 0; i < l; ++i) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chs[i] = c;
                        String t = new String(chs);
                        //如果这次的扩展结果在另一个set中，证明两个set能连上了。直接返回答案就行.
                        //返回的是step+1,实际上只变了step次，按答案要求返回的是这个变化链的长度
                        if (q2.contains(t)) {
                            return steps + 1;
                        }
                        if (!dict.contains(t)) {
                            continue;
                        }
                        dict.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }

            q1 = q;

        }
        return 0;
    }

    // 通过转换成图的方式，用bfs做
    public int ladderLengthGraph(String beginWord, String endWord, List<String> wordList) {
        // graph<begin,neibor> 记录一个节点和对应的邻居
        Map<String, Set<String>> graph = new HashMap<>();
        //这里转换成set，便于后面直接修改字符串中的某一位来比对是否在wordlist中
        Set<String> words = new HashSet<String>(wordList);

        for(String word : words) {
            graph.put(word, new HashSet<>());
        }
        graph.put(beginWord, new HashSet<>());

        //构建图，加入节点和邻居数据
        for(String node : graph.keySet()) {
            for (int i = 0; i < node.length(); i++) {
                char[] chars = node.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String word = new String(chars);
                    if (words.contains(word)) {
                        graph.get(word).add(node);
                        graph.get(node).add(word);
                    }
                }
            }
        }
        //到某个字符串需要的步数
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);

        bfs(graph, dist, beginWord);
        return dist.get(endWord) != null ? dist.get(endWord) +1 : 0;

    }
    //根据图使用dijkstra得到距离数据
    private void bfs(Map<String, Set<String>> graph, Map<String, Integer> dist, String source) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(source);

        int level = 0;

        while(! queue.isEmpty()) {
            int size = queue.size();

            while(size > 0) {
                String poll = queue.poll();
                size--;

                for(String child : graph.get(poll)) {
                    if(dist.get(child) == null) {
                        dist.put(child, level +1);
                        queue.offer(child);
                    }
                }
            }
            level++;
        }
    }

    // 用布尔型加快速度
    private boolean isDistance1(String word1, String word2) {
        boolean isSingledistance = false;
        for(int i = 0; i < word1.length(); i++) {
            if(word2.charAt(i) != word1.charAt(i)) {
                if(isSingledistance) {
                    return false;
                }
                isSingledistance = true;
            }
        }

        return isSingledistance;
    }

    public static void main(String[] args){
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        Solution s = new Solution();
        System.out.println(s.ladderLengthBi(beginWord,endWord,wordList));
    }
}