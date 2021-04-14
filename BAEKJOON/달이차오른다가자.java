import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이차오른다가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C;
	static char[][] map;
	static boolean[][][] v;
	static class Point{
		int r, c, key, cnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			
		}

		public Point(int r, int c, int key) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
		}

		public Point(int r, int c, int key, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", key=" + key + ", cnt=" + cnt + "]";
		}
		
	}
	static Point start;
	static ArrayList<Point> dest = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		v = new boolean[R][C][1<<7];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0') start=new Point(i, j);
				else if(map[i][j] == '1') dest.add(new Point(i, j));
			}
		}
		
		int res = bfs();
		System.out.println(res);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(start.r, start.c, 1, 0));
		v[start.r][start.c][1] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				// 도착지에 오면
				for(int j = 0, size = dest.size(); j < size; j++ ) {
					if(nr == dest.get(j).r && nc == dest.get(j).c) {
						return cur.cnt+1;
					}					
				}
				if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '#' || v[nr][nc][cur.key]) continue;
				
				int key = 1;
				// 키를 만나면
				if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					key = 1 << (map[nr][nc]-'a'+1);
				}
				
				// 문에 만났을 경우
				if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					//해당 키가 있는지 판단
					if((cur.key & (1 << (map[nr][nc]-'A'+1))) != 1<<(map[nr][nc]-'A'+1)) // 해당 키가 없으면 다음 차례 탐색
						continue;		
				}
				// 그냥 길인 경우(.) 포함
				v[nr][nc][cur.key] = true;
				q.offer(new Point(nr, nc, cur.key | key, cur.cnt+1));
			}
			
		}
		// 도착 못하면
		return -1;
	}
}
