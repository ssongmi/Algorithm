package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 알고스팟 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, wallCnt;
	static int[][] map;
	static boolean[][] v;

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		v = new boolean[N][M];
		map = new int[N][M];
		wallCnt = 0;
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if (map[i][j] == 1)
					wallCnt++;
			}
		}
//		System.out.println(wallCnt);
		bfs();
		System.out.println(min);

	}

	static int min = Integer.MAX_VALUE;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs() {
		Deque<Point> q = new LinkedList<>();
		q.addLast(new Point(0, 0, 0));
		v[0][0] = true;
		while (!q.isEmpty()) {
			Point p = q.pollLast();
			if (p.r == N - 1 && p.c == M - 1) {
				min = Math.min(min, p.cnt);
			} else {
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
//					System.out.println("nr = " + nr + ", nc = " + nc + ", cnt = " + p.cnt);
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc]) continue;		
					if(map[nr][nc] == 0) {
						q.addLast(new Point(nr, nc, p.cnt));
					}else if(map[nr][nc] == 1) {
						q.addFirst(new Point(nr, nc, p.cnt+1));
					}
					v[nr][nc] = true;

				}

			}

		}
	}
}
