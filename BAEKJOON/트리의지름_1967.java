import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의지름_1967 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static ArrayList<Edge>[] tree;
	static boolean[] v;
	static int max = Integer.MIN_VALUE;
	static int maxIdx = -1;
	static class Edge{
		int v, w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		v = new boolean[N+1];
		for(int i = 0; i < N+1; i++) {
			tree[i] = new ArrayList<>();
		}
		
		tree[0].add(new Edge(1, 0));
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			tree[from].add(new Edge(to, weight));
			tree[to].add(new Edge(from, weight));
		}
		calc(0,0);
		v = new boolean[N+1];
		max = Integer.MIN_VALUE;
		calc(maxIdx, 0);
		System.out.println(max);
	}
	private static void calc(int cur, int sum) {
		v[cur] = true;
		
		for(int i = 0, size = tree[cur].size(); i < size; i++) {
			int next = tree[cur].get(i).v;
			if(!v[next]) calc(next, sum+tree[cur].get(i).w);
		}
		
		if(sum > max) {
			max = sum;
			maxIdx = cur;
		}
	}
}
