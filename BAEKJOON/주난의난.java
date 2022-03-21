import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주난의난 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, res = 0;
	static char[][] map, temp;
	static boolean[][] v;
	static Point junan, theif;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Point {
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

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		temp = new char[N][M];
		st = new StringTokenizer(br.readLine());
		
		junan = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		theif = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		while(true) {
			res++;
			copy(temp, map);
			v = new boolean[N][M];
			if(bfs()) break;
			copy(map, temp);
		}
		System.out.println(res);
		
	}

	private static boolean bfs() {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(junan.r, junan.c, 0));
		
		v[junan.r][junan.c] = true;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1 || v[nr][nc]) continue;
				v[nr][nc] = true;
				if(map[nr][nc] == '#') return true;
				if(map[nr][nc] == '1') {
					temp[nr][nc] = '0'; 
					continue;
				}
				q.offer(new Point(nr, nc));
			}
		}
		return false;
		
	}
	
	private static void copy(char[][] dest, char[][] source) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dest[i][j] = source[i][j];
			}
		}
	}
	
	

}
