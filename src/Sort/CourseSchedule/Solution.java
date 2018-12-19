package Sort.CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PennyLiu
 * @version V1.0
 * @Project: leetcode
 * @Description: TODO
 * @date 2018/12/19
 */
public class Solution {
    // BFS入度法实现
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = numCourses;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                count--;
            }
        }

        while (!queue.isEmpty()) {
            int courseFirst = queue.poll();
            for (int i = 0; i < graph[courseFirst].size(); i++) {
                int courseSecond = (int) graph[courseFirst].get(i);
                degree[courseSecond]--;
                if (degree[courseSecond] == 0) {
                    queue.offer(courseSecond);
                    count--;
                }
            }
        }
        return count == 0;
    }

    // DFS实现
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (!dfs(graph, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course] == true) {
            return false;
        }
        visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            int courseSecond = (int)graph[course].get(i);
            if (!dfs(graph, visited, courseSecond)) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }
}
