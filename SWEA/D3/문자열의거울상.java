import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 문자열의거울상 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		// 원래 글자
		char[] type = {'b','d','p','q'};
		// 거울에 비쳤을 때
		char[] mirrorType = {'d','b','q','p'};
		
		for(int tc = 1; tc <= T; tc++) {
			// 문자열 입력
			String s = br.readLine();
			StringBuilder newStr = new StringBuilder();
			

			// 거울에 비치면 그 순서가 역순으로 바뀌므로 문자열을 뒤에서 부터 접근
			for(int i = s.length()-1; i >= 0; i--) {
				for(int j = 0; j < type.length; j++) {
					if(s.charAt(i) == type[j]) {
						newStr.append(mirrorType[j]);
						break;
					}
				}
			}
			sb.append("#" + tc + " " + newStr  + "\n");
		}
		System.out.println(sb);
	}
	
}
