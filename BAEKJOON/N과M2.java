package day02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		comb(0,1);
		System.out.println(sb);
	}
	private static void comb(int idx, int start) {
		if(idx == M) {
			print();
			return;
		}
		for(int i = start; i <= N; i++) {
			numbers[idx] = i;
			comb(idx+1, i+1);
		}
	}
	private static void print() {
		for(int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + " ");
		System.out.println();
	}
}
