import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            // bfs(i, n, computers, visited);
            dfs(i, n, computers, visited); 
            answer++;
        }
        
        
        return answer;
    }
    
    private void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int point = q.poll();
            for (int i = 0; i < n; i++) {
                if (computers[point][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    private void dfs(int point, int n, int[][] computers, boolean[] visited) {
        visited[point] = true;
            
        for (int i=0; i<n; i++) {
            if (computers[point][i] == 1 && !visited[i])
                dfs(i, n, computers, visited);
        }
    }
}
