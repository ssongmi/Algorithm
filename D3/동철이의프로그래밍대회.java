import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동철이의프로그래밍대회 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine().trim();
			int N = Integer.parseInt(str.split(" ")[0]);
			int M = Integer.parseInt(str.split(" ")[1]);
			int[] scores = new int[N];
			int max = Integer.MIN_VALUE;
			int count = 0;
			for(int i = 0; i < N; i++) {
				String score = br.readLine().trim();
				for(int j = 0; j < M; j++) {
					scores[i] += Integer.parseInt(score.split(" ")[j]);
				}
				if(scores[i] > max)
					max = scores[i];
			}
			for(int i = 0; i < N; i++) {
				if(max == scores[i])
					count++;
			}
			System.out.println("#" + tc + " " + count + " " + max);
		}
	}

}
