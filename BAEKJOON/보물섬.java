import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static char[][] map;
	static ArrayList<Point> list = new ArrayList<>();
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = tmp[j].charAt(0);
				if(map[i][j] == 'L') list.add(new Point(i, j));
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'L') {
					int res = bfs(i, j);
					ans = Math.max(res, ans);
				}
			}
		}
		
		System.out.println(ans);
	}
	static int ans = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static int bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		q.offer(new Point(r, c,0));
		v[r][c] = true;
		int res = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc] || map[nr][nc] == 'W')continue;
				q.offer(new Point(nr, nc, p.cnt+1));
				res = Math.max(res, p.cnt+1);
				v[nr][nc] = true;
			}
		}
		return res;
	}
}
