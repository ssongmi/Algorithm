import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] distance;
	static boolean[][] v;
	static int N;
	static int[][] adj;
	static class Point implements Comparable<Point>{
		int r, c, value;

		public Point(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}

		@Override
		public int compareTo(Point o) {
			return this.value - o.value;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int idx = 0;
		while(true) {
			idx++;
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			adj = new int[N][N];
			distance = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			sb.append("Problem " + idx + ": " + bfs() + "\n");
			
		}
		System.out.println(sb);
	}
	static int bfs() {
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.offer(new Point(0, 0, adj[0][0]));
		distance[0][0] = adj[0][0];
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(distance[nr][nc] > distance[cur.r][cur.c] + adj[nr][nc]) {
					distance[nr][nc] = distance[cur.r][cur.c] + adj[nr][nc];
					q.offer(new Point(nr, nc, distance[nr][nc]));
				}
			}
		}
		return distance[N-1][N-1];
	}
}
