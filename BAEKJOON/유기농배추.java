import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			int K = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				map[r][c] = -1;
			}
//			for(int[] sub : map)
//				System.out.println(Arrays.toString(sub));
			int cnt = 1;
			for(int i = 0; i < N; i++) {
				for(int j =0; j < M; j++) {
					if(map[i][j] == -1) bfs(i, j, cnt++);
				}
			}
			sb.append(cnt-1 + "\n");
		}
		System.out.println(sb);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void bfs(int r, int c, int cnt) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		map[r][c] = cnt;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != -1)continue;
				map[nr][nc] = cnt;
				q.offer(new Point(nr, nc));
			}
			
		}
	}
}
