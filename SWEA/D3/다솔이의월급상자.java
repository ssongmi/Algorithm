import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다솔이의월급상자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			double total = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				double prob = Double.parseDouble(st.nextToken());
				double money = Double.parseDouble(st.nextToken());
				total += prob*money;
			}
			sb.append("#" + tc + " " + String.format("%.6f", total) + "\n");
		}
		System.out.println(sb);
	}

}