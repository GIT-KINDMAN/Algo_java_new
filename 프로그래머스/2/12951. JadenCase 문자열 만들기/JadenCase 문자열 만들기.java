class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] words = s.toLowerCase().split(" ", -1);
        
        StringBuilder sb = new StringBuilder();
        // for (String word : words) {
        //     if (!word.isEmpty()) {
        //         sb.append(capitalize(word));
        //     }
        //     sb.append(" ");
        // }
        
        for (int i=0; i<words.length; i++) {
            if (!words[i].isEmpty()) {
                sb.append(capitalize(words[i]));
            }
            if (i == words.length-1) break;
            sb.append(" ");
        }
        
        answer = sb.toString();
            // .trim();
        
        // if (words[words.length-1].equals(" ")) answer += " ";
        
        return answer;
    }
    
    private String capitalize (String s) {
        if (s==null || s.isEmpty()) {
            return s;
        } else {
            return s.substring(0,1).toUpperCase() + s.substring(1);
        }
    }
}