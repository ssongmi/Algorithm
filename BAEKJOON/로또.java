import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 로또 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] arr;
	static int[] selected = new int[6];
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			if(st == null) break;
			
			int N = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			dfs(0,0);
		}
	}
	private static void dfs(int idx, int start) {
		for(int i = start; i < 6; i++ ) {
			selected[idx] = arr[i];
		}
		
	}
}
