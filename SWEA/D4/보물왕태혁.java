import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보물왕태혁 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 각 테스트 케이스마다 약수의 개수를 입력받고
			int N = Integer.parseInt(br.readLine());
			// 약수들을 담을 배열을 만들고
			int[] numbers = new int[N];

			// 약수들을 입력받고
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				numbers[i] = Integer.parseInt(st.nextToken());

			// 정렬시켜서
			Arrays.sort(numbers);

			// 첫번째 수와 마지막 수의 곱을 구한다.
			int ans = numbers[0] * numbers[N - 1];
			sb.append(String.format("#%d %d\n", tc, ans));
		}
		System.out.println(sb);
	}
}
