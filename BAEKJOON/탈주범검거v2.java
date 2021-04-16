import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거v2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int N, M,R, C, L;
	static int[][] map;
	static boolean[][] v;
	static int cnt;
	static int[][] pos = {{},{0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			v = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 1;
			bfs(R, C);
	
			sb.append(String.format("#%d %d\n", tc, cnt));
		}
		System.out.println(sb);
	}
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		v[r][c] = true;
		int time = 0;
		while(!q.isEmpty()) {
			int s = q.size();
			time++;
			if(time == L) return;
			while(s --> 0) {
				Point cur = q.poll();
				int dir = map[cur.r][cur.c];
				for(int i = 0, size = pos[dir].length; i < size; i++) {
					int nr = cur.r + dr[pos[dir][i]];
					int nc = cur.c + dc[pos[dir][i]];
					int curDir = pos[dir][i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc]) continue;
					int nextDir = map[nr][nc];
					
					// 내가 어떤 방향으로 연결되어 있는지도 봐야함
					// 내가 상이면 연결되는 방향은 하가 있어야함
					// 내가 하면 연결되는 방향에는 상이 있어야함
					// 내가 좌면 연결되는 방향에 우가 있어야함
					// 내가 우면 연결되는 방향에 좌가 있어야함
					// 0 <-> 1 // 2 <-> 3
					boolean flag = false;
					for(int j = 0, size2 = pos[nextDir].length; j < size2; j++) {
						if(pos[nextDir][j] != curDir && pos[nextDir][j]/2 == curDir/2) flag = true;
					}
					// 가려고 하는 방향으로 내 상태에서 갈 수 없음
					if(!flag) continue;
					v[nr][nc] = true;
					cnt++;
					q.offer(new Point(nr, nc));
				}
			}
		}
		
	}
}
