import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준01타일 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+2];
		arr[1] = 1;
		arr[2] = 2;
		for(int i = 3; i <= N; i++) {
			arr[i] = (arr[i-2] + arr[i-1])%15746;
		}
		System.out.println(arr[N]);
	}
}
