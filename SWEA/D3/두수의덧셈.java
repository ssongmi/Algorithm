import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class 두수의덧셈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스 수를 입력받고
		int T = Integer.parseInt(br.readLine());
		
		// 그만큼 반복하며
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			// 숫자 두개를 받아
			BigDecimal num1= new BigDecimal(st.nextToken());
			BigDecimal num2= new BigDecimal(st.nextToken());
			sb.append(String.format("#%d %s\n", tc, num1.add(num2)));
		}
		System.out.println(sb);
	}
}
