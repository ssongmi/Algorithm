import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준2_1세일 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N= Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int res = 0;
		int cnt = 0;
		for(int i = N-1; i >= 0; i--) {
			cnt++;
			if(cnt % 3 != 0) {
				res += arr[i];
			}
		}
		System.out.println(res);
	}
}
