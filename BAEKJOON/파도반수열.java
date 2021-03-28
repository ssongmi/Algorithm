import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파도반수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] D = new long[N+3];
			D[1] = 1;
			D[2] = 1;
			D[3] = 1;
			for(int i = 4; i < N+1; i++) {
				D[i] = D[i-3] + D[i-2];
			}
			sb.append(D[N]+ "\n");
		}
		System.out.println(sb);
	}
}
