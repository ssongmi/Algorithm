import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 줄세우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int size = 0;
		for(int i = 0; i < N; i++) {
			int idx = Arrays.binarySearch(dp, 0, size, arr[i]);
			if(idx < 0) idx = Math.abs(idx) -1;
			dp[idx] = arr[i];
			if(idx == size) size++;
		}
		System.out.println(N-size);
		
	}
}
