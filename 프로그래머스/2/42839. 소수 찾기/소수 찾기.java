// import java.util.*;

// class Solution {
//     public int solution(String numbers) {
//         int answer = 0;
        
//         char[] cArr = numbers.toCharArray();
//         int[] arr = new int[cArr.length];
        
//         for (int i=0; i<cArr.length; i++) {
//             arr[i] = cArr[i] - '0';
//         }
        
        
        
//         return answer;
//     }
    
//     private int[] perm(int len, )
    
//     private boolean[] makePrime (boolean[] check, int len) {
//         int size = Math.pow(10, len+1);
//         check = new boolean[size];
//         Arrays.fill(check, true);
        
//         // 소수 아닌 것들을 false 처리
//         for (int i=2; i<size; i++) {
//             if (!check[i]) continue;
//             for (int j=1; i*j<size; j++) {
//                 check[i*j] = false;
//             }
//         }
        
//         return check;
//     }
// }

// import java.util.*;

// class Solution {
//     Set<Integer> numberSet = new HashSet<>();
    
//     public int solution(String numbers) {
//         int answer = 0;
        
//         char[] cArr = numbers.toCharArray();
//         int[] arr = new int[cArr.length];
        
//         for (int i=0; i<cArr.length; i++) {
//             arr[i] = cArr[i] - '0';
//         }
        
//         // 모든 숫자 조합 생성
//         for (int i=1; i<=arr.length; i++) {
//             perm(arr, 0, i);
//         }
        
//         // 소수 판별 배열 생성
//         int maxNumber = Collections.max(numberSet);
//         boolean[] primeCheck = makePrime(maxNumber + 1);
        
//         // 소수 개수 세기
//         for (int num : numberSet) {
//             if (primeCheck[num]) {
//                 answer++;
//             }
//         }
        
//         return answer;
//     }
    
//     // 순열 (조합 생성)
//     private void perm(int[] arr, int depth, int k) {
//         if (depth == k) {
//             addToSet(arr, k);
//             return;
//         }
//         for (int i = depth; i < arr.length; i++) {
//             swap(arr, i, depth);
//             perm(arr, depth + 1, k);
//             swap(arr, i, depth); // 복구
//         }
//     }
    
//     // 숫자 조합을 Set에 추가
//     private void addToSet(int[] arr, int k) {
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < k; i++) {
//             sb.append(arr[i]);
//         }
//         int num = Integer.parseInt(sb.toString());
//         numberSet.add(num);
//     }
    
//     // 배열 원소 교환
//     private void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }
    
//     // 소수 판별 배열 생성
//     private boolean[] makePrime(int size) {
//         boolean[] check = new boolean[size];
//         Arrays.fill(check, true);
        
//         check[0] = check[1] = false;
//         for (int i=2; i*i<size; i++) {
//             if (check[i]) {
//                 for (int j=i*i; j<size; j+=i) {
//                     check[j] = false;
//                 }
//             }
//         }
        
//         return check;
//     }
// }

import java.util.*;

class Solution {
    Set<Integer> numberSet = new HashSet<>();
    boolean[] visited; // 방문 여부를 추적할 배열 추가
    
    public int solution(String numbers) {
        int answer = 0;
        
        char[] cArr = numbers.toCharArray();
        int[] arr = new int[cArr.length];
        visited = new boolean[cArr.length]; // 방문 여부 배열 초기화
        
        for (int i=0; i<cArr.length; i++) {
            arr[i] = cArr[i] - '0';
        }
        
        // 모든 숫자 조합 생성
        for (int i=1; i<=arr.length; i++) {
            int[] output = new int[i];
            perm(arr, output, 0, i);
        }
        
        // 소수 판별 배열 생성
        int maxNumber = Collections.max(numberSet);
        boolean[] primeCheck = makePrime(maxNumber + 1);
        
        // 소수 개수 세기
        for (int num : numberSet) {
            if (primeCheck[num]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 순열 (조합 생성) - visited 사용
    private void perm(int[] arr, int[] output, int depth, int k) {
        if (depth == k) {
            addToSet(output, k);
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, depth + 1, k);
                visited[i] = false; // 백트래킹
            }
        }
    }
    
    // 숫자 조합을 Set에 추가
    private void addToSet(int[] arr, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(arr[i]);
        }
        int num = Integer.parseInt(sb.toString());
        numberSet.add(num);
    }
    
    // 소수 판별 배열 생성
    private boolean[] makePrime(int size) {
        boolean[] check = new boolean[size];
        Arrays.fill(check, true);
        
        check[0] = check[1] = false;
        for (int i=2; i*i<size; i++) {
            if (check[i]) {
                for (int j=i*i; j<size; j+=i) {
                    check[j] = false;
                }
            }
        }
        
        return check;
    }
}