import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 노드사이의거리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static final int INF = 99999999;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N+1][N+1];
		
		
		for(int i = 0, len = N-1; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			arr[node1][node2] = dist;
			arr[node2][node1] = dist;
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				if(i != j && arr[i][j] == 0) {
					arr[i][j] = INF;
				}
			}
		}
		
		for(int k = 1; k < N+1; k++) {
			for(int i = 1; i < N+1; i++ ) {
				if(i == k) continue;
				for(int j = 1; j < N+1; j++) {
					if(i != j && k != j) {
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]); 
					}
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			sb.append(arr[node1][node2]).append("\n");
		}
		
		System.out.println(sb);
	}

}
