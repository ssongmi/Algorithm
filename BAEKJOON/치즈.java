import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C;
	static int cheeseCnt;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Point{
		int r, c;
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
		
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheeseCnt++;
			}
		}
		int res = 0, time = 0;
		
		while(cheeseCnt != 0) {
			time++;
			res = cheeseCnt;
			bfs(0,0);
		}
		System.out.println(time);
		System.out.println(res);
	}
	static int cnt = 0;
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] v= new boolean[R][C];
		q.offer(new Point(r, c));
		v[r][c] = true;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C  ||v[nr][nc]) continue;
				if(map[nr][nc] == 1) {
					cheeseCnt--;
					map[nr][nc] = 0;
				}else {
					q.offer(new Point(nr, nc));
				}
				v[nr][nc] =true;	
			}
			
		}
	}
}
