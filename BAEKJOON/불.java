import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static char[][] map;
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
		
	}
	static Point me;
	static Point start;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') q.add(new Point(i,j));
				if(map[i][j] == 'F') fq.add(new Point(i, j));
			}
		}
		int res = bfs();
		if(res == -1) System.out.println("IMPOSSIBLE");
		else System.out.println(res);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> fq = new LinkedList<>();
	private static int bfs() {
		while(!q.isEmpty()) {
			
			int fsize = fq.size();
			
			for(int k = 0; k < fsize; k++) {
				Point fire = fq.poll();
			
				for(int i = 0; i < 4; i++) {
					int nr = fire.r + dr[i];
					int nc = fire.c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M ) continue;
					if(map[nr][nc] == '#' || map[nr][nc] == 'F') continue;
					map[nr][nc] = 'F';
					fq.offer(new Point(nr, nc, fire.cnt+1));
				}
			}
			
			int size = q.size();
			for(int k = 0; k < size; k++) {
				Point cur = q.poll();

				for(int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
						return cur.cnt+1;
					}
					if(map[nr][nc] == '#' || map[nr][nc] == 'F' || map[nr][nc] == 'J')continue;
					map[nr][nc] = 'J';						
					q.offer(new Point(nr, nc, cur.cnt+1));		
				}
			}
		}
		return -1;
	}
}

