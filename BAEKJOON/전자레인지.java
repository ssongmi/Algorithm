import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전자레인지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] sec = { 300, 60, 10 };
		int[] ans = new int[3];
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			ans[i] = N / sec[i];
			cnt += ans[i];

			N %= sec[i];
			if (N == 0)
				break;
		}
		if (N == 0) {
			for (int i = 0; i < 3; i++)
				sb.append(ans[i]).append(" ");
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
	}
}
