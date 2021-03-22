import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소비용구하기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Edge {
		int to;
		long weight;

		public Edge(int to, long weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] list = new ArrayList[V+1];
		
		for(int i = 0; i < V+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			list[from].add(new Edge(to, weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		long[] D = new long[V+1];
		boolean[] v = new boolean[V+1];
		int[] prev = new int[V+1];
		for(int i = 1; i < V+1; i++) {
			D[i] = Long.MAX_VALUE;
		}
		
		D[start] = 0;
		
		for(int i = 1; i < V+1; i++) {
			Long min = Long.MAX_VALUE;
			int minIdx = 0;
			for(int j = 1; j < V+1; j++) {
				if(!v[j] && min > D[j]) {
					minIdx = j;
					min = D[j];
				}
			}
			
			v[minIdx] = true;
			
			for(int j = 0, size = list[minIdx].size(); j < size; j++) {
				Edge cur = list[minIdx].get(j);
				if(!v[cur.to] && D[cur.to] > D[minIdx] + cur.weight) {
					D[cur.to] = D[minIdx] + cur.weight;
					prev[cur.to] = minIdx;
				}
			}
		}

		sb.append(D[end] + "\n");
		int root = end;
		ArrayList<Integer> route = new ArrayList<>();
		while(root != 0) {
			route.add(root);
			root = prev[root];
		}
		sb.append(route.size() + "\n");
//		System.out.println(Arrays.toString(prev));
		for(int i = route.size()-1; i >= 0; i--) {
			sb.append(route.get(i) + " ");
		}
		
		System.out.println(sb);
	}
}
