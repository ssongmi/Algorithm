import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 등산로조성 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 개수 받기
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// 테스트 케이스 수 만큼 반복하면서
			st = new StringTokenizer(br.readLine());
			
			// N과 K를 입력받고
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			// 지도를 입력받으면서 최대값을 찾음
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > max) max = map[i][j];
				}
			}
			
			// 지도를 다시한번 순회하며 최대값이 나오면 가능한 등산로의 길이를 찾음
			ArrayList<int[]> arr = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == max) arr.add(new int[] {i, j});
				}
			}
			maxL = 1;
//			System.out.println(Arrays.toString(arr.toArray()));
			for(int i = 0, size=arr.size(); i < size; i++) {
				int[] loc = arr.get(i);
				visited = new boolean[N][N];
				visited[loc[0]][loc[1]] = true;
				dfs(loc[0], loc[1], 1, 1);
				
			}
			sb.append(String.format("#%d %d\n", tc, maxL));
			// 등산로 길이를 찾을 때는 bfs 방식으로 접근하면서
			// 현재보다 높거나 같더라도 깎을 기회가 남아있으면 
			// 현재보다 1작은값이 되기 위해 K와 같거나 작은수가 필요하면 진행
		}
		System.out.println(sb);
	}
	static int maxL = 1;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0,0, -1, 1};
	private static void dfs(int r, int c, int cut, int len) {
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			// 현재보다 같거나 크지만 깎아서 갈 수 있는 경우
			if(cut == 1 && map[nr][nc] >= map[r][c] && map[nr][nc] - map[r][c] < K) {
				int temp = map[nr][nc];
				map[nr][nc] = map[r][c] - 1;
				cut = 0;
				visited[nr][nc] = true;
				dfs(nr, nc, cut, len+1);
				visited[nr][nc] = false;
				map[nr][nc] = temp;
				cut = 1;
			} else if(map[r][c] > map[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, cut, len+1);
				visited[nr][nc] = false;
			}
		}
		if(len > maxL) maxL = len;
	}
}
