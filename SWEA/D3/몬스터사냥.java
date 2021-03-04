import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class 몬스터사냥 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//테스트 케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			long D = Integer.parseInt(st.nextToken());
			long L = Integer.parseInt(st.nextToken());
			long N = Integer.parseInt(st.nextToken());
			double total = 0;
			for(int i = 0; i < N; i++) {
				total += D*(1+i*L/100.0);
			}
			BigDecimal ans = new BigDecimal(total);
			sb.append(String.format("#%d %s\n", tc, ans));
		}
		System.out.println(sb);
	}
}
