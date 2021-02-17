import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 코딩토너먼트1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int len = (int)Math.pow(2, N);

			int[] list = new int[len];

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < len; i++)
				list[i] = Integer.parseInt(st.nextToken());
			
			boredom = 0;
			recur(Arrays.copyOf(list, len));
			sb.append(String.format("#%d %"+ "d\n", tc, boredom));
		}
		System.out.println(sb);
	}
	static int boredom;
	private static void recur(int [] arr) {
		if(arr.length == 1) return;
		int[] nextArr = new int[arr.length/2];
		for(int i = 0; i < arr.length; i+=2) {
			boredom += Math.abs(arr[i]-arr[i+1]);
			nextArr[i/2] = Math.max(arr[i], arr[i+1]); 
		}
		recur(nextArr);
	}
}
