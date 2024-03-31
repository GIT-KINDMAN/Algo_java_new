import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
//         Map<String, ArrayList<String>> map = new HashMap<>();
        
//         for (int i = 0; i < clothes.length; i++) {
            
//             String key = clothes[i][1];
//             String val = clothes[i][0];

//             if (!map.containsKey(key)) {
//                 map.put(key, new ArrayList<>());
//             }
            
//             map.get(key).add(val);
//         }
        
//         Set<String> keySet = map.keySet();
//         int size = keySet.size();
//         int[] things = new int[size];
        
//         int idx = 0;
//         for (String item : keySet) {
//             things[idx] = map.get(item).size();
//             idx++;
//         }
        
//         int sum = 0;
        
//         for (int i=0; i<size; i++) {
//             for (int j=i+1; j<size; j++) {
//                 sum += things[i] * things[j];
//             }
//             sum += things[i];
//         }
        
//         return sum;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {

            String key = clothes[i][1];
            String val = clothes[i][0];

            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key)+1);
            }
        }
        
        int sum = 1;
        
        // for (String item : map.keySet()) {
        //     sum *= map.get(item)+1; // 사이즈
        //     // System.out.println("val: "+ (map.get(item)+1));
        // }
        
        for (Integer val : map.values()) {
            sum *= (val+1); // 안입는 경우 포함
        }
        
        return sum-1; // 공집합 제외
    }
}