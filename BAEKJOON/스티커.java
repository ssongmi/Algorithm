import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스티커 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] score = new int[2][N+1];
			int[][] sum = new int[2][N+1];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j < N+1; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sum[0][1] = score[0][1];
			sum[1][1] = score[1][1];
			
			for(int i = 2; i < N+1; i++) {
				sum[0][i] = Math.max(sum[1][i-1], sum[1][i-2])+score[0][i];
				sum[1][i] = Math.max(sum[0][i-1], sum[0][i-2])+score[1][i];
			
			}
			
			sb.append(Math.max(sum[0][N], sum[1][N])).append("\n");
		}
		System.out.println(sb);
	}
}
