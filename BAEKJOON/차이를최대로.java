import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 차이를최대로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static int[] res;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		res = new int[N];
		v = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.println(max);
	}
	static int max = Integer.MIN_VALUE;
	private static void perm(int cnt) {
		if(cnt == N) {
			int value = 0;
			for(int i = 0; i < N-1; i++) {
				value += Math.abs(res[i] - res[i+1]);
			}
			max = max > value ? max : value;
		}
		for(int i = 0; i < N; i++ ) {
			if(v[i]) continue;
			res[cnt] = arr[i];
			v[i] = true;
			perm(cnt+1);
			v[i] = false;
		}
	}
}
