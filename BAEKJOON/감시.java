import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 감시 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, res = Integer.MAX_VALUE;
	static char[][] map;
	static ArrayList<Point> cctv = new ArrayList<>();
	static class Point{
		int r, c, type, dir;

		public Point(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}

		public Point(int r, int c, int type, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", type=" + type + ", dir=" + dir + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		int wallCnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] > '0' && map[i][j] < '6') cctv.add(new Point(i, j, map[i][j]-'0'));
				else if (map[i][j] == '6') wallCnt++;
			}
		}
		changeDir(0);
		if(res == Integer.MAX_VALUE) System.out.println(N*M-wallCnt);
		else System.out.println(res-wallCnt);
	}
	static int[][][] dr = {{{}},{{0}, {1}, {0}, {-1}}, {{0, 0}, {-1, 1}}, {{-1, 0},{0, 1},{1, 0}, {0, -1}}, {{-1, 0, 0}, {-1, 0, 1}, {0, 1, 0}, {1, 0, -1}}, {{0, 0, -1, 1}}}; 
	static int[][][] dc = {{{}},{{1}, {0}, {-1}, {0}}, {{1, -1}, {0, 0}}, {{0, 1},{1, 0},{0, -1}, {-1, 0}}, {{0, 1, -1}, {0, 1, 0}, {1, 0, -1}, {0, -1, 0}}, {{-1, 1, 0, 0}}}; 
	private static void changeDir(int cnt) {
		if(cnt == cctv.size()) {
			// 다 바꾸면 cctv 마다 감시영역을 세어보고
			bfs();
			return;
		}
		// cctv의 방향을 하나씩 바꿔보고
		for(int i = 0, size = dr[cctv.get(cnt).type].length; i < size; i++) {
			cctv.get(cnt).dir = i;
			changeDir(cnt+1);
		}
		
	}
	static int idx = 0;
	private static void bfs() {
		boolean[][] v = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		
		for(int i = 0, size = cctv.size(); i < size; i++ ) {
			Point cur = cctv.get(i);
			q.offer(new Point(cur.r, cur.c, cur.type, cur.dir));
			v[cur.r][cur.c] = true;
		}
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i = 0, size = dr[cur.type][cur.dir].length; i < size; i++) {
				// 범위를 빠져나갈 때까지 계속감
				int nr = cur.r;
				int nc = cur.c;
				while(true) {
					
					nr += dr[cur.type][cur.dir][i];
					nc += dc[cur.type][cur.dir][i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '6' ) break;
					if(v[nr][nc]) continue;
					v[nr][nc] = true;
				}
			}
		}
		// 방문하지 못한 곳의 수를 계산
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!v[i][j])cnt++;
			}
		}
		res = res > cnt ? cnt : res;
	}
	
}
