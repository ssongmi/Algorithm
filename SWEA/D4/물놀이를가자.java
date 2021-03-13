import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물놀이를가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] len;
	static char[][] map;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 수만큼 반복하며
		for (int tc = 1; tc <= T; tc++) {
			// N과 M을 입력받고
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// 거리를 나타내는 행렬을 만들고
			len = new int[N][M];
			map = new char[N][M];

			// 물들의 좌표를 기억
			ArrayList<int[]> coord = new ArrayList<>();
			// 물인지 땅인지를 나타내는 N*M 행렬의 값을 입력받고
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split("");
				for (int j = 0; j < M; j++) {
					map[i][j] = tmp[j].charAt(0);
					len[i][j] = Integer.MAX_VALUE;
					// 물인 곳을 기억해서
					if (map[i][j] == 'W') {
						q.offer(new int[] {i, j, 0});
						len[i][j] = 0;
					}
				}
			}
			
			bfs();
//			for(int[] sub : len)
//				System.out.println(Arrays.toString(sub));
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					cnt += len[i][j];
				}
			}
			sb.append(String.format("#%d %d\n", tc, cnt));
			// bfs 방식으로 접근하여
			// 원래 있던 값이 크면 현재 값으로 갱신

		}
		System.out.println(sb);
		br.close();
		System.exit(0);


	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<int[]> q = new LinkedList<>();
	private static void bfs() {
		while (!q.isEmpty()) {
			for(int j = 0, size = q.size(); j < size; j++) {
				int[] loc = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = loc[0] + dr[i];
					int nc = loc[1] + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'W' || len[nr][nc] <= len[loc[0]][loc[1]] + 1)
						continue;
					len[nr][nc] =  len[loc[0]][loc[1]] + 1;
					q.offer(new int[] { nr, nc });					
				}
				
			}

		}

	}
}
