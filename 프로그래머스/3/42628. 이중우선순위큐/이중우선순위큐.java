import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pq_asc = new PriorityQueue<>();
        PriorityQueue<Integer> pq_desc = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String item : operations) {
            
            String[] s = item.split(" ");
            
            String s1 = s[0]; // op
            int s2 = Integer.parseInt(s[1]); // val
                
            if (s1.equals("I")) { // 큐에 삽입
                pq_asc.offer(s2);
                pq_desc.offer(s2);
            } else if (s1.equals("D")) {
                if (s2==1 && !pq_desc.isEmpty()) { // 최댓값 삭제
                    int max = pq_desc.poll();
                    pq_asc.remove(max);
                } else if (s2==-1 && !pq_asc.isEmpty()) { // 최솟값 삭제
                    int min = pq_asc.poll();
                    pq_desc.remove(min);
                }
            }
        }
        
        int[] answer = new int[2];
        if (pq_asc.isEmpty() && pq_desc.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = pq_desc.poll();
            answer[1] = pq_asc.poll();
        }
        
        // [최댓값, 최솟값]        
        return answer;
    }
}