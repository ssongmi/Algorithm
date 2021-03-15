import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 적록색약_10026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static char[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N*N의 행렬을 나타내는 N을 입력받고
		N = Integer.parseInt(br.readLine());
		
		// N*N 행렬을 만들어서
		map = new char[N][N];
		
		// 그 내용을 입력받고
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				map[i][j] = tmp[j].charAt(0);
			}
		}
//		for(char[] sub : map)
//			System.out.println(Arrays.toString(sub));
		// dfs 방식으로 구함
		setRGB();
		System.out.println(sb);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int RGBCnt = 0;
	static int RGCnt = 0;
	private static void setRGB() {
		
		// 적록색약이 아닌 사람이 봤을 때와
		RGBCnt = 0;
		v = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!v[i][j]) {
					RGBCnt++;
					RGB(i,j, map[i][j]);
				}
			}
		}
		sb.append(RGBCnt + " ");
		// 적록색약인 사람이 봤을 때 영역 수를
		RGCnt = 0;
		v = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!v[i][j]) {
					RGCnt++;
					RG(i,j, map[i][j]);
				} 
			}
		}
		sb.append(RGCnt);
	}
	private static void RGB(int r , int c, char ch) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc]) continue;
			if(map[nr][nc] == map[r][c]) {
				v[nr][nc] = true;
				RGB(nr, nc, map[nr][nc]);				
			}
		}
		
	}
	private static void RG(int r, int c, char ch) {
		// TODO Auto-generated method stub
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc]) continue;
			if(map[nr][nc] == map[r][c] || (map[nr][nc] == 'R' && map[r][c] == 'G')
					|| (map[nr][nc] == 'G' && map[r][c] == 'R')) {				
				v[nr][nc] = true;
				RG(nr, nc, map[nr][nc]);
			} 
		}
	}
	
}
