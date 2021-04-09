import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C;
	static char[][] map;
	static Queue<Point> sq = new LinkedList<>();
	static Queue<Point> wq = new LinkedList<>();
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
		
	}
	static Point dest;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S')sq.add(new Point(i, j, 0));
				if(map[i][j] == '*')wq.add(new Point(i, j, 0));
				if(map[i][j] == 'D')dest = new Point(i, j);
			}
		}
		int res = bfs();

		if(res == -1) System.out.println("KAKTUS");
		else System.out.println(res);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static int bfs() {
		int res = -1;
		while(!sq.isEmpty()) {
			int ssize = sq.size();
			int wsize = wq.size();

			for(int i = 0; i < wsize; i++) {
				Point cur = wq.poll();
				for(int j = 0; j < 4; j++) {
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];

					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if(map[nr][nc] == '*' || map[nr][nc] == 'S' || map[nr][nc] == 'D' || map[nr][nc] == 'X') continue;
					map[nr][nc] = '*';
					wq.add(new Point(nr, nc));					
				}
			}
			for(int i = 0; i < ssize; i++ ) {
				
				Point cur = sq.poll();
				for(int j = 0; j < 4; j++) {
					
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];
					if(nr == dest.r && nc == dest.c) {
						res = cur.cnt+1;
						return res;
					}
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if(map[nr][nc] == '*' || map[nr][nc] == 'S' || map[nr][nc] == 'X') continue;
					map[nr][nc] = 'S';
					sq.add(new Point(nr, nc, cur.cnt+1));
				}
			}
		}
		return res;
	}
}
