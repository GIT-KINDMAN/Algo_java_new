class Solution {
    public int solution(int a, int b, int n) { // a: 반환 빈병, b: 받는 새 콜라, n: 최초 빈병 개수
        // int answer;
        
        // int ratio = a/b; // 새 콜라 받는 비율
        int mod = 0; // ex) 5/2 -> 1을 더해서 저장하는 변수
        int now = n; // 현재 빈 병의 갯수
        int sum = 0; // 받을 수 있는 추가 콜라의 총 갯수 - 최초 n은 더하는게 아님
        
        // 나눌 수 있을 때까지
        while (now >= a) {
            // 새로운 mod와 now를 도출
            mod = now % a;
            sum += (now/a) * b;
            now = (now/a) * b + mod;
        }
        
        return sum;
    }
}