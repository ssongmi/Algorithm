import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, hx, hy, ex, ey;
	static int[][] map;
	static boolean[][][] v;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		hx = Integer.parseInt(st.nextToken())-1;
		hy = Integer.parseInt(st.nextToken())-1;

		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
	
		map = new int[N][M];
		v = new boolean[N][M][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
		
	}
	private static int bfs() {
		int res = -1;
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(hx, hy, 1, 0));
		v[hx][hy][1] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(cur.r == ex && cur.c == ey) {
				res = cur.idx;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0|| nc >=M)continue;
				if(map[nr][nc] == 1 && (v[nr][nc][1] || cur.cnt == 0)) continue; 
				if(map[nr][nc] == 1) {
					v[nr][nc][cur.cnt-1] = true;
					q.offer(new Point(nr, nc, cur.cnt-1, cur.idx+1));
				}else {
					if(v[nr][nc][cur.cnt]) continue;
					v[nr][nc][cur.cnt] = true;
					q.offer(new Point(nr, nc, cur.cnt, cur.idx+1));
				}
			}
		}
		return res;
	}
	static class Point{
		int r, c, cnt, idx;

		public Point(int r, int c, int cnt, int idx) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.idx = idx;
		}
		
	}
}
