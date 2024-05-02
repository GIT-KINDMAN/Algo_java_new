class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int next = n;
        while (true) {
            next++;
            
            if (check1(n, next) && check2(n, next)) {
                answer = next;
                break;
            }            
        }
        
        return answer;
    }
    
    
    private boolean check1 (int n, int next) {
        if (n < next) return true;
        return false;
    }
    
    private boolean check2 (int n, int next) {
        int _n = 0, _next = 0;
        String __n = "", __next = "";
        
        __n = Integer.toBinaryString(n);
        __next = Integer.toBinaryString(next);

        
        for (int i=0; i<__n.length(); i++) {
            if (__n.charAt(i) == '1') _n++;
        }
        
        for (int i=0; i<__next.length(); i++) {
            if (__next.charAt(i) == '1') _next++;
        }
        
        if (_n == _next) return true;
        
        return false;
    }
    
    // private boolean check3 (int n, int next) {
    //     return true;
    // }
}