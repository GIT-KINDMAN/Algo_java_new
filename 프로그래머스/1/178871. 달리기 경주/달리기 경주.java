import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        // for (int i=0; i<callings.length; i++) {
        //     for (int j=0; j<players.length; j++) {
        //         if (players[j].equals(callings[i])) {
        //             String temp = players[j-1];
        //             players[j-1] = players[j];
        //             players[j] = temp;
        //         }
        //     }
        // }
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i=0; i<callings.length; i++) {
            int call_idx = map.get(callings[i]);
            String prev_name = players[call_idx-1];
            
            players[call_idx-1] = callings[i];
            players[call_idx] = prev_name;
            
            map.put(callings[i], call_idx-1);
            map.put(prev_name, call_idx);            
            
        }
        
        return players;
    }
}