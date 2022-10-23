import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 택배 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[][] adj;
	static int[][] res;
	static int MAX = 9999;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new int[N+1][N+1];
		res = new int[N+1][N+1];
		
		for(int i = 1; i < N+1; i++ ) {
			for(int j = 1; j < N+1; j++) {
				adj[i][j] = MAX;
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			adj[v1][v2] = dist;
			adj[v2][v1] = dist;
			
			res[v1][v2] = v2;
			res[v2][v1] = v1;
		}
		
		for(int k = 1; k < N+1; k++) {
			for(int i = 1; i < N+1; i++) {
				if(k == i) continue;
				for(int j = 1; j < N+1; j++) {
					if(k == j || i == j) continue;
					int value = adj[i][k] + adj[k][j];
					
					if(value < adj[i][j]) {
						adj[i][j] = value;
						res[i][j] = res[i][k];
					}
				}
			}
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				if(i == j) {
					sb.append("- ");
				} else {
					sb.append(res[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
