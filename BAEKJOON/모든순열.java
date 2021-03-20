import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모든순열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] v;
	static int[] s;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		v = new boolean[N+1];
		s = new int[N];
		perm(0);
		System.out.println(sb);
	}
	private static void perm(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i++)
				sb.append(s[i] + " ");
			sb.append("\n");
		}
		for(int i = 1; i < N+1; i++) {
			if(v[i]) continue;
			s[cnt] = i;
			v[i] = true;
			perm(cnt+1);
			v[i] = false;
		}
	}
}
