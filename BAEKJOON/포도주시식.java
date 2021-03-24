
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 포도주시식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] D = new int[N+1][3];
		int[] v = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			v[i] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(v));
		D[1][0] = v[1];
		D[1][1] = v[1];
		// 0이 이전꺼 마신경우, 1이 안마신 경우
		for(int i = 2; i < N+1; i++) {
			D[i][0] = D[i-1][1] + v[i];
			D[i][1] = Math.max(D[i-2][0], Math.max(D[i-2][1], D[i-1][2])) + v[i];
			D[i][2] = Math.max(D[i-1][0], Math.max(D[i-1][1], D[i-1][2]));
		}
//		for(int[] sub : D)
//			System.out.println(Arrays.toString(sub));
		int a = Math.max(D[N-1][0], D[N-1][1]);
		int b = Math.max(D[N][1], D[N][0]);
		System.out.println(Math.max(a, b));
	}
}
