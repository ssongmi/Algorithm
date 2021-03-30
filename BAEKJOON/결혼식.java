import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 결혼식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
		int[][] adj= new int[N+1][N+1];
		boolean[] v = new boolean[N+1];
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		int cnt = 0;
		for(int i = 2; i < N+1; i++) {
			if(adj[1][i] == 1) {
				if(!v[i]) {
					cnt++;
					v[i] = true;
				}
				for(int j = 2; j < N+1; j++) {
					if(!v[j] && adj[i][j] == 1) {
						v[j] = true;
						cnt++;
					}
				}					
			}
		}

	
		System.out.println(cnt);
	}
}
