import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소문난칠공주 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static char[][] map = new char[5][5];
	
	static int res = 0;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] comb = new int[7];
	static int R = 7;
	static int N = 25;
	static boolean[] adj;
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception{
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		combination(0, 0);
		System.out.println(res);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			adj = new boolean[N];
			for(int i = 0; i < 7; i++) {
				adj[comb[i]] = true;
			}
			int yCnt = 0;
			for(int i = 0; i < N; i++) {
				if(adj[i] && map[i/5][i%5] == 'Y') {
					yCnt++;
				}
			}
			if(yCnt < 4) {
				bfs();
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			comb[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[] v = new boolean[N];
		Point p = new Point(comb[0]/5 , comb[0]%5);
		v[comb[0]] = true;
		q.offer(p);
		int count = 1;
		
		while(!q.isEmpty()) {
			
			Point cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr < 0 || nr > 4 || nc < 0 || nc > 4 || v[nr*5+nc] || !adj[nr*5+nc]) continue;
				count++;
				v[nr*5+nc] = true;
				q.add(new Point(nr, nc));
			}
		}
		if(count == 7) res++;
		
	}
}
