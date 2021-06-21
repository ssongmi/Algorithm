import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 해킹 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken()); 
			int C = Integer.parseInt(st.nextToken()); 
			ArrayList<Net>[] adj = new ArrayList[N+1];

			for(int i = 0; i < N+1; i++) {
				adj[i] = new ArrayList<>();
			}
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				adj[b].add(new Net(a, s));
			}

			PriorityQueue<Net> pq = new PriorityQueue<>();
			int[] v = new int[N+1];
			int cnt = 0;
			int max = Integer.MIN_VALUE;

			Arrays.fill(v, Integer.MAX_VALUE);
			v[C] = 0;
			pq.add(new Net(C, 0));
			
			while(!pq.isEmpty()) {
				Net cur = pq.poll();
				
				if(cur.d > v[cur.computer]) continue;
				cnt++;
				max = Math.max(max, cur.d);
				for(int i = 0, size = adj[cur.computer].size(); i < size; i++ ) {
					Net next = adj[cur.computer].get(i);
					int nC = next.computer;
					
					if(v[nC] > cur.d + next.d) {
						v[nC] = cur.d + next.d;
						pq.add(new Net(nC, v[nC]));
					}
				}
			}
			
			sb.append(cnt + " " + max + "\n");
		}
		System.out.println(sb);
	}
	static class Net implements Comparable<Net>{
		int computer, d;

		public Net(int computer, int d) {
			super();
			this.computer = computer;
			this.d = d;
		}

		@Override
		public int compareTo(Net o) {
			return Integer.compare(this.d, o.d);
		}
		
	}
}
