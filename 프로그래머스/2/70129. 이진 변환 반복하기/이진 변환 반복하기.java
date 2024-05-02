// 목표: s를 1로 만들어라 (0제거 -> !길이를! 이진법으로 변환 -> 다시 0제거 -> ...)
// char[]로 변환한다

// 문제를 똑바로 읽자....... 길이였다 길이...

class Solution {
    public int[] solution(String s) {
        
        int _0 = 0;
        
        int t=0;
        int tt=5;
        StringBuilder sb;
        while (tt-->0) {
            t++;
            sb = new StringBuilder();
            
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') sb.append(1);
                if (s.charAt(i) == '0') _0++;
            }
            
            int len = sb.toString().length();
            int val = 0;
            
            // for (int i=0; i<len; i++) {
            //     val += Math.pow(2, len-i-1);
            // }
            
            s = Integer.toBinaryString(len);
            
            System.out.println(s);
            
            if (s.length()==1) break;
        }
        
        int[] answer = {t, _0};
        return answer;
    }
}