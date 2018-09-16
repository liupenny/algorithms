package BFS.Word_LadderII;

import java.util.*;

/**
 * Created by PennyLiu on 2018/9/11.
 */

public class Solution{
    List<List<String>> results;
    List<String> list;
    Map<String,List<String>> map;
    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        results= new ArrayList<>();
        if (dict.size() == 0) {
            return results;
        }

        int curr=1,next=0;
        boolean found=false;
        list = new LinkedList<>();
        map = new HashMap<>(16);

        Queue<String> queue= new ArrayDeque<>();
        Set<String> unvisited = new HashSet<>(dict);
        Set<String> visited = new HashSet<>();

        queue.add(start);
        unvisited.add(end);
        unvisited.remove(start);
        //BFS
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++){
                StringBuilder builder = new StringBuilder(word);
                for (char ch='a';  ch <= 'z'; ch++){
                    builder.setCharAt(i,ch);
                    String newWord=builder.toString();
                    if (unvisited.contains(newWord)){
                        //Handle queue
                        //Key statement,Avoid Duplicate queue insertion
                        if (visited.add(newWord)){
                            next++;
                            queue.add(newWord);
                        }
                        //Build Adjacent Graph
                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        }
                        else{
                            List<String> l= new LinkedList<>();
                            l.add(word);
                            map.put(newWord, l);
                        }

                        if (newWord.equals(end)&&!found) {
                            found=true;
                        }

                    }

                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
            if (curr==0){
                if (found) {
                    break;
                }
                curr=next;
                next=0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }//End While

        backTrace(end,start);

        return results;
    }
    private void backTrace(String word,String start){
        if (word.equals(start)){
            list.add(0,start);
            results.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if (map.get(word)!=null) {
            for (String s : map.get(word)) {
                backTrace(s, start);
            }
        }
        list.remove(0);
    }

    public static void main(String[] args){
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        Solution s = new Solution();
        System.out.println(s.findLadders(beginWord,endWord,wordList));
    }
}
