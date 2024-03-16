import java.util.*;
import java.io.*;

class Solution {
    private boolean[] visited;
    private int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    private void dfs(String now, String target, String[] words, int count) {
        
        if (now.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isOneDiff(now, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isOneDiff(String s1, String s2) {
        boolean flag = false;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        if (diff==1) flag = true;
        return flag;
    }
}