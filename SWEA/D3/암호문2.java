import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 암호문2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// 테스트 케이스 횟수만큼 반복
		for(int tc = 1; tc <= 10; tc++) {
			// 원본 암호문 길이 입력
			int N = Integer.parseInt(br.readLine());
			// 원본 암호문 저장
			ArrayList<Integer> pw = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				pw.add(Integer.parseInt(st.nextToken()));
			}
			
			// 명령어개수 입력
			int commandN = Integer.parseInt(br.readLine());
			
			// 명령어 받기
			st = new StringTokenizer(br.readLine());
			
			// 명령어를 순회하면서
			while(st.hasMoreTokens()) {
				String command = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(command.equals("I")) {
					// 명령어가 I면 x위치 바로 다음에 y개의 숫자를 삽입
					for(int i = 0; i < y; i++) {
						pw.add(x++, Integer.parseInt(st.nextToken()));
					}
				}else if(command.equals("D")) {
					// 명령어가 D면 x위치 바로 다음부터 y개의 숫자 삭제
					for(int i = 0; i < y; i++) {
						pw.remove(x);						
					}
				}
			}
			sb.append("#" + tc + " ");
			for(int i = 0; i < 10; i++)
				sb.append(pw.get(i) + " ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
