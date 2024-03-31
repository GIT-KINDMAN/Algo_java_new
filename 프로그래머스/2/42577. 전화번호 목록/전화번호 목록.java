import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 문자열임. 원소 길이 순 정렬 -> 효율성tc 3,4 실패. 사전의 의미를 고려하지 않음
        // Arrays.sort(phone_book, (s1, s2) -> s1.length() - s2.length());
        
        // 사전 순 정렬
        Arrays.sort(phone_book);
        
        // System.out.println(phone_book.getClass().getName());
        
        // loop1:
        // for (int i=0; i<phone_book.length; i++) {
        //     for (int j=i+1; j<phone_book.length; j++) {
        //         if (phone_book[j].startsWith(phone_book[i])) {
        //             answer = false;
        //             break loop1;
        //         }
        //     }
        // }
        
        
        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
            }
        }
        
        return answer;
    }
}