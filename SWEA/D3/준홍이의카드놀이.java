import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 준홍이의카드놀이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] total;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			total = new int[N+M+1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					total[j+i]++;
				}
			}
			
			sb.append("#" + tc + " ");
			int max = Integer.MIN_VALUE;
			for(int i = 2; i < N+M+1; i++) {
				max = total[i] > max ? total[i] : max;
			}
			for(int i = 2; i < N+M+1; i++) {
				if(total[i] == max) sb.append(i + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
