package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타일장식물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		long D[] = new long[N+2];
		D[1] = 4;
		D[2] = 6;
		for(int i = 3; i < N+1; i++) {
			D[i] = D[i-1]+ D[i-2];
		}
		System.out.println(D[N]);
	}
}
