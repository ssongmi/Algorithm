import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배배송 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] D;
	static boolean[] v;
	static class Edge implements Comparable<Edge>{
		int v, w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			
			return this.w - o.w;
		}

	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		D = new int[N+1];
		v = new boolean[N+1];
		ArrayList<Edge>[] map = new ArrayList[N+1];
		
		for(int i = 1; i < N+1; i++) {
			map[i] = new ArrayList<>();
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[v1].add(new Edge(v2, w));
			map[v2].add(new Edge(v1, w));
		}
		
		Arrays.fill(D, 50000001);
		
		D[1] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge cur= pq.poll();
			
			if(!v[cur.v]) v[cur.v] = true;
			else continue;
			for(int i = 0, len = map[cur.v].size(); i < len; i++) {
				Edge next = (Edge) map[cur.v].get(i);
				if(D[next.v] > D[cur.v] + next.w) {
					D[next.v] = D[cur.v] + next.w;
					pq.offer(new Edge(next.v, D[next.v]));
				}
			}
		}
		
		System.out.println(D[N]);
	}

}
