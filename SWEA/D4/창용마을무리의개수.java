import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창용마을무리의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int p[];
	static void make() {
		for(int i = 1; i < N+1; i++) {
			p[i] = i;
		}
	}
	static int find(int i) {
		if(p[i] == i) return i;
		return p[i] = find(p[i]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1];
			make();
			int cnt = N;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(union(a, b)) cnt--;
			}
			sb.append(String.format("#%d %d\n", tc, cnt));
		}
		System.out.println(sb);
	}
}
