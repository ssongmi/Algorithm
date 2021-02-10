import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쥬스나누기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#" + tc + " ");
			for(int i = 0; i < N; i++) {
				sb.append("1/" + N + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
