import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 미세먼지안녕 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C, T;
	static int[][] map;
	static int[][] copyMap;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };
	static ArrayList<Point> air = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) air.add(new Point(i, j));
			}
		}

		
		for (int i = 0; i < T; i++) {
			copyMap = new int[R][C];
			search();
			calc();
			cycle();
		}
		int res = 0;
		for(int i = 0; i < R; i++) {
			for(int j =0; j < C; j++) {
				if(map[i][j] > 0) res += map[i][j];
			}
		}
		System.out.println(res);
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	private static void search() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					spread(i, j);
				}
			}
		}

	}

	private static void spread(int r, int c) {
		int val = map[r][c] / 5;
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1)
				continue;
			cnt++;
			copyMap[nr][nc] += val;
		}
		map[r][c] -= val * cnt;
	}

	private static void calc() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += copyMap[i][j];
			}
		}

	}

	private static void cycle() {
		int r, c, nr, nc;
		for(int j = 0; j < 2; j++) {
			r = nr = air.get(j).r;
			c = nc = air.get(j).c;
			int value = -1;
			int i = 0;
			while(true) {
				
				nr = r + dr[i]*(int)Math.pow(-1, j);
				nc = c + dc[i];
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
					i = (i+1)%4;
					nr = r + dr[i]*(int)Math.pow(-1, j);
					nc = c + dc[i];
				}
				if(nr == air.get(j).r && nc == air.get(j).c) break;
				int next = map[nr][nc];
				map[nr][nc] = value;
				value = next;
				r = nr;
				c = nc;
			}
		}
		for(int j = 0; j < 2; j++) {
			int airR = air.get(j).r;
			int airC = air.get(j).c;
			map[airR][airC] = -1;
			map[airR][airC+1] = 0;
		}
	}

}
