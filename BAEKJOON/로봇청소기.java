import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static boolean[][] v;
	static int[][] map;

	static class Point {
		int r, c, d;

		public Point(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		Point robot = new Point(r, c, d);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		v[robot.r][robot.c] = true;
		out: while (true) {
			int nd = robot.d;
			int nr = robot.r;
			int nc = robot.c;
			for (int i = 0; i < 4; i++) {
				nd = (nd + 3) % 4;
				nr = robot.r + dr[nd];
				nc = robot.c + dc[nd];
				if (map[nr][nc] == 1 || v[nr][nc])
					continue;
				robot.r = nr;
				robot.c = nc;
				robot.d = nd;
				v[robot.r][robot.c] = true;
				cnt++;
				continue out;
			}

			robot.r -= dr[robot.d];
			robot.c -= dc[robot.d];
	
			if (map[robot.r][robot.c] == 1)
				break out;

		}

		System.out.println(cnt);

	}
}
