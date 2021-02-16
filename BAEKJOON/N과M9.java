package day02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N과M9 {
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
		int prev = -1;
		for(int i = 0; i < N; i++) {
			if((i != 0 && prev == input[i])||isSelected[i]) continue;
			prev = input[i];
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