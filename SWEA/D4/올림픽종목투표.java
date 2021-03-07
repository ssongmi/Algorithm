import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 올림픽종목투표 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수만큼 반복하면서 
		for(int tc = 1; tc <= T; tc++) {
			// N과 M을 입력받고
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] type = new int[N+1];
			int[] teams = new int[M+1];
			
			// 종목에 대한 배열을 입력받고
			st = new StringTokenizer(br.readLine());
			for(int i = 1, size=N+1; i < size; i++ )
				type[i] = Integer.parseInt(st.nextToken());
			
			// 위원회에 대한 배열을 입력받고
			st = new StringTokenizer(br.readLine());
			for(int i = 1, size = M+1; i < size; i++ )
				teams[i] = Integer.parseInt(st.nextToken());
			
			//투표될 배열을 만들고
			int[] vote = new int[N+1];
			
			// 조직위원회 배열을 순회하며
			for(int i = 1, size=M+1; i < size; i++) {
				// 해당 차례의 M보다 작으면 바로 투표를 +1해줌
				for(int j = 1, sizeN = N+1; j < sizeN; j++) {
					if(type[j] <= teams[i]) {
						vote[j]++;
						break;
					} 
				}
			}

			int max = 0;
			int idx = 0;
			// 투표된 배열을 순회하며 가장 많은 표를 획득한 경기의 번호를 출력
			for(int i = 1, size=N+1; i < size; i++ ) {
				if(vote[i] > max) {
					max = vote[i];
					idx = i;
				}
			}
			sb.append(String.format("#%d %d\n", tc, idx));
		}
		System.out.println(sb);
	}
}
