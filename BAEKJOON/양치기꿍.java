import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양치기꿍 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int sheep, wolf;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sheep = 0;
		wolf = 0;
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != '#' && map[i][j] != 'x') bfs(i, j);
			}
		}

		System.out.println(sheep + " " + wolf);
	}
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		int w = 0, s = 0;
		if(map[r][c] == 'v') {
			w++;
		}else if(map[r][c] == 'k'){
			s++;
		}
		map[r][c] = 'x';
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'x' || map[nr][nc] == '#') continue;
				if(map[nr][nc] == 'v') {
					w++;
				}else if(map[nr][nc] == 'k'){
					s++;
				}
				map[nr][nc] = 'x';
				q.offer(new Point(nr, nc));
			}
		}

		if(w >= s) wolf += w;
		else sheep += s; 
	}
}
