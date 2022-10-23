import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] adj;
	static int N, M, res = Integer.MAX_VALUE;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Point> virus = new ArrayList<>();
	static ArrayList<Point> pos = new ArrayList<>();
	static int[] selected;
	static class Point {
		int r, c, day;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}
		
	}
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new int[N][N];
		selected = new int[M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				if(adj[i][j] == 2) {
					pos.add(new Point(i, j));
				}
			}
		}
		setVirus(0, 0);
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}
	}
	private static void setVirus(int cnt, int start) {
		if(cnt == M) {
			bfs();
			return;
		}
		
		for(int i = start, len = pos.size(); i < len; i++) {
			selected[cnt] = i;
			setVirus(cnt+1, i+1);
		}
		
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(adj[i], N);
		}
		for(int i = 0, len = selected.length; i < len; i++ ) {
			Point virus = pos.get(selected[i]);
			q.offer(new Point(virus.r, virus.c, 0));
			map[virus.r][virus.c] = 3;
		}
		int cnt = -1;
		
		while(!q.isEmpty()) {
			cnt++;
			for(int i = 0, len = q.size(); i < len; i++ ) {
				Point cur = q.poll();
				for(int j = 0; j < 4; j++) {
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];
					
					if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1 || map[nr][nc] == 1 || map[nr][nc] == 3) continue;
					
					map[nr][nc] = 3;
					q.offer(new Point(nr, nc, cur.day + 1));
				}
			}
			
		}
		
		if(check(map)) {
			res = Math.min(res, cnt);
		}
	}
	private static boolean check(int[][] map) {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					return false;
				} 
			}
		}
		return true;
	}
}
