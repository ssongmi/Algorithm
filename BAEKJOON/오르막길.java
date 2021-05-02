import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오르막길 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[N] = 0;
		int ans = 0;
		int start, prev;
		start = prev = arr[0] ;
		int cnt = 1;
		for(int i = 1; i < N+1; i++) {
			if(prev < arr[i]) {
				cnt++;
			}else {
				cnt = 1;
				int temp = arr[i-1] - start;
				ans = temp > ans ? temp : ans;
				start = arr[i];
			}
			prev = arr[i];
		}
		System.out.println(ans);
	}
}	
