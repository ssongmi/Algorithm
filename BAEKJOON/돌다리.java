import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 돌다리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int A, B, N, M;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] dx = {-1, 1, A, B, -A, -B};
		int[] v = new int[100001];
		Arrays.fill(v, Integer.MAX_VALUE);
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(N, 0));
		
		v[N] = 0;
		
		int res = 0;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(cur.x == M) {
				res = cur.cnt;
				break;
			} 
			for(int i = 0; i < 6; i++) {
				int next = cur.x + dx[i];
				if(next < 0 || next > 100000 || cur.cnt+1 >= v[next]) continue;
				v[next] = cur.cnt+1;
				q.offer(new Point(next, cur.cnt+1));	
			}
			for(int i = 2; i < 4; i++) {
				int next = cur.x * dx[i];
				if(next < 0 || next > 100000 || cur.cnt+1 >= v[next]) continue;
				v[next] = cur.cnt+1;
				q.offer(new Point(next, cur.cnt+1));			
			}
		}
		System.out.println(res);
	}
	static class Point{
		int x, cnt;

		public Point(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
	}
}
