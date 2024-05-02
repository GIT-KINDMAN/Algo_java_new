// 1부터 n까지 for 돌리되 숫자 벗어나면 continue

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i=1; i<=n; i++) {
            int sum = 0;
            for (int j=i; j<=n; j++) {
                sum += j;
                if (sum > n) {
                    break;
                }
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}