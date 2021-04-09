import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 영역구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C, K;
	static int[][] map;
	static boolean[][] v;
	static class Point{
		int r, c, cnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		v = new boolean[R][C];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(st.nextToken());
			int sr = Integer.parseInt(st.nextToken());
			int dc = Integer.parseInt(st.nextToken());
			int dr = Integer.parseInt(st.nextToken());
			fill(sr, sc, dr, dc);
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 0 && !v[i][j]) {
					cnt++;
					list.add(bfs(i, j));
				}
			}
		}
		System.out.println(cnt);
		Object[] ans = list.toArray();
		Arrays.sort(ans);
		for(int i = 0, size = ans.length; i <size; i++ ) {
			System.out.print(ans[i] + " ");
		}
	}
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		map[i][j] = 1;
		v[i][j] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			cnt++;
			for(int k = 0; k < 4; k++) {
				int nr = cur.r + dr[k];
				int nc = cur.c + dc[k];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 1 || v[nr][nc]) continue;
				v[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}
		return cnt;
	}
	private static void fill(int sr, int sc, int dr, int dc) {
		for(int r = sr; r < dr; r++) {
			for(int c = sc; c < dc; c++) {
				map[r][c] = 1;
			}
		}
		
	}
}
