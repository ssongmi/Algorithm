package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 돌게임4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		boolean[] D = new boolean[N+4];
		Arrays.fill(D, true);
		D[1] = false; // 상근이가 이기면 true, 상근이가 지면 false;
		D[2] = true;
		D[3] = false;
		D[4] = true;
		for(int i = 5; i < N+1; i++) {
			if(D[i-1] && D[i-3] && D[i-4]) D[i] = false;
		}
//		System.out.println(Arrays.toString(D));
		if(D[N]) System.out.println("SK");
		else System.out.println("CY");
	}
}
