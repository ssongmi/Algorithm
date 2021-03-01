import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질1697 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, K;
	static int[] dr = new int[3];
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) throws IOException {
		// 수빈이의 위치 N과 동생의 위치 K를 입력받고
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dr[0] = -1; dr[1] = 1; dr[2] = N;
		// bfs 방식으로 접근
		int ans = bfs(N);
		System.out.println(ans);
	}
	
	private static int bfs(int n) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {n, 0});
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int location = temp[0];
			if(location == K) return temp[1];
			dr[2] = location;
			for(int i = 0; i < 3; i++) {
				int nr = location + dr[i];
				if(nr < 0 || nr >= 100001 || visited[nr]) continue;
				visited[nr] = true;
				q.offer(new int[] {nr, temp[1]+1});
			}
		}
		return -1;
	}
	
}
