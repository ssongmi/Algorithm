import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 키순서 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N, M;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] adj = new int[N+1][N+1];
		for(int i = 0; i< M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adj[v1][v2] = -1;
			adj[v2][v1] = 1;
		}

		for(int j = 1; j < N+1; j++) {
			for(int i = 1; i < N+1; i++) {
				if(i == j )continue;
				for(int k = 1; k < N+1; k++) {
					if(i == k || j == k) continue;
					if(adj[i][k] == 0 && adj[i][j] == adj[j][k]) adj[i][k] = adj[i][j];
				}
			}
		}
		

		int res = 0;
		for(int i = 1; i < N+1; i++ ) {
			int cnt = 0;
			for(int j = 1; j < N+1; j++) {
				if(adj[i][j] != 0)cnt++;
			}
			if(cnt == N-1) res++;
		}
		System.out.println(res);
	}
}
