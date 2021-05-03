import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 내리막길 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R, C;
	static int[][] map;
	static int[][] DP;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static int cnt;
	// 좌표를 저장할 클래스 생성
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			// 산의 지형 입력
			map = new int[R][C];
			DP = new int[R][C];
			for(int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					DP[i][j] = -1;
				}
			}
			// 내리막으로 이동하여 도착점에 도달할 수 있는 경로의 수 초기화
			cnt = 0;
			
			// 시작 지점 방문 체크
			int res = dfs(0, 0);
			System.out.println(res);
	}
	private static int dfs(int r, int c) {
		if(r == R-1 && c == C-1) {
			return 1;
		}
		else if(DP[r][c] == -1) {
			DP[r][c] = 0;
			for(int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] >= map[r][c])continue;
				DP[r][c] += dfs(nr, nc);
				// 다시 돌아왔을 때는 방문체크 풀어주기
			}			
		}
		return DP[r][c];
	}
}
