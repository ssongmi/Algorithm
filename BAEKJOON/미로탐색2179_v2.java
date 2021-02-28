import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색2179_v2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int r, c;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// 행과 열의 수 입력받기
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// 배열 만들기
		map = new int[r][c];
		visited = new boolean[r][c];
		// 배열 입력받기
		for(int i = 0; i < r; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0; j < c; j++)
				map[i][j] = Integer.parseInt(tmp[j]);
		}
		bfs(0,0);
		System.out.println(map[r-1][c-1]);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int min = Integer.MAX_VALUE;
	private static void bfs(int row, int col) {
		Queue<int[]> coord = new LinkedList<>();
		coord.offer(new int[] {row, col});
		
		while(!coord.isEmpty()) {
			int[] location = coord.poll();
			visited[location[0]][location[1]] = true;
			for(int i = 0; i < 4; i++) {
				int nr = location[0] + dr[i];
				int nc = location[1] + dc[i];
				
				if(nr >= 0 && nr < r && nc >= 0 && nc < c && map[nr][nc] == 1 && !visited[nr][nc]) {
					coord.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					map[nr][nc]  = map[location[0]][location[1]] + 1;
				} 
			}
		}
	}
}
