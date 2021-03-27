import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Point[] point = new Point[N+2];
			for(int i = 0; i < N+2; i++) { // 마지막은 도착지
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				point[i] = new Point(x, y);
			}
//			System.out.println(Arrays.toString(point));
			boolean flag = false;
			boolean[] v = new boolean[N+2];
			Queue<Point> q = new LinkedList<>();
			q.offer(point[0]);
			v[0] = true;
			while(!q.isEmpty()) {
				Point p = q.poll();
				if(p.x == point[N+1].x && p.y == point[N+1].y) {
					flag = true;
					break;
				}
				for(int i = 1; i < N+2; i++) {
					int dx = Math.abs(point[i].x - p.x);
					int dy = Math.abs(point[i].y - p.y);
					if(v[i] || dx + dy > 1000) continue;
					q.offer(point[i]);
					v[i] = true;
				}
			}
			if(flag) sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb);
	}
}
