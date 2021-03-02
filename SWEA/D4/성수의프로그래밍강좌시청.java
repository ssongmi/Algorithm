import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 성수의프로그래밍강좌시청 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, K;
	static int[] arr, selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 수만큼 반복하며
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			// N과 K를 입력받아
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			// N사이즈의 전체 배열과
			arr = new int[N];
			// K사이즈의 선택된 배열을 만들어
			selected = new int[K];

			// 전체 배열을 입력받고
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			// 정렬시켜서 큰 수부터 K를 작은 순서대로 더해가며 평균을 구해줌
			double max = 0;
			Arrays.sort(arr);
			for(int i = K; i > 0; i--) {
				max = (max+arr[N-i])/2;
			}
			sb.append(String.format("#%d %f\n", tc, max));
		}
		System.out.println(sb);
	}

}
