import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 데스나이트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int startR, startC, endR, endC;
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
		endR = Integer.parseInt(st.nextToken());
		endC = Integer.parseInt(st.nextToken());
		int res = bfs(startR, startC);
		System.out.println(res);
	}
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};
	private static int bfs(int r, int c) {
		boolean[][] v = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c, 0));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.r == endR && cur.c == endC) {
				return cur.cnt;
			}
			for(int i = 0 ; i < 6; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc]) continue;
				q.offer(new Point(nr, nc, cur.cnt+1));
				v[nr][nc] = true;
			}
		}
		return -1;
	}
}
