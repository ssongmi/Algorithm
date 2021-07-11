import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 침투 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean flag = false;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for(int i = 0; i < C; i++) {
			if(map[0][i] == 0) dfs(0, i);
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	private static void dfs(int r, int c) {
		
		if(r == R-1) flag = true;
		
		map[r][c] = 2;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != 0) continue;
			dfs(nr, nc);
		}
	}
}
