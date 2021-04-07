import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int L, R, C;
	static char[][][] map;
	static boolean v[][][];
	static class Point{
		int l, r, c, cnt;

		public Point(int l, int r, int c) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
		}

		public Point(int l, int r, int c, int cnt) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	static Point start, end;
	static int[] dl = {0, 0, 0, 0, -1, 1};
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken()); // 층수
			R = Integer.parseInt(st.nextToken()); // 행
			C = Integer.parseInt(st.nextToken()); // 열
			
			if(L == 0 && R == 0 && C == 0) break;
			map = new char[L][R][C];
			v = new boolean[L][R][C];
			
			for(int k = 0; k < L; k++) {
				for(int i = 0; i < R; i++) {
					String tmp = br.readLine();
					for(int j = 0; j < C; j++) {
						map[k][i][j] = tmp.charAt(j);
						if(map[k][i][j] == 'S') start = new Point(k, i, j);
						if(map[k][i][j] == 'E') end = new Point(k, i, j);
					}
				}
				br.readLine();
			}
			
			int res = bfs();
			if(res == -1) sb.append("Trapped!\n");
			else {
				sb.append("Escaped in " + res + " minute(s).\n");
			}
		} // 끝
		System.out.println(sb);
		
		
	}
	
	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(start.l, start.r, start.c, 0));
		v[start.l][start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(cur.l == end.l && cur.r == end.r && cur.c == end.c) {
				return cur.cnt;
			}
			for(int i = 0; i < 6; i++) {
				int nl = cur.l + dl[i];
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C || v[nl][nr][nc] || map[nl][nr][nc] == '#') continue;
				q.add(new Point(nl, nr, nc, cur.cnt+1));
				v[nl][nr][nc] = true;
			}
		}
		return -1;
	}
}
