import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수지의수지맞는여행 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C;
	static char[][] map; 
	static int[] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수만큼 반복하면서
		for(int tc = 1; tc <= T; tc++) {
			// R과 C를 입력받고
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			// 명물 정보를 R*C 배열에 입력받고
			map = new char[R][C];
			visited = new int['z'+1];
			for(int i = 0; i < R; i++) {
				String[] tmp = br.readLine().split("");
				for(int j = 0; j < C; j++)
					map[i][j] = tmp[j].charAt(0);
			}
			max = 0;
			visited[map[0][0]]++;
			dfs(0,0,1);
			sb.append(String.format("#%d %d\n", tc, max));
		}
		System.out.println(sb);
	}
	static int max = 0;
	private static void dfs(int r, int c, int maxVenue) {
		// 0행 0열부터 시작해서 상하좌우를 살피며
		for(int d = 0; d < 4; d++) {
			// 해당 알파벳을 본게 총 1회 보다 크지 않도록 하여
			if(r+dr[d] < 0 || r + dr[d] >= R || c + dc[d] < 0 || c+ dc[d] >= C || visited[map[r+dr[d]][c+dc[d]]] > 0) continue;
			int nr = r + dr[d];
			int nc = c + dc[d];
			visited[map[nr][nc]]++;
			// 방문하고
			dfs(nr, nc, maxVenue+1);
			visited[map[nr][nc]]--;
		}
		if(maxVenue > max) {
			// 더 이상 갈 수 있는 곳이 없으면max값과 비교하여 갱신
			max = maxVenue;
			return;
		}
		
	}
}
