import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 영식이와친구들 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[N+1];
		int count = 0;
		int idx = 1;
		while(true) {
			cnt[idx]++;
			if(cnt[idx] == M) break;
			count++;

			idx = (cnt[idx] % 2 == 0) ? (idx - L) : (idx + L);
			
			if(idx > N) idx %= N;
			else if (idx < 1) idx += N;

		}

		System.out.println(count);
	}
}
