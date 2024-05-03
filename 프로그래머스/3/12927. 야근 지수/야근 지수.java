import java.util.*;

class Solution {
    // n: 남은 근무 시간, works[]: 각 작업 남은 시간
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 입력
        for (int item : works) pq.add(item);
        
        for (int i=0; i<n; i++) {
            if (pq.isEmpty()) break;
            int min = pq.poll();
            min--;
            if (min<=0) {
                continue;
                // pq.clear();
                // break;
            }
            pq.add(min);
        }
        
        if (!pq.isEmpty()) for (int item : pq) answer += Math.pow(item, 2);
        
        return answer;
    }
}