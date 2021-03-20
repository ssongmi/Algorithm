import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, T;
	static int[][]map;
	static boolean[][] v;
	static Queue<int[]> q;
	static int nr, nc;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println("p.x = " + p.x + ", p.y = " + p.y);
		// 칼 없이 공주한테 바로 가능방법

		// 칼을 찾아서 공주한테 가는 방법
		bfs(0,0);

		if(len > T) {
			System.out.println("Fail");
		}else {
			System.out.println(len);
		}
		
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int len = Integer.MAX_VALUE;
	static boolean flag = false;
	private static void bfs(int r, int c) {
		q = new LinkedList<>();
		q.offer(new int[] {r, c, 0});
		v = new boolean[N][M];
		while(!q.isEmpty()) {
			int[] n = q.poll();
			v[n[0]][n[1]] = true;
//			System.out.println("n.x = " + n.x + ", n.y = " + n.y);
			if(n[0] == N-1 && n[1] == M-1) {
				len = n[2];
			}
			for(int i = 0; i < 4; i++) {
				nr = n[0] + dr[i];
				nc = n[1] + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc] || (!flag && map[nr][nc]==1)) continue;
				if(map[nr][nc] == 2) flag = true;
				q.offer(new int[]{nr, nc, n[2]+1});
			}
			
		}
	}
}
