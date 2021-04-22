import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보호필름 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int D, W, K;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			isSelected = new int[D];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			int[][] temp = new int[D][W];
			if(K != 1 ) powerset(0, 0, temp);				
			else min = 0;
			sb.append(String.format("#%d %d\n", tc, min));
			
		}
		System.out.println(sb);
	}
	static int[] isSelected;
	static int min = Integer.MAX_VALUE;
	private static void powerset(int cnt, int sum, int[][] temp) {
		if(sum > K) return;
		if(cnt== D) {
			int count = 0;
			for(int i = 0; i < D; i++) {
				if(isSelected[i] == -1)count++;
				
			}
			// 검사하기
			if(D-count < min && check(temp)) {
				min = Math.min(min, D-count);
			}
			return;
			
		}
		isSelected[cnt] = -1;
		temp[cnt] = Arrays.copyOf(map[cnt], W);
		powerset(cnt+1, sum, temp);

		isSelected[cnt] = 0;
		Arrays.fill(temp[cnt], 0);
		powerset(cnt+1, sum+1, temp);
		temp[cnt] = Arrays.copyOf(map[cnt], W);
	
		isSelected[cnt] = 1;
		Arrays.fill(temp[cnt], 1);
		powerset(cnt+1, sum+1, temp);
		temp[cnt] = Arrays.copyOf(map[cnt], W);
	}
	private static boolean check(int[][] map) {
		for(int i = 0; i < W; i++) {
			int cnt = 0;
			int max = 0;
			int prev = map[0][i];
			for(int j = 0; j < D; j++) {
				if(prev == map[j][i]) cnt++;
				else {
					max = Math.max(cnt, max);
					cnt = 1;
					prev = map[j][i];
				}
				if(cnt >= K || max >=K) continue;
			}
			max = Math.max(cnt, max);
			if(max < K) return false;
		}
		
		return true;
	}
}
