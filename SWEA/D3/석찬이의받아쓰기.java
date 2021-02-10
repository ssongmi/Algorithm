import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 석찬이의받아쓰기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine().trim());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine().trim());
			
			int count = 0;
			String[] ans = bf.readLine().trim().split("");
			String[] str = bf.readLine().trim().split("");
			
			for(int i = 0; i < N; i++) {
				if(ans[i].equals(str[i])) 
					count++;
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}
}
