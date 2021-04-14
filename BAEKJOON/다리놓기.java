import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 다리놓기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] arr = new int[31][31];
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j < 31; j++) {
				if(j == 0) {
					arr[i][j] = 1;
					continue;
				} 
				if(j >= i) {
					arr[i][j] = 1;
					continue;
				}
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			sb.append(arr[n][r] + "\n");
		}
		System.out.println(sb);
	}
}
