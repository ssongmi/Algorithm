import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영준이와신비한뿔의숲세계 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			// N개의 뿔과 M마리의 짐승
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 역행렬 이용
			// X: 유니콘 수       Y: 트윈혼 수
			int X = -N + 2 * M;
			int Y = N - M;
			
			sb.append(String.format("#%d %d %d\n", tc, X, Y));
		}
		System.out.println(sb);
	}
}
