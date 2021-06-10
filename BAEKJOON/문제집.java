import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static ArrayList<Integer>[] adj;
	static int[] indegree;
	static class Prob implements Comparable<Prob>{
		int diff, idg;

		public Prob(int diff, int idg) {
			super();
			this.diff = diff;
			this.idg = idg;
		}

		@Override
		public int compareTo(Prob o) {
			if(this.idg != o.idg) return this.idg -o.idg;
			return this.diff - o.diff;
		}
		
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		indegree = new int[N+1];
		
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			adj[prev].add(next);
			indegree[next]++;
		}
		topologicalSort();
		System.out.println(sb);
				
	}
	public static void topologicalSort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 1; i < N+1; i++) {
			if(indegree[i] == 0) pq.offer(i);
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			
			sb.append(cur + " ");
			for(int i = 0, size = adj[cur].size(); i < size;i++) {
				int num = adj[cur].get(i);
				indegree[num]--;
				if(indegree[num] == 0) pq.offer(num);
			}
		}
		
	}
}
