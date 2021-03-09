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
	static int N;
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			dfs(0,0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int idx, int start) {
		if(idx == 6) {
			sb.append(Arrays.toString(selected).replace(", ", " ").replace("[", "").replace("]", "")+"\n");
			return;
		}
		for(int i = start; i < N; i++ ) {
			selected[idx] = arr[i];
			dfs(idx+1, i+1);
		}
		
	}
}
