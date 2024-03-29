class Solution {
    public int solution(int n) {
        boolean[] checked = new boolean[n+1]; // 에라토스테네스 체크용 배열
        int answer = 0;
        
        for (int i=2; i<=n; i++) {
            if (checked[i]) continue; // 걸러진건 패스
            
            int j = 2;
            while (i*j <= n) {
                checked[i*j] = true;
                j++;
            }
        }
        
        for (int i=2; i<=n; i++) {
            if (!checked[i]) answer++;
        }
        
        return answer;
    }
}