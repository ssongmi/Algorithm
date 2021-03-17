import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡국 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int cnt = 1;
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < N; i++) {
			if(arr[i] == arr[i-1]) cnt++;
			else {
				max = Math.max(max, cnt);
				cnt = 1;
			}
		}
		max = Math.max(max, cnt);
		System.out.println(max);
	}
}
