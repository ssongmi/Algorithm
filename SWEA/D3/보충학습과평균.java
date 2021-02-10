import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 보충학습과평균 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			int sum = 0;
			for(int i = 0; i < s.length; i++) {
				int tmp = Integer.parseInt(s[i]);
				if(tmp < 40)
					sum += 40;
				else
					sum += tmp;
			}
			System.out.println("#" + " " + sum/s.length);
		}
	}
}
