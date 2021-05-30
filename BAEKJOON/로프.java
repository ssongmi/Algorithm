import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] list = new int[N];
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(list);
		int res = list[N-1];
		for(int i = N-2; i >= 0 ; i--) {
			int sum = list[i]*(N-i);
			res = sum > res ? sum : res;
		}
		System.out.println(res);
		
	}
}