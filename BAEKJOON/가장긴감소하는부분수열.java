import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 가장긴감소하는부분수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map = new int[5][5];
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		//숫자판을 배열에 저장하고
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		//임의의 점부터 시작한다. -> 모든 점들을 시작점으로 
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				dfs(i, j, 0, 0);
			}
		}
		System.out.println(set.size());
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};	
	private static void dfs(int r, int c, int idx, int number) {
		// dfs방식으로 순회하면서
		// 사방으로 이동할 수 있게 하면서
		// 이동횟수가 5번이 되면 hashset에 넣을 수 있도록함
		if(idx == 6) {
			set.add(number);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(r+dr[i] < 0 || r + dr[i] >= 5 || c + dc[i] < 0 || c + dc[i] >= 5) continue;
			int nr = r + dr[i];
			int nc = c + dc[i];
			int newNumber = number + (int)(map[nr][nc]*Math.pow(10, (5-idx)));
			dfs(nr, nc, idx+1, newNumber);
		}
	}
}
