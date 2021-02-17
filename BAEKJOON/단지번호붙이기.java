import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단지번호붙이기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int r = 0; r < N; r++) {
			String[] temp = br.readLine().split("");
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(temp[c]);
			}
		}
		int cnt = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					cnt++;
					partN.add(0);
					bfs(r, c);
				}
			}
		}
		sb.append(partN.size() + "\n");
		Object[] ans = partN.toArray();
		Arrays.sort(ans);
		for(int i = 0; i < ans.length; i++) sb.append(ans[i] + "\n");
		System.out.println(sb);
	}
	// 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static ArrayList<Integer> partN = new ArrayList<>();
	static void bfs(int row, int col) {
		map[row][col] = 0;
		partN.add(partN.remove(partN.size()-1)+1);
		for(int i = 0; i < dr.length; i++ ) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 1) continue;
			bfs(nr, nc);	
		}
	}
}
