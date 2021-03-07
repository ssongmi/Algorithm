import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방향전환 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());
		// 테스트 케이스 수만큼 반복하며
		for(int tc = 1; tc <= T; tc++) {
			// x1, y1, x2, y2를 입력받고
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int diffX = Math.abs(x1-x2);
			int diffY = Math.abs(y1-y2);
			int min = Math.abs(diffX-diffY);
			int ans = 0;
			if(diffX+diffY == 1) {
				ans = 1;
			}else if(min%2 == 0) {
				ans = Math.max(diffY, diffX)*2;
			}else{
				ans = Math.max(diffX, diffY)*2-1;
			}
			// 그 차이를 더함

			sb.append(String.format("#%d %d\n", tc, ans));
		}
		System.out.println(sb);
	
	}
}
