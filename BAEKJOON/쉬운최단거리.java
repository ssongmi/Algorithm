import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static int N, M;
	static Point end;
	static class Point {
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
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					end = new Point(i, j);
				}
			}
		}
		
		bfs(end.r, end.c);
		map[end.r][end.c] = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					sb.append("0 ");
				} else if(map[i][j] == 1) {
					sb.append("-1 ");
				} else {
					sb.append(map[i][j]-1).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(r, c, 1));
		
		while(!q.isEmpty()) {
			Point p = q.poll(); 
			
			for(int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 1) continue;
				map[nr][nc] = p.cnt+1;
				q.offer(new Point(nr, nc, p.cnt+1));
			}
		}
	}
	
	

}
