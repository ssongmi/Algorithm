import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구독자전쟁 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			
			int N = Integer.parseInt(s[0]);
			int p = Integer.parseInt(s[1]);
			int t = Integer.parseInt(s[2]);
			// 최소: p와t의 합이 N을 넘을 때 p+t-N 이고 합이 N을 넘지 않으면 0
			int min = p+t > N ? p+t - N : 0; 
			// 최대 : p와 t중 작은 값
			int max = Math.min(p, t);
			
			sb.append("#" + tc + " " + max + " " + min + "\n" );
		}
		System.out.println(sb);
	}
}
