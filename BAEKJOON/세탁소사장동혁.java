import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 세탁소사장동혁 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = {25, 10, 5, 1};
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] ans = new int[4];
			
			int cnt = 0;
			for(int i = 0; i < 4; i++) {
				ans[i] = N / arr[i];
				N %= arr[i];
				if(N == 0) break;
			}
			
			for(int i = 0; i < 4; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
