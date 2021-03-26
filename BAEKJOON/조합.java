package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class 조합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		BigDecimal[][] D = new BigDecimal[1001][1001];
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) D[i][j] = new BigDecimal(1);
				else D[i][j] = D[i-1][j].add(D[i-1][j-1]);
			}
		}
//		for(long[] sub : D)
//			System.1out.println(Arrays.toString(sub));
		System.out.println(D[N][M]);
	}
}
