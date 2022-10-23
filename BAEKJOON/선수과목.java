import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 선수과목 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static ArrayList<Integer>[] adj;
	static int[] indegree;
	static int[] res;
	static class Point {
		int num, cnt;

		public Point(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		indegree = new int[N+1];
		res = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			indegree[to]++;
		}
		bfs();
		for(int i = 1; i < N+1; i++) {
			sb.append(res[i]).append(" ");
		}
		System.out.println(sb);
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		
		for(int i = 1; i < N+1; i++) {
			if(indegree[i] == 0) {
				q.offer(new Point(i, 1));
			}
		}
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			res[cur.num] = cur.cnt;

			for(int i = 0, len = adj[cur.num].size(); i < len; i++) {
				int sub = adj[cur.num].get(i);
				indegree[sub]--;
				if(indegree[sub] == 0) q.offer(new Point(sub, cur.cnt+1));
			}
		}
	}
	
	

}
