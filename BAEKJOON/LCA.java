

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LCA {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] depth, parent;	
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		depth = new int[N+1];
		parent = new int[N+1];
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		} 
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			adj[node1].add(node2);
			adj[node2].add(node1);
		}
		
		dfs(1, 1, 0);
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			int res = LCA(node1, node2);
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int cur, int d, int p) {
		depth[cur] = d;
		parent[cur] = p;
		
		for(int i = 0, size = adj[cur].size(); i < size; i++) {
			int next = adj[cur].get(i);
			if(next == p) continue;
			dfs(next, d+1, cur);
		}
	}
	private static int LCA(int n1, int n2) {
		int depth1 = depth[n1];
		int depth2 = depth[n2];
		
		while(depth1 > depth2) {
			n1 = parent[n1];
			depth1--;
		}
		while(depth2 > depth1) {
			n2 = parent[n2];
			depth2--;
		}
		
		while(n1 != n2) {
			n1 = parent[n1];
			n2 = parent[n2];
		}
		return n1;
	}
}
