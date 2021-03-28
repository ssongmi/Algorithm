import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	static class Point {
		int h, r, c, day;

		public Point(int h, int r, int c, int day) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
			this.day = day;
		}

	}

	static int M, N, H, cnt;
	static int[][][] tomato;
	static boolean[][][] v;
	static int ans = -1;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tomato = new int[H][N][M];
		v = new boolean[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if (tomato[i][j][k] == 0)
						cnt++;
				}
			}
		}
		if (cnt == 0) {
			System.out.println(cnt);
			System.exit(0);
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tomato[i][j][k] == 1) {
						q.offer(new Point(i, j, k, 0));
						v[i][j][k] = true;
					}
				}
			}
		}
		bfs();
		if (flag)
			System.out.println(ans);
		else
			System.out.println(-1);

	}

	static Queue<Point> q = new LinkedList<>();
	private static void bfs() {
		flag = false;
		while(!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point p = q.poll();
				if (cnt == 0) {
					ans = p.day;
					flag = true;
					break;
				}
//				System.out.println("nh = " + p.h + ", nr = " + p.r + ", nc = " + p.c + ", day = " + p.day);
				for (int i = 0; i < 6; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					int nh = p.h + dh[i];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H || v[nh][nr][nc]
							|| tomato[nh][nr][nc] != 0)
						continue;
					v[nh][nr][nc] = true;
					tomato[nh][nr][nc] = 1;
					cnt--;
					q.offer(new Point(nh, nr, nc, p.day + 1));
				}
			}
		}

	}
}
