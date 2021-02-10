import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class View {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());	
			st = new StringTokenizer(br.readLine());
			int[] apart = new int[N];
			for(int i = 0; i < N; i++)
				apart[i] = Integer.parseInt(st.nextToken());
			int total = 0; // 총 조망권 확보 개수
			for(int i = 2; i < N-2; i++) {
				int[] diff = new int[4];
				diff[0] = apart[i] - apart[i-1];
				diff[1] = apart[i] - apart[i-2];
				diff[2] = apart[i] - apart[i+1];
				diff[3] = apart[i] - apart[i+2];
				Arrays.sort(diff);
				if(diff[0] > 0) {
					total += diff[0];
				}
			}
			sb.append("#" + tc + " " + total);
		}
		System.out.println(sb);
	}
}
