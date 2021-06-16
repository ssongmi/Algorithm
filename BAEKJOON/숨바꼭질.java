import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static ArrayList<Integer>[] adj;
	static int[] distance;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		distance = new int[N+1];
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

		bfs();

		int idx = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 2; i < N+1; i++) {
			if(distance[i] > max) {
				max = distance[i];
				idx = i;
			}
		}
		int cnt = 0;
		for(int i = 2; i < N+1; i++) {
			if(distance[i] == max) cnt++;
		}
		System.out.println(idx + " " + max + " " + cnt);
	}
	static class Point{
		int v, d;

		public Point(int v, int d) {
			super();
			this.v = v;
			this.d = d;
		}	
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		for(int i = 0, size = adj[1].size(); i < size; i++) {
			int next = adj[1].get(i);
			q.offer(new Point(next, 1));
			distance[next] = 1;
		}
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i = 0, size = adj[cur.v].size(); i < size; i++) {
				int next = adj[cur.v].get(i);
				if(distance[next] != 0) continue;
				q.offer(new Point (next, cur.d+1));
				distance[next] = cur.d+1;
			}
		}
	}
}
