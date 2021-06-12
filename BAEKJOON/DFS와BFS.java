import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static boolean[] vd, vb;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		vd = new boolean[N+1];
		vb = new boolean[N+1];
		adj = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
	
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
		
			adj[v1].add(v2);
			adj[v2].add(v1);
		}
		for(int i = 1; i < N+1; i++) {
			Collections.sort(adj[i]);
		}
		dfs(start);
		sb.append("\n");
		bfs(start);
		System.out.println(sb);
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		sb.append(start + " ");
		vb[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();

			for(int i = 0, size = adj[cur].size(); i < size; i++) {
				int num = adj[cur].get(i);
				if(!vb[num]) {
					sb.append(num + " ");
					vb[num] = true;
					q.offer(num);
				}
			}
		}
		
		
	}
	private static void dfs(int start) {
		vd[start] = true;
		sb.append(start + " ");
		for(int i = 0, size = adj[start].size(); i < size; i++) {
			int cur = adj[start].get(i);
			if(!vd[cur]) dfs(cur);
		}
	}
}
