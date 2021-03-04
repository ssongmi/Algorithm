import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 신입사원 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//테스트 케이스를 받고
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수만큼 반복하면서
		for(int tc = 0; tc < T; tc++) {
			// 지원자의 수를 받고
			int N = Integer.parseInt(br.readLine());
			int[][] scores = new int[N][2];
			// 서류와 면접 중 1등인 사람의 다른 전형 점수를 저장
			int[] first = new int[2];
			// 지원자 수만큼 서류 성적과 면접 성적을 받고
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++) {
					scores[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Arrays.sort(scores, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0]-o2[0];
				}
			});

			int cnt = 1; // 첫번째 요소 포함 
			int standard = scores[0][1];
			for(int i = 1; i < N; i++) {
				// 그 전 면접 전형 점수보다 작으면 카운팅
				if(scores[i][1] < standard) {
					cnt++;
					standard = scores[i][1];
				}
			}
			
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}
