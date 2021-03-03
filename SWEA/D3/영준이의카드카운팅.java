import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 영준이의카드카운팅 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 테스트 케이스를 받고
		int T = Integer.parseInt(br.readLine());
		char[] c = {'S', 'D', 'H', 'C'};
		out:for(int tc = 1; tc <= T; tc++) {
			boolean[][] type = new boolean['S'+1][14];
			int[] total = {13, 13, 13, 13};
			// 카드를 한줄씩 받으면서
			String[] cards = br.readLine().split("");
			for(int i = 0, size = cards.length; i < size; i+=3) {
				char pattern = cards[i].charAt(0);
				int d = Integer.parseInt(cards[i+1])*10;
				int o = Integer.parseInt(cards[i+2]);
				int number = d+o;

				if(type[pattern][number]) {
					sb.append(String.format("#%d %s\n", tc,"ERROR"));
					continue out;
				}
				type[pattern][number] = true;
			}
			for(int i = 0; i < 4; i++) {
				for(int j = 1; j < 14; j++ ) {
					if(type[c[i]][j]) total[i]--;
				}
			}
			sb.append(String.format("#%d %s\n", tc, Arrays.toString(total).replace(",", "").replace("[", "").replace("]", "")));
			
		}
		System.out.println(sb);
	}
}
