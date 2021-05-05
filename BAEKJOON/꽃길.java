import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꽃길 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static boolean [][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(3, 0);
		System.out.println(min);
		
	}
	static int min = Integer.MAX_VALUE;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void dfs(int cnt, int sum) {
		if(cnt == 0) {
			min = sum < min ? sum : min;
			return;
		}
		for(int i = 1 ; i < N-1; i++) {
			out:for(int j = 1; j < N-1; j++) {
				if(v[i][j]) continue;
				int res = 0;
				for(int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if(v[nr][nc]) continue out;
					res += map[nr][nc];
				}
				v[i][j] = true;
				check(i, j, true);
				dfs(cnt-1, sum+res+map[i][j]);
				check(i, j, false);
				v[i][j] = false;
			}
		}
	}
	private static void check(int r, int c, boolean flag) {
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			v[nr][nc] = flag;
		}
	}
}
