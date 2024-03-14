import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int x1, y1, x2, y2, r1, r2, count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			
			count = 0;
			
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken())+10000;
			y1 = Integer.parseInt(st.nextToken())+10000;
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken())+10000;
			y2 = Integer.parseInt(st.nextToken())+10000;
			r2 = Integer.parseInt(st.nextToken());
			

			int distSqr = Math.abs(x1-x2) * Math.abs(x1-x2) + Math.abs(y1-y2) * Math.abs(y1-y2);
			int radSumSqr = (r1+r2) * (r1+r2);
			int radDiffSqr = Math.abs(r1-r2) * Math.abs(r1-r2);
			
			if (distSqr==0) { // 같은 점
				if (r1==r2) {
					count = -1;
				} else {
					count = 0;
				}
			} else if (distSqr > radSumSqr) { // 외부, 안닿음
				count = 0;
			} else if (distSqr < radDiffSqr) { // 내부, 안닿음
				count = 0;
			} else if (distSqr == radSumSqr || distSqr == radDiffSqr){ // 외접 || 내접
				count = 1;
			} else {
				count = 2; // 교차
			}
			
			System.out.println(count);
		}			
	}
}