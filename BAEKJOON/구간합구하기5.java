import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간합구하기5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sum = new int[N+1][N+1];
		int[][] map = new int[N+1][N+1];
		for(int i = 1; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0 && j == 0) {
					sum[i][j] = map[i][j];
				}else if(i == 0) {
					sum[i][j] += sum[i][j-1] + map[i][j];
				}else if(j == 0 ){
					sum[i][j] += sum[i-1][j] + map[i][j];
				}else {
					sum[i][j] += sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i][j];
				}
			}
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]).append("\n");
		}
		System.out.println(sb);
		

	}
}
