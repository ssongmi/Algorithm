import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준말이되고픈원숭이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Status{
		int x, y, len, cnt; // x좌표, y좌표, 동작 횟수, 말처럼 움직일 수 있는 횟수

		public Status(int x, int y, int len, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.len = len;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Status [x=" + x + ", y=" + y + ", len=" + len + ", cnt=" + cnt + "]";
		}
		
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] horseR = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] horseC = {1, 2, 2, 1, -1, -2, -2, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		int K = Integer.parseInt(br.readLine()); // K번 말처럼 움직일 수 있음
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		boolean[][][] v = new boolean[N][M][K+1];
		Queue<Status> q = new LinkedList<>();
		q.add(new Status(0,0,0,K));
		
		while(!q.isEmpty()) {
			Status cur = q.poll();
			if(cur.x == N-1 && cur.y == M-1) {
				ans = cur.len;
				break;
			}
			// 원숭이처럼 움직이는 경우
			for(int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1 || v[nr][nc][cur.cnt]) continue;
				v[nr][nc][cur.cnt] = true;
				q.add(new Status(nr, nc, cur.len+1, cur.cnt));
			}
			// 말처럼 움직일 수 있는 경우
			if(cur.cnt > 0) {
				for(int d = 0; d < 8; d++) {
					int nr = cur.x + horseR[d];
					int nc = cur.y + horseC[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 1 || v[nr][nc][cur.cnt-1]) continue;		
					v[nr][nc][cur.cnt-1] = true;
					q.add(new Status(nr, nc, cur.len+1, cur.cnt-1));
				}				
			}
		}
		if(N==1 && M == 1)System.out.println(0);
		else if(ans == 0) System.out.println("-1");
		else System.out.println(ans);
		
	}
}
