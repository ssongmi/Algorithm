import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역bfs_성공 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, maxRain;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N을 입력받고
		N = Integer.parseInt(br.readLine());
		
		// N*N행렬을 만들고
		map = new int[N][N];
		v = new boolean[N][N];
		// 행렬에 대한 정보를 입력받고
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxRain = Math.max(maxRain, map[i][j]);
			}
		}

		int ans = 1;
		// 비의 양을 0부터 행렬값중 최대값까지 반복해서 찾고
		for(int i = 0; i <= maxRain; i++) {
			v = new boolean[N][N];
			int value = getArea(i);
			// 해당 값이 기존까지의 최대값보다 크면 갱신
			ans = Math.max(ans, value);
		}
		System.out.println(ans);
	}
	
	private static int getArea(int rain) {
		int value = 0;
		for(int i = 0; i < N; i++ ) {
			for(int j = 0; j < N; j++) {
				if(!v[i][j] && map[i][j] > rain) {
					value++;
					bfs(i, j, rain);					
				}
			}
		}
		return value;
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void bfs(int r, int c, int rain) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		v[r][c] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0;  d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc] || map[nr][nc] <= rain) continue;
				v[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
			
			
		}
		
	}
}
