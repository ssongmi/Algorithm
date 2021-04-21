import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maaaaaaaaaze {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][][] map = new int[5][5][5];
	static int[][][] map2 = new int[5][5][5];
	static int[] numbers = new int[5];
	static boolean[] v = new boolean[5];
	static class Point{
		int l, r, c, cnt;

		public Point(int l, int r, int c, int cnt) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		// 미로 입력받고
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		// 순서 정하고
		perm(0);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}

	private static void perm(int cnt) {
		if (cnt == 5) {
			// 나온 순서대로 쌓아서
			// 돌려보고
			for(int i = 0; i < 5; i++) {
				int cur = numbers[i];
				for(int j = 0; j < 5; j++) {
					for(int k = 0; k < 5; k++) {
						map2[i][j][k] = map[cur][j][k];
					}
				}
			}
			rotate(0);
		}
		for (int i = 0; i < 5; i++) {
			if (v[i])
				continue;
			numbers[cnt] = i;
			v[i] = true;
			perm(cnt + 1);
			v[i] = false;
		}
	}

	private static void rotate(int cnt) {
		if(cnt == 5) {
			// 탈출해보고
			if(map2[0][0][0] == 1) bfs(0, 0, 0);
			
			return;
		}
		for (int j = 0; j < 4; j++) {
			// 오른쪽으로 돌리기
			rotateRight(cnt);
			rotate(cnt+1);
		}

	}


	private static void rotateRight(int cnt) {
		int[][] temp = new int[5][5];
		// 먼저 담아놓고
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				temp[i][j] = map2[cnt][i][j];
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map2[cnt][i][j] = temp[4-j][i];
			}
		}
	}
	static int[] dl = {0, 0, 0, 0, -1, 1};
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int min = Integer.MAX_VALUE;
	private static void bfs(int l, int r, int c) {
		boolean[][][] v = new boolean[5][5][5];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(l, r, c, 0));
		v[l][r][c] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(cur.l == 4 && cur.r == 4 && cur.c == 4) {
				min = min > cur.cnt ? cur.cnt : min;
				return;
			}
			
			for(int i = 0; i < 6; i++) {
				int nl = cur.l + dl[i];
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if(nl < 0 || nl > 4 || nr < 0 || nr > 4 || nc < 0 || nc > 4 || v[nl][nr][nc] || map2[nl][nr][nc] == 0) continue;
				q.offer(new Point(nl, nr, nc, cur.cnt+1));
				v[nl][nr][nc] = true;
			}
		}
	}

}
