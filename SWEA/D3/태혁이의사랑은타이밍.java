import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 태혁이의사랑은타이밍 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스 만큼 반복
		for(int tc = 1; tc <= T; tc++) {
			// 일, 시, 분 입력(11<=D<=14   0 <= H <= 23   0 <= M <=59)
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 전체를 분 기준으로 맞춤
			int date = 11*24*60 + 11 * 60 + 11;
			// 태혁이가 기다린 분
			int min = D*24*60 + H * 60 + M;
			int ans = date > min ? -1 : min-date;
			sb.append(String.format("#%d %d\n", tc, ans));
		}
		System.out.println(sb);
	}
}
