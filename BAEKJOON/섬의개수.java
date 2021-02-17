import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 섬의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map;
	static int w, h;
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];

			for(int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int r = 0; r < h; r++) {
				for(int c = 0; c < w; c++) {
					if(map[r][c] == 1) {
						cnt++;
						search(r, c);
						
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	// 상하좌우 후 대각선
	static int[] dr = {-1, 0, 1, 0, -1, 1, 1, -1};
	static int[] dc = {0, 1, 0, -1, 1, 1, -1, -1};
	private static void search(int row, int col) {
		for(int i = 0; i < dr.length; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if( nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 1) {
				map[nr][nc] = 0;
				search(nr, nc);	
				
			}
		}
	}
}
