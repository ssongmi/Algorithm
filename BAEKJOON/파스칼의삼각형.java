import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파스칼의삼각형 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || i == j) arr[i][j] = 1;
				else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		System.out.println(arr[n-1][k-1]);
	}
}
