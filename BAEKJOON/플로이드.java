import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int INF = 99999999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if(map[r][c] != 0 && w < map[r][c]) map[r][c] = w;
			else if(map[r][c] == 0) map[r][c] = w;
		}
		for(int i = 1; i < N+1; i++ ) {
			for(int j = 1; j < N+1; j++) {
				if(i!=j && map[i][j] == 0) map[i][j] = INF;
			}
		}
		for(int k = 1; k < N+1; k++) {
			for(int i = 1; i < N+1; i++) {
				if(k == i) continue;
				for(int j = 1; j < N+1; j++) {
					if(k == j || j == i) continue;
					map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
				}
			}
		}
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				if(map[i][j] >= INF) sb.append("0 ");
				else sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
