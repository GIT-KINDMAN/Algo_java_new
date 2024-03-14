import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[][] map;
	static int N, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		
		String line = null;
		for (int i=0; i<N; i++) {
			line = br.readLine();
			for (int j=0; j<N; j++) {
				if (line.charAt(j)=='Y') {
					map[i][j] = true;
					map[j][i] = true;
				}
			}
		}
		
		max = Integer.MIN_VALUE;
		
		for (int i=0; i<N; i++) {
			int count = 0;
			for (int j=0; j<N; j++) {
				if (j==i) continue;
				// 친구인 경우
				if (map[i][j]) {
					count++;
				}
				// 친구가 아닌 경우
				else {
					for (int k=0; k<N; k++) {
						if (k==i || k==j) continue;
						if (map[j][k] && map[i][k]) {
							count++;
							break;
						}
					}
				}
			}
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}
}