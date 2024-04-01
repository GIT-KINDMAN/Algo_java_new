import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alpha = new int[26];
        
        Arrays.fill(alpha, -1);
        
        for (int i=0; i<s.length(); i++) {
            int alp = s.charAt(i) - 'a';
            
            if (alpha[alp] == -1 ) {
                answer[i] = -1;
                alpha[alp] = i;
            } else if (alpha[alp] >= 0) {
                answer[i] = i-alpha[alp];
                alpha[alp] = i;
            }
        }
        
        return answer;
    }
}