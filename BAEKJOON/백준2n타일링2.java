
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2n타일링2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N+2];
		D[1] = 1;
		D[2] = 3;
		for(int i = 3; i < N+1; i++) {
			D[i] = (2*D[i-2] + D[i-1])%10007;
		}
		System.out.println(D[N]);
	}
}
