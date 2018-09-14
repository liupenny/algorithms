package BFS.Word_LadderII;

import java.util.*;

/**
 * Created by PennyLiu on 2018/9/11.
 */

public class Solution{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       List<List<String>> ans = new ArrayList<>();
       Set<String> dict = new HashSet<>(wordList);
       if(!dict.contains(endWord)) {
           return ans;
       }

       dict.remove(beginWord);
       dict.remove(endWord);

       Map<String, Integer> steps = new HashMap<>();
       steps.put(beginWord,1);
       Map<String, List<String>> parents = new HashMap<>();
       Queue<String> queue = new LinkedList<>();
       queue.offer(beginWord);

       int l = beginWord.length();
       int step = 0;
       boolean found = false;

       while (!queue.isEmpty() && !found){
           ++step;
           for (int size = queue.size(); size > 0; size--) {
               String p = queue.poll();
               char[] w = p.toCharArray();
               for (int i = 0; i < l; i++) {
                   char ch = w[i];
                   for (char j = 'a'; j < 'z'; j++) {
                       if(j == ch) {
                           continue;
                       }
                       w[i] = j;
                       String strw = new String(w);
                       if(strw.equals(endWord)){
                           parents.get(strw).add(p);
                           found = true;
                       }
                       else {
                           if(steps.containsKey(strw) && (step < steps.get(strw))) {
                               parents.get(strw).add(p);
                           }
                       }
                       if(!dict.contains(strw)) {
                           continue;
                       }
                       dict.remove(strw);
                       queue.offer(strw);
                       steps.put(strw, steps.get(p) + 1);
                       parents.get(strw).add(p);
                   }
                   w[i] = ch;
               }
           }
       }

       if(found){
           List<String> curr = new ArrayList<>();
           curr.add(endWord);
           getPaths(endWord,beginWord,parents,curr,ans);
       }

       return ans;
    }



    public void getPaths(String word, String beginWord, Map<String, List<String>> parents, List<String> curr, List<List<String>> ans){
       if(word.equals(beginWord)){
           ans.add(new ArrayList<>(curr));
           return;
       }

        for (String p: parents.get(word)) {
            curr.add(p);
            getPaths(p,beginWord,parents,curr,ans);
            curr.remove(p);
        }
    }

    public static void main(String[] args){
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        Solution s = new Solution();
        System.out.println(s.findLadders(beginWord,endWord,wordList));
    }
}

class Solutions {
    Map<String, List<String>> map;
    List<List> results;

    public List<List> findLadders(String start, String end, Set<String> dict) {
        results = new ArrayList<List>();
        if (dict.size() == 0) {
            return results;
        }

        int min = Integer.MAX_VALUE;

        Queue<String> queue = new ArrayDeque<String>();
        queue.add(start);

        map = new HashMap<String, List<String>>();

        Map<String, Integer> ladder = new HashMap<String, Integer>();
        for (String string : dict) {
            ladder.put(string, Integer.MAX_VALUE);
        }
        ladder.put(start, 0);

        dict.add(end);
        //BFS: Dijisktra search
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;//'step' indicates how many steps are needed to travel to one word.

            if (step > min) {
                break;
            }

            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String new_word = builder.toString();
                    if (ladder.containsKey(new_word)) {

                        if (step > ladder.get(new_word))//Check if it is the shortest path to one word.
                        {
                            continue;
                        } else if (step < ladder.get(new_word)) {
                            queue.add(new_word);
                            ladder.put(new_word, step);
                        } else {
                            ;// It is a KEY line. If one word already appeared in one ladder,
                        }
                        // Do not insert the same word inside the queue twice. Otherwise it gets TLE.

                        if (map.containsKey(new_word)) //Build adjacent Graph
                        {
                            map.get(new_word).add(word);
                        } else {
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            map.put(new_word, list);
                            //It is possible to write three lines in one:
                            //map.put(new_word,new LinkedList<String>(Arrays.asList(new String[]{word})));
                            //Which one is better?
                        }

                        if (new_word.equals(end)) {
                            min = step;
                        }

                    }//End if dict contains new_word
                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
        }//End While

        //BackTracking
        LinkedList<String> result = new LinkedList<String>();
        backTrace(end, start, result);

        return results;
    }

    private void backTrace(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                backTrace(s, start, list);
            }
        }
        list.remove(0);
    }
}