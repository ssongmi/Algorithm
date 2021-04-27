import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 트리의지름_1167 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static ArrayList<Edge>[] map;
	static boolean[] v;
	static class Edge{
		int v, w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N+1];
		v = new boolean[N+1];
		for(int i = 0; i < N+1; i++) {
			map[i] = new ArrayList<>();
		}
		map[0].add(new Edge(1, 0));
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			
			while(true) {
				int vertex = Integer.parseInt(st.nextToken());
				if(vertex == -1) break;
				
				int weight = Integer.parseInt(st.nextToken());
				map[cur].add(new Edge(vertex, weight));
			}
		}

		dfs(0, 0);
		max = Integer.MIN_VALUE;
		v = new boolean[N+1];
		dfs(maxNode, 0);
		System.out.println(max);
	}
	static int maxNode = -1;
	static int max = Integer.MIN_VALUE;
	private static void dfs(int cur, int sum) {
		v[cur] = true;
		for(int i = 0, size = map[cur].size(); i < size; i++ ) {
			int next = map[cur].get(i).v;
			if(!v[next]) dfs(next, sum+map[cur].get(i).w);
		}
		if(sum > max) {
			max = sum;
			maxNode = cur;
		}
		
	}
	
}
