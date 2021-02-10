import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 현주의상자바꾸기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			// N: 상자의 개수 , Q: 작업횟수
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			// 상자마련
			int[] boxes = new int[N];

			// 작업 횟수만큼 반복
			for (int i = 1; i < Q + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());

				for (int j = L - 1; j <= R - 1; j++)
					boxes[j] = i;
			}
			sb.append("#" + tc + " " + Arrays.toString(boxes).replace(", ", " ").replace("[", "").replace("]", "")+"\n");
		}
		System.out.println(sb);
	}
}
