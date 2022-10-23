import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, res = 0;
	static char[][] adj;
	static boolean[][] v;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Point start;
	static ArrayList<Point> friends = new ArrayList<>();
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new char[N][M];
		v = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			adj[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				if(adj[i][j] == 'I') { start = new Point(i, j); }
				else if(adj[i][j] == 'P') { friends.add(new Point(i, j)); }
			}
		}
		bfs();
		if(res == 0) {
			System.out.println("TT");
		} else {
			System.out.println(res);
		}
		
		
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		v[start.r][start.c] = true;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1 || adj[nr][nc] == 'X' || v[nr][nc]) continue;
				if(adj[nr][nc] == 'P') res++;
				v[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}
	}

}
