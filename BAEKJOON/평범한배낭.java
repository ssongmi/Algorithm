
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] w = new int[N+1];
		int[] v = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] value = new int[N+1][K+1];
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < K+1; j++) {
				if(w[i] > j ) value[i][j] = value[i-1][j];
				else value[i][j] = Math.max(v[i] + value[i-1][j-w[i]], value[i-1][j]);
			}
		}
		System.out.println(value[N][K]);
	}
}
