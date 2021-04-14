import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] dp = new int[K+1];
		
		int count = 0;
		dp[0] = 1;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j = arr[i]; j <= K; j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[K]);
	}
}
