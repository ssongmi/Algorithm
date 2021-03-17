import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static char[][] map;
	static boolean[] v;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// N과 M을 입력받고
		st = new StringTokenizer(br.readLine());

		// N*M행렬을 만들고
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];
		v = new boolean['Z' + 1];
		// 정보를 입력받음
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j].charAt(0);
			}
		}
		visited[0][0] = true;
		v[map[0][0]] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int max = Integer.MIN_VALUE;

	private static void dfs(int r, int c, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[map[nr][nc]] || visited[nr][nc])
				continue;
			v[map[nr][nc]] = true;
			visited[nr][nc] = true;
			dfs(nr, nc, cnt + 1);
			v[map[nr][nc]] = false;
			visited[nr][nc] = false;
		}
		if (cnt > max)
			max = cnt;
	}

}
