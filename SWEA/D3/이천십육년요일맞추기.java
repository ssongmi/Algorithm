import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이천십육년요일맞추기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 수 만큼 반복
		for(int tc = 1; tc <= T; tc++) {
			// m과 d를 입력 받음 -> 월 일
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			// 각 달이 며칠인지 배열에 저장
			int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			
			int date = 0;
			// 주어진 날이 1월 1일로 부터 며칠 떨어진 날인지 계산
			for(int i = 1; i < m; i++ ) {
				date += month[i];
			}
			date += (d-1);

			// 며칠 떨어졌는지 구하면 7로 나누기
			int ans = (date+4)%7;
			sb.append(String.format("#%d %d\n", tc, ans));
		}
		System.out.println(sb);
	}
}
