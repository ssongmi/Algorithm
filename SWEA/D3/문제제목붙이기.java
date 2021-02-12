import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문제제목붙이기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			int[] titles = new int['Z'-'A'+1];
			int count = 0;
			// N줄에 거쳐제목을 나타내는 문자열이 주어짐
			int N = Integer.parseInt(br.readLine());
			
			// 주어진 제목의 첫글자를 인덱스로 해서 카운팅함
			for(int i = 0; i < N; i++) {
				titles[br.readLine().charAt(0)-'A']++;
			}
			
			for(int i = 0; i < titles.length; i++) {
				if(titles[i] > 0) {
					count++;					
				}else {
					break;
				}
			}
			
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}
}
