import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, R, C, time;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 테스트 케이스 수만큼 반복하며
			st = new StringTokenizer(br.readLine());

			// 세로크기 N, 가로크기 M, 맨홀뚜껑이 위치한 장소 R,C를 입력받음
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];

			// 지하터널 정보를 입력받은 (N*M)
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(R, C);
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j])
						cnt++;
				}
			}

			sb.append(String.format("#%d %d\n", tc, cnt));

		}
		System.out.println(sb);
	}

	static int[][] dir = { { 1, 2, 5, 6 }, { 1, 3, 6, 7 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 } };
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// bfs 방식을 이용하여
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c, 0 });
		while (!q.isEmpty()) {

			int[] location = q.poll();
			visited[location[0]][location[1]] = true;
			if (location[2] == time - 1)
				break;

			if (map[location[0]][location[1]] == 1) {
				for (int i = 0; i < 4; i++) {
					int nr = location[0] + dr[i];
					int nc = location[1] + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
						for (int j = 0; j < 4; j++) {
							if (map[nr][nc] == dir[i][j]) {
								q.offer(new int[] { nr, nc, location[2] + 1 });
								visited[nr][nc] = true;
								break;
							}
						}
					}
				}
			} else if (map[location[0]][location[1]] <= 3) {
				int order = map[location[0]][location[1]] % 4;
				int nr = location[0] + dr[order];
				int nc = location[1] + dc[order];
				for (int i = 0; i < 4; i++) {
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && dir[order][i] == map[nr][nc]) {
						q.offer(new int[] { nr, nc, location[2] + 1 });
						visited[nr][nc] = true;
						break;
					}
				}
				order = (map[location[0]][location[1]] + 2) % 4;
				nr = location[0] + dr[order];
				nc = location[1] + dc[order];
				for (int i = 0; i < 4; i++) {
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && dir[order][i] == map[nr][nc]) {
						q.offer(new int[] { nr, nc, location[2] + 1 });
						visited[nr][nc] = true;
						break;
					}
				}
			} else {
				int order = map[location[0]][location[1]] % 4;
				int nr = location[0] + dr[order];
				int nc = location[1] + dc[order];
				for (int i = 0; i < 4; i++) {
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && dir[order][i] == map[nr][nc]) {
						q.offer(new int[] { nr, nc, location[2] + 1 });
						visited[nr][nc] = true;
						break;
					}
				}
				order = (map[location[0]][location[1]] + 1) % 4;
				nr = location[0] + dr[order];
				nc = location[1] + dc[order];
				for (int i = 0; i < 4; i++) {
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && dir[order][i] == map[nr][nc]) {
						q.offer(new int[] { nr, nc, location[2] + 1 });
						visited[nr][nc] = true;
						break;
					}
				}
			}
		}
	}
}
