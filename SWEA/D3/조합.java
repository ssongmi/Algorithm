import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static final int MOD = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		long[] fac = new long[1000001];
		
		fac[0] = 1;
		for(int i = 1; i < 1000001; i++) fac[i] = fac[i-1] * i % MOD;
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long num = (fac[R] * fac[N-R]) % MOD;
			
			long b = pow(num, MOD-2);
			
			long ans = fac[N]*b%MOD;
			sb.append(String.format("#%d %d\n", tc,ans));
		}
		System.out.println(sb);
	}
	private static long pow(long a, int b) {
		if(b==0) return 1;
		
		long n = pow(a, b/2);
		long temp = (n * n) % MOD;
		
		if(b%2 == 0) return temp;
		else return (a * temp) % MOD;
	}
}
