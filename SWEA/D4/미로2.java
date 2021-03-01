import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// 테스트 케이스 10개 동안 반복하며
		for(int tc = 1; tc <= 10; tc++) {
			// 테스트 케이스 번호 입력받기
			st = new StringTokenizer(br.readLine());
			// 지도를 입력받고
			map = new int[100][100];
			visited = new boolean[100][100];
			
			// 출발점 저장
			int sX = 0, sY = 0;
			// 도착점 저장
			int eX = 0, eY = 0;
			for(int i = 0; i < 100; i++) {
				String[] tmp = br.readLine().split("");
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
					if(map[i][j] == 2) {sX = i; sY = j;}
					if(map[i][j] == 3) {eX = i; eY = j;}
				}
			}
			// bfs 방식으로
			int ans = bfs(sX, sY, eX, eY);
			sb.append(String.format("#%d %d\n", tc, ans));
		}
		System.out.println(sb);
		
	}
	private static int bfs(int sX, int sY, int eX, int eY) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sX, sY});
		
		while(!q.isEmpty()) {
			int[] location = q.poll();
			if(location[0] == eX && location[1] == eY) return 1;
			visited[location[0]][location[1]] = true;
			
			for(int i = 0; i < 4; i++) {
				int nr = location[0] + dr[i];
				int nc = location[1] + dc[i];
				if(nr < 0 || nr >= 100 || nc < 0 || nc >= 100 || map[nr][nc] == 1 || visited[nr][nc])continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr, nc});
			}
		}
		return 0;
	}
}
