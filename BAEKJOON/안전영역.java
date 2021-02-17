import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안전영역 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, cnt;
	static int[][] map, copyMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		copyMap = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());		
			}
		}
		int max = 0;
		for(int i = 0; i <= 100; i++) {
			cnt = 0;
			for(int j = 0; j < N; j++) 
				copyMap[j] = Arrays.copyOf(map[j], map[j].length);
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(copyMap[r][c] > i) {
						cnt++;
						dfs(r, c, i);
					}
				}
			}
			max = cnt > max ? cnt : max;
		}
		System.out.println(max);
		
	}
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	private static void dfs(int row, int col, int rain) {
		copyMap[row][col]= -1;

		for(int d = 0; d < 4; d++) {
			int nr = row + dr[d];
			int nc = col + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || copyMap[nr][nc] <= rain) continue;
			dfs(nr, nc, rain);
		}
	}
}
