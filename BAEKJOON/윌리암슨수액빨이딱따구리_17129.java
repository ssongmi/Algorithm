import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 윌리암슨수액빨이딱따구리_17129 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		// 행렬의 크기 N과 M을 입력받고
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 행렬을 만든 후
		map = new int[N][M];
		v = new boolean[N][M];
		
		int r = -1, c = -1;
		// 행렬의 값을 입력받으면서
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				// 식구 즉, 2인 곳의 행과 열을 따로 저장해놓고
				if(map[i][j] == 2) {
					r = i;
					c = j;
				} 
			}
		}
		// bfs 방식으로 접근
		int ans = bfs(r, c);
		if(ans == -1) {
			System.out.println("NIE");
		}else {
			System.out.println("TAK\n"+ans);
		}
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c, 0});
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = loc[0] + dr[d];
				int nc = loc[1] + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc] || map[nr][nc] == 1) continue;
				if(map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) return loc[2]+1;
				v[nr][nc] = true;
				q.offer(new int[] {nr, nc, loc[2]+1});
			}
		}
		return -1;
	}
}
