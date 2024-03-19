import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        
        for (String word : participant) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }
        
        for (String word : completion) {
            if (map.containsKey(word)) {
                int val = map.get(word);
                
                // 동명이인 있는 경우
                if (val>1) {
                    map.put(word, val-1);
                } else {
                    map.remove(word);
                }
            }
        }
        
        for (String retired : map.keySet()) {
            answer = retired;
        }
        
        return answer;
    }
}