import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 요리사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] scores;
	static int[] select;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 받고
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			// 재료의 개수를 받고
			N = Integer.parseInt(br.readLine());
			
			// 시너지 점수를 저장할 배열을 만들어
			scores = new int[N][N];
			// 몇번째 재료가 선택되었는지를 저장할 배열
			select = new int[N/2];
			
			// 점수들을 입력받고
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					scores[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			comb(0,0);
			sb.append(String.format("#%d %d\n", tc, min));
		}
		System.out.println(sb);
	}
	static int min = Integer.MAX_VALUE;
	private static void comb(int idx, int start) {
		if(idx == N/2) {
			// 각각의 음식에 대한 시너지 점수를 구해서
			int A = 0, B = 0;
			boolean[] arr = new boolean[N];
			for(int i = 0, size = N/2; i < size; i++) {
				arr[select[i]] = true;
				for(int j = 0; j < size; j++) {
					A += scores[select[i]][select[j]];
				}
			}
			int[] Barr = new int[N/2];
			int index = 0;
			for(int i = 0; i < N; i++) {
				if(!arr[i]) {
					Barr[index++] = i;
				}
			}
			for(int i = 0, size = N/2; i < size; i++) {
				for(int j = 0; j < size; j++) {
					B += scores[Barr[i]][Barr[j]];
				}
			}

			// 각각의 시너지 점수의 차이를 비교해서
			int diff = Math.abs(A-B);
			// 원래의 것보다 작으면 그 값으로 갱신
			if(diff < min) min = diff;
			return;
		}
		for(int i = start; i < N; i++) {
			// 재료의 절반을 뽑는 조합들을 만들어
			select[idx] = i;
			comb(idx+1, i+1);
		}
	}
}
