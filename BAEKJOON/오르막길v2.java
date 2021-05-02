import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오르막길v2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int ans = 0;
		for(int i = 0; i < N-1; i++) {
			if(arr[i] < arr[i+1]) sum += (arr[i+1]-arr[i]);
			else {
				sum = 0;
			}
			ans = sum > ans ? sum : ans;
		}
		System.out.println(ans);
	}
}	
