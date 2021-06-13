import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[][] adj;
	static final int MAX = 200;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 인접행렬 생성
		adj = new int[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				adj[i][j] = MAX;
			}
		}
		
		// 입력값 받기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adj[v1][v2] = 1;
			adj[v2][v1] = 1;
		}
		
		// 플로이드 와샬
		for(int j = 1; j < N+1; j++) {
			for(int i = 1; i < N+1; i++) {
				if(i == j) continue;
				for(int k = 1; k < N+1; k++) {
					if(j == k || k == i) continue;
					
					if(adj[i][k] > adj[i][j] + adj[j][k]) {
						adj[i][k] = adj[i][j] + adj[j][k];
					}
				}
			}
		}
		
		// 케빈 베이컨 수 세기
		int res = Integer.MAX_VALUE;
		int num = 0;
		for(int i = 1; i < N+1; i++) {
			int cur = 0;
			for(int j = 1; j < N+1; j++ ) {
				cur += adj[i][j];
			}
			if(res > cur) {
				res = cur;
				num = i;
			}
		}
		System.out.println(num);
	}

}
