import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PuyoPuyo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static char[][] map = new char[12][6];
	static class Point{
		int r, c, cnt;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	static int res = 0;
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < 12; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < 6; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		search();
		System.out.println(res);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void search() {
		boolean flag = false;
		for(int i = 11; i >= 0; i--) {
			for(int j = 0; j < 6; j++) {
				if(map[i][j] != '.' ) {
					if(bfs(i, j, map[i][j])) flag = true;
				}
			}
		}
		//한줄씩 밑에 빈칸 있으면 내리기
		down();
		if(flag) {
			res++;
			search();
		}
	}
	private static boolean bfs(int r, int c, char color) {
		int cnt = 0;
		boolean[][] v = new boolean[12][6];
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> arr = new ArrayList<>();
		q.offer(new Point(r, c));
		v[r][c] = true;
		arr.add(new Point(r, c));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			cnt++;
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || map[nr][nc] != color || v[nr][nc]) continue;
				v[nr][nc] = true;
				q.offer(new Point(nr, nc));
				arr.add(new Point(nr, nc));
			}
			
		}
		if(cnt > 3) {
			for(int i = 0, size = arr.size(); i < size; i++) {
				Point cur = arr.get(i);
				map[cur.r][cur.c] = '.';
			}
			return true;
		}
		return false;
	}
	private static void down() {
//		for(char[] sub : map)
//			System.out.println(Arrays.toString(sub));
//		System.out.println("-----------------------");
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 6; j++) {
				int temp = i;
				if(map[i][j] != '.' && map[i+1][j] == '.') {
					while(temp >= 0) {
						map[temp+1][j] = map[temp][j];
						map[temp][j] = '.';
						temp--;
					}

				}
			}
		}
//		for(char[] sub : map)
//			System.out.println(Arrays.toString(sub));
//		System.out.println("-----------------------");
	}
}
