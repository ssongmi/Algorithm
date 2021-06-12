import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 미로만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] adj;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		bfs();
		System.out.println(min);
	}
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	private static void bfs() {
		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.cnt - o2.cnt;
			}
			
		});
		boolean[][] v = new boolean[N][N];
		q.offer(new Point(0, 0, 0));
		v[0][0] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(cur.r == N-1 && cur.c == N-1) {
				if(min > cur.cnt ) min = cur.cnt;
				break;
			}

			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc])continue;
				if(adj[nr][nc] == 0) q.offer(new Point(nr, nc, cur.cnt+1));
				else q.offer(new Point(nr, nc, cur.cnt));
				v[nr][nc] = true;
			}
		}
	}
}
