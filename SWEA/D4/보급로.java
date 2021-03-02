import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보급로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map, map2;
	static boolean[][] visited;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수만큼 반복하며
		for(int tc = 1; tc <= T; tc++) {
			// 행렬의 크기를 입력받고
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			map2 = new int[N][N];
			visited = new boolean[N][N];
			
			// 행렬을 입력받고
			for(int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split("");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
					map2[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			min = Integer.MAX_VALUE;
			bfs(0,0);
			sb.append(String.format("#%d %d\n", tc, min));
		}
		System.out.println(sb);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int min = Integer.MAX_VALUE;
	// bfs 방식으로 접근하여
	private static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			int[] location = q.poll();
			// 도착지에 접근하면 
			if(location[0] == N-1 && location[1] == N-1) {
				// 현재까지의 값과 비교해서 작으면
				// 값을 갱신
				min = Math.min(map[N-1][N-1], min);
			}
			for(int i = 0; i < 4; i++) {
				int nr = location[0] + dr[i];
				int nc = location[1] + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N ) continue;
				if(!visited[nr][nc] || (visited[nr][nc] && map[nr][nc] > map[location[0]][location[1]]+map2[nr][nc])) {
					q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					map[nr][nc] = map2[nr][nc] + map[location[0]][location[1]];					
				}
			}
		}
	}
}
