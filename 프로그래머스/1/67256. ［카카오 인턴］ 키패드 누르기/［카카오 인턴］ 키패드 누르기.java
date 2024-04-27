import java.util.*;
import java.io.*;

class Solution {
    private int[][] map = new int[4][3];
    public String solution(int[] numbers, String hand) {
        // 1열 left
        // 2열 
        //  <> 가까운 손
        //  == 왼, 오른손잡이 따라서
        // 3열 right
        
        
        String answer = find(numbers, hand);
        return answer;
    }
    
    private String find (int[] numbers, String hand) {
        
        char[] cArr = new char[numbers.length];        
        
        int now_l_i = 3;
        int now_l_j = 0;
        int now_r_i = 3;
        int now_r_j = 2;
        
        for (int i=0; i<numbers.length; i++) {
            int num = numbers[i];
            if (num % 3 == 1) { // 1열 (left)
                cArr[i] = 'L';
                now_l_i = num/3;
                now_l_j = 0;
            } else if (num % 3 == 0 && num != 0) { // 3열 (right)
                cArr[i] = 'R';
                now_r_i = num/3 - 1;
                now_r_j = 2;
            } else { // 2열 (2, 5, 8, 0)
                // 함수 실행
                int target_i = num/3;
                if (num == 0) target_i = 3;
                
                int diff_left = Math.abs(now_l_i - target_i) + Math.abs(now_l_j - 1);
                int diff_right = Math.abs(now_r_i - target_i) + Math.abs(now_r_j - 1);
                
                if (diff_left < diff_right) {
                    cArr[i] = 'L';
                    now_l_i = target_i;
                    now_l_j = 1;
                } else if (diff_left > diff_right) {
                    cArr[i] = 'R';
                    now_r_i = target_i;
                    now_r_j = 1;
                } else {
                    if (hand.equals("left")) {
                        cArr[i] = 'L';
                        now_l_i = target_i;
                        now_l_j = 1;
                    } else if (hand.equals("right")) {
                        cArr[i] = 'R';
                        now_r_i = target_i;
                        now_r_j = 1;
                    }
                }
            }
        }
        
        return String.valueOf(cArr);
    }
}

// class Point {
//     int i;
//     int j;
    
//     Point (int i, int j) {
//         this.i = i;
//         this.j = j;
//     }
// }