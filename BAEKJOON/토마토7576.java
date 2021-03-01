import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] tomato;
	static boolean[][] visited;
	static int R, C;

	public static void main(String[] args) throws IOException {
		// 토마토 상자의 열과 행 길이 입력받기
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		tomato = new int[R][C];
		visited = new boolean[R][C];
		// 토마토의 상태들을 입력받으면서
		// 익지 않은 토마토의 개수와
		// 익은 토마토가 처음 시작하는 좌표 저장해놓기
		int cnt = 0;
		// 처음부터 익은 토마토 들의 좌표
		ArrayList<int[]> list = new ArrayList<>();
		boolean flag = false;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) list.add(new int[] {i, j});
				if (tomato[i][j] == 0) cnt++;
			}
		}

		int ans = 1243;
		if(cnt == 0) ans = 0;
		else {
			ans = bfs(list, cnt);
		}
		System.out.println(ans);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int count = 0;
	private static int bfs(ArrayList<int[]> list, int cnt) {
		// bfs 방식으로 익은 토마토에 접근하면서
		int date = 0;
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0, size = list.size(); i < size; i++) {
			int[] temp = list.get(i);
			q.offer(new int[] {temp[0], temp[1], 0});
			visited[temp[0]][temp[1]] = true;
		}

		// 날짜를 카운팅하고
		// 익은 토마토의 개수를 세고
		// 그 개수가 익지 않은 토마토개수와 같아지면 멈추기
		while (!q.isEmpty()) {
			int[] location = q.poll();
;
			for (int i = 0; i < 4; i++) {
				int nr = location[0] + dr[i];
				int nc = location[1] + dc[i];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C || tomato[nr][nc] == -1 || visited[nr][nc])
					continue;
				
				visited[nr][nc] = true;
				if(tomato[nr][nc] == 0) count++;
				tomato[nr][nc] = 1;
				q.offer(new int[] {nr, nc, location[2]+1});
			}
			date++;
			if(count == cnt) return location[2]+1;
		}
		return -1;
	}
}
