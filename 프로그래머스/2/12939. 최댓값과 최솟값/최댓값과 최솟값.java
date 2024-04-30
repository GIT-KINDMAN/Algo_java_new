import java.util.*;
import java.util.stream.Stream;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        String[] str = s.split(" ");
        int[] arr = Stream.of(str).mapToInt(Integer::parseInt).toArray();
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        
        String answer = min+" "+max;
        return answer;
    }
}