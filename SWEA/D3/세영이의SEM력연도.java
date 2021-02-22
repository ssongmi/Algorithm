import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 세영이의SEM력연도 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// S: 365   E: 24   M: 29
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int year = S;
			
			while(true) {
				if((year-S)% 365 == 0 && (year-E)%24 == 0 && (year-M)%29 == 0) break;
				year+=365;
			}
			sb.append(String.format("#%d %d\n", tc, year));
		}
		System.out.println(sb);
	}
}
