import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] result = new int[3];
        
        // 1, 2, 3, 4, 5, ... (5)
        // 2, 1, 2, 3, 2, 4, 2, 5, ... (8)
        // 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ... (10)
        
        for (int i=0; i<answers.length; i++) {
            int mod5 = i%5;
            int mod8 = i%8;
            int mod10 = i%10;
            int val = answers[i];
        
            switch (mod5) {
                case 0:
                    if (val==1) result[0]++;
                    break;
                case 1:
                    if (val==2) result[0]++;
                    break;
                case 2:
                    if (val==3) result[0]++;
                    break;
                case 3:
                    if (val==4) result[0]++;
                    break;
                case 4:
                    if (val==5) result[0]++;
                    break;
            }

            switch (mod8) {
                case 0: case 2: case 4: case 6:
                    if (val==2) result[1]++;
                    break;
                case 1:
                    if (val==1) result[1]++;
                    break;
                case 3:
                    if (val==3) result[1]++;
                    break;
                case 5:
                    if (val==4) result[1]++;
                    break;
                case 7:
                    if (val==5) result[1]++;
                    break;
            }

            switch (mod10) {
                case 0: case 1:
                    if (val==3) result[2]++;
                    break;
                case 2: case 3:
                    if (val==1) result[2]++;
                    break;
                case 4: case 5:
                    if (val==2) result[2]++;
                    break;
                case 6: case 7:
                    if (val==4) result[2]++;
                    break;
                case 8: case 9:
                    if (val==5) result[2]++;
                    break;
            }
        }
        
        int count = 0;
        int[] asc = new int[3];
        int max = Integer.MIN_VALUE;
    
        for (int i=0; i<3; i++) {
            if (result[i] > max) {
                asc[0] = i+1;
                max = result[i];
                count=1;
            } else if (result[i] == max) {
                count++;
                asc[count-1] = i+1;
            }
        }
        
        int[] ans = new int[count];
        for (int i=0; i<count; i++) {
            ans[i] = asc[i];
        }
        
        
        return ans;
    }
}