package day02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] numbers;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		isSelected = new boolean[N+1];
		perm(0);
		System.out.println(sb);
	}
	private static void perm(int idx) {
		if(idx == M) {
			print();
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			numbers[idx] = i;
			isSelected[i] = true;
			perm(idx+1);
			isSelected[i] = false;
		}
	}
	private static void print() {
		for(int i = 0; i < numbers.length; i++)
			System.out.print(numbers[i] + " ");
		System.out.println();
	}
}
