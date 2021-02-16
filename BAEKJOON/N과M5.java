package day02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] input, numbers;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		numbers = new int[M];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);

		perm(0);
		System.out.println(sb);
	}
	private static void perm(int idx) {
		if(idx == M) {
			print();
			return;
		}
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			numbers[idx] = input[i];
			isSelected[i] = true;
			perm(idx+1);
			isSelected[i] = false;
		}
	}
	private static void print() {
		for(int i = 0; i < numbers.length; i++)
			sb.append(numbers[i] + " ");
		sb.append("\n");
	}
}
