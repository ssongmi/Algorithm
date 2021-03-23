import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[][] D = new long[201][201];
		for(int i = 0; i < 201;i++) {
			D[i][0] = 1;
			D[1][i] = 1;
		}
		
		for(int i = 2; i < 201; i++) {
			for(int j = 1; j < 201; j++ ) {
				for(int k = 0; k <= j; k++) {
					D[i][j] += D[i-1][k]%1000000000;
				}
			}
		}
		System.out.println(D[K][N]%=1000000000);
	}

}
