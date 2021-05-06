import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABCDE {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static ArrayList<Integer>[] adj;
	static boolean[] v;
	static int cnt;
	static int res;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}
		
		for (int i = 0; i < N; i++) {
			cnt = 0;
			v[i] = true;
			if (dfs(i, 0))
				break;
			v[i] = false;
		}
		System.out.println(res);
	}

	private static boolean dfs(int i, int cnt) {
		if(res == 1) return true;
		if (cnt == 4) {
			res = 1;
			return true;
		}
		for (int j = 0, size = adj[i].size(); j < size; j++) {
			int next = adj[i].get(j);
			if(v[next]) continue;
			v[next] = true;
			dfs(next, cnt+1);
			v[next] = false;
		}
		return false;
	}
}
