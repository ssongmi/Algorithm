import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소가길을건너간이유1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] status = new int[11];
		
		Arrays.fill(status, -1);
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int sts = Integer.parseInt(st.nextToken());
			
			if(status[num] == -1) status[num] = sts;
			else if(status[num] != sts) {
				status[num] = sts;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
