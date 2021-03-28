import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] map;

	static class Point implements Comparable<Point> {
		int r, c, value, cnt;

		public Point(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}

		public Point(int r, int c, int value, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", value=" + value + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Point o) {

			return Counter(shark.r, shark.c, this.r, this.c) - Counter(shark.r, shark.c, o.r, o.c);

		}

	}

	static Point shark;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9)
					shark = new Point(i, j, 2);
			}
		}
//		System.out.println(shark);
		int count = 0;
		int exp = 2;
		int temp = 0;
//		boolean flag = false;
		while (true) {

			PriorityQueue<Point> list = new PriorityQueue<>();
			// 찾고
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 9 && map[i][j] != 0 && map[i][j] < shark.value && bfs(shark.r, shark.c, i, j))
						list.add(new Point(i, j, map[i][j]));
				}
			}
//			System.out.println(Arrays.toString(list.toArray()));

			if (list.isEmpty())
				break;
			// 이동가능한 리스트 중에 이동할 수 있는 곳이 있으면
			boolean flag = false;
			for (int i = 0, size = list.size(); i < size; i++) {
				// 이동 시킴
				Point p = list.poll();
				if (bfs(shark.r, shark.c, p.r, p.c)) {
//					for (int[] sub : map)
//						System.out.println(Arrays.toString(sub));
					count += cnt;
					// 먹었으면
					temp++;
					map[shark.r][shark.c] = 0;
					shark.r = p.r;
					shark.c = p.c;
					map[shark.r][shark.c] = 9;
					if (exp == temp) {
						shark.value += 1;
						exp++;
						temp = 0;
					}
					flag = true;
//					System.out.println("r = " + shark.r + ", c = " + shark.c + ", value = " + shark.value + ", cnt = " + count);
					break;
					
				}
			}
			if(!flag)break;
		}
		System.out.println(count);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static boolean bfs(int r, int c, int destR, int destC) {
		boolean[][] v = new boolean[N][N];
		boolean flag = false;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c, map[r][c], 0));
		v[r][c] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.r == destR && p.c == destC) {
				flag = true;
				cnt = p.cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc] || v[nr][nc] || map[nr][nc] > shark.value)
					continue;
				v[nr][nc] = true;
				q.offer(new Point(nr, nc, map[nr][nc], p.cnt + 1));
			}
		}
		return flag;
	}
	private static int Counter(int r, int c, int destR, int destC) {
		boolean[][] v = new boolean[N][N];
		int cnt = Integer.MAX_VALUE;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c, map[r][c], 0));
		v[r][c] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.r == destR && p.c == destC) {
				cnt = p.cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc] || v[nr][nc] || map[nr][nc] > shark.value)
					continue;
				v[nr][nc] = true;
				q.offer(new Point(nr, nc, map[nr][nc], p.cnt + 1));
			}
		}
		return cnt;
	}
}
