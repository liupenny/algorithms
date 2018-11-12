package BFS.Word_LadderII;

import java.util.*;

/**
 * Created by PennyLiu on 2018/9/11.
 */

public class Solution{
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        // Neighbors for every node
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>(16);
        // Distance of every node from the start node
        HashMap<String, Integer> distance = new HashMap<>(16);
        ArrayList<String> solution = new ArrayList<>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        /*
        BFS: Trace every node's distance from the start node (level by level).
         */
        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<String>());
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    // 用distance判断Check if visited
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        // Found the shortest path
                        if (end.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            if (foundEnd) {
                break;
            }
        }
    }


    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        /*
        Find all next level nodes.
         */
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) {
                    continue;
                }
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }


    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        /*
        DFS: output all paths with the shortest distance.
         */
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }

        }
        solution.remove(solution.size() - 1);
    }

    public static void main(String[] args){
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        Solution s = new Solution();
        System.out.println(s.findLadders(beginWord,endWord,wordList));
    }
}
