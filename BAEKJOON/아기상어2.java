import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		ArrayList<Point> shark = new ArrayList<>();
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					map[i][j] = -1;
					shark.add(new Point(i, j));
				}
			}
		}
		for(int i = 0, size = shark.size(); i < size; i++) {
			Point cur = shark.get(i);
			bfs(cur.r, cur.c);
		}
		
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != -1 && res < map[i][j]) {
					res = map[i][j];
				}
			}
		}
		System.out.println(res);
	}
	static class Point{
		int r, c, cnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c, 0));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i = 0; i < 8; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1 ) continue;
				if(map[nr][nc] == 0 || (map[nr][nc] != 0 && cur.cnt+1 < map[nr][nc])) {
					map[nr][nc] = cur.cnt+1;
					q.offer(new Point(nr, nc, cur.cnt+1));				
				}
			}			
		}
	}
}
