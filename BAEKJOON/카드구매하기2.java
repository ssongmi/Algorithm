package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드구매하기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		long[] D = new long[N+1];
		D[1] = P[1];
		for(int i = 2; i < N+1; i++) {
			long min = P[i];
			for(int j = 1; j <= i/2; j++) {
				min = Math.min(min, D[i-j]+D[j]);
//				System.out.println("i = " + i + ", j = " + j + ", min = " + min);
			}
			D[i] = min;
		}
//		System.out.println(Arrays.toString(D));
		System.out.println(D[N]);
		
	}
}
