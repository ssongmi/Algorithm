import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[101][101];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			List<Integer> movement = getMovement(g, d);
			// 움직임 표시
			int nr = x;
			int nc = y;
			map[nr][nc] = true;
			for(int m = 0, size = movement.size(); m < size; m++ ) {
				int cur = movement.get(m);
				nr += dr[cur];
				nc += dc[cur];
				map[nr][nc] = true;
			}
		}
		int res = calc(map);
		System.out.println(res);
	}
	private static int calc(boolean[][] map) {
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) cnt++;
			}
		}
		return cnt;
	}
	public static List<Integer> getMovement(int g, int d) {
		List<Integer> move = new ArrayList<>();
		move.add(d);
		while(g-->0) {
			for(int i = move.size()-1; i >= 0; i-- ) {
				int dir = (move.get(i)+1)%4;
				move.add(dir);
			}
		}
		
		return move;
	}
}
