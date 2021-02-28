import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] height;
	static int N = 0, B = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력 받고
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수만큼 반복하며
		for(int tc = 1; tc <= T; tc++) {
			// 점원의 수와 선반의 높이를 입력받고
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			
			// 점원들의 수만큼 각각의 키를 입력받는다.
			height = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			minHeight = Integer.MAX_VALUE;
			powerset(0,0);
			sb.append(String.format("#%d %d\n", tc, (minHeight - B)));
		}
		System.out.println(sb);
	}
	static int minHeight = Integer.MAX_VALUE;
	private static void powerset(int idx, int total) {
		if(total >= B) {
			minHeight = total < minHeight ? total : minHeight;
			return;
		}
		if(idx == N ) {
			// 부분집합으로 만들 수 있는 키 중에서 선반의 높이 이상이면서 
			// 그 중에서 가장 작은 높이를 구한다.
			if(total >= B) minHeight = total < minHeight ? total : minHeight; 
			return;
		}
		
		powerset(idx+1, total+height[idx]);
		powerset(idx+1, total);
	}
}
