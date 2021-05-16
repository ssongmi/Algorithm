import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 마법사상어와비바라기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] crossR = { -1, -1, 1, 1 };
	static int[] crossC = { -1, 1, -1, 1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Point> cloud = new ArrayList<>();
		cloud.add(new Point(N - 1, 0));
		cloud.add(new Point(N - 1, 1));
		cloud.add(new Point(N - 2, 0));
		cloud.add(new Point(N - 2, 1));
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			// 구름 이동시키기
			v = new boolean[N][N];
			for (int k = 0, size = cloud.size(); k < size; k++) {
				cloud.get(k).r = mod(cloud.get(k).r + dr[d]*s);
				cloud.get(k).c = mod(cloud.get(k).c + dc[d]*s);
				map[cloud.get(k).r][cloud.get(k).c]++;

			}

			// 구름이 있는 칸에 물 1씩 증가
			for (int j = 0, size = cloud.size(); j < size; j++) {
				Point cur = cloud.get(j);
				v[cur.r][cur.c] = true;
				int cnt = 0;
				// 물복사버그 마법 사용
				for (int k = 0; k < 4; k++) {
					int nr = cur.r + crossR[k];
					int nc = cur.c + crossC[k];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0)
						continue;
					cnt++;
				}
				map[cur.r][cur.c] += cnt;
			}

			//
			cloud.clear();
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!v[j][k] && map[j][k] >= 2) {
						map[j][k] -= 2;
						cloud.add(new Point(j, k));
					}
				}
			}
		}
		// 물의 양 카운팅
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
	private static int mod(int num) {
		while(num < 0) {
			num += N;
		}
		return num % N;
	}
}
