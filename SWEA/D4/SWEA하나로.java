import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA하나로 {
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
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	static void make() {
		for(int i = 0; i < N; i++) {
			p[i]=i;
		}
	}
	static int find(int idx) {
		if(p[idx] == idx) return idx;
		return p[idx] = find(p[idx]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	static int N;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			Point[] arr = new Point[N];
			p = new int[N];
			// x좌표 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = new Point(Integer.parseInt(st.nextToken()), 0);
			}
			// y좌표 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i].y = Integer.parseInt(st.nextToken());
			}
			
			// 세율 입력
			double E = Double.parseDouble(br.readLine());
			Edge[] list = new Edge[N*N];
			int idx = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Point p1 = arr[i];
					Point p2 = arr[j];
					double dx = p1.x-p2.x;
					double dy = p1.y-p2.y;
					list[idx++] = new Edge(i, j, dx*dx + dy*dy);
				}
			}
			
			
			Arrays.sort(list);
//			for(Edge e : list)
//				System.out.println(e);
			make();
			int cnt = 0;
			long res = 0;
			for(Edge e : list) {
				if(e.weight != 0) {
//					System.out.println(e.to + " "+ e.from);
					if(union(e.to, e.from)) {
//						System.out.println("dd");
//					System.out.println(e.to + " "+ e.from + ", " + e.weight);
						res += e.weight;
						if(++cnt == N-1) break;
					}
				}
			}
			sb.append(String.format("#%d %d\n", tc, Math.round(E*res)));
//			System.out.println(res*res*E);
		}
		System.out.println(sb);
	}
}
