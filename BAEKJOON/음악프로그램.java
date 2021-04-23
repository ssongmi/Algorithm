import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[][] adj;
	static int[] indegree;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new int[N+1][N+1];
		indegree = new int[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			if(temp == 0) continue;
			int from = Integer.parseInt(st.nextToken());
			for(int j = 0; j < temp-1; j++) {
				int to = Integer.parseInt(st.nextToken());
				if(adj[from][to] == 0)indegree[to]++;
				adj[from][to] = 1;
				from = to;
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <N+1; i++) {
			if(indegree[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			ans.add(cur);
			for(int i = 1; i < N+1; i++) {
				if(adj[cur][i] == 1) {
					indegree[i]--;
					if(indegree[i] == 0) q.offer(i);
				}
			}
		}
		
		if(ans.size() == N) {
			for(int e : ans) System.out.println(e); 
		}else System.out.println(0);
	}
}
