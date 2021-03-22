import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최단경로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] adj = new ArrayList[V+1];
		for(int i = 0; i < V+1; i++ ) {
			adj[i] = new ArrayList<int[]>();
		}
		
		int[] D = new int[V+1];
		boolean[] v = new boolean[V+1];
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adj[from].add(new int[] {to, weight});
		}
		for(int i = 1; i < V+1; i++) {
			D[i] = Integer.MAX_VALUE;
		}
		D[K] = 0;
		
		for(int i = 1; i < V+1; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			
			for(int j = 1; j < V+1; j++) {
				if(!v[j] && min > D[j]) {
					min = D[j];
					minIdx = j;
				}
			}
			
			v[minIdx] = true;
			for(int j = 0, size = adj[minIdx].size(); j < size; j++) {
				int[] cur = adj[minIdx].get(j);
				
				
				if(!v[cur[0]] && cur[1]!= 0 && D[cur[0]] > D[minIdx] + cur[1]) {
					D[cur[0]] = D[minIdx] + cur[1];
				}
			}
		}
		for(int i = 1; i < V+1; i++) {
			if(D[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(D[i]);
			
		}
	}
}
