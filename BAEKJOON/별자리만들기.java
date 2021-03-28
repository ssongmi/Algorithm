import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 별자리만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Point{
		double r, c;

		public Point(double r, double c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		Point[] p = new Point[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double r = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			
			p[i] = new Point(r, c);
		}
		double[][] adj = new double[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				double dr = p[i].r - p[j].r;
				double dc = p[i].c - p[j].c;
				adj[i][j] = Math.sqrt(dr*dr + dc*dc);
			}
		}
//		for(double[] sub : adj)
//			System.out.println(Arrays.toString(sub));
		boolean[] v = new boolean[N];
		double[] minEdge = new double[N];
		double res = 0;
		Arrays.fill(minEdge, Double.MAX_VALUE);
		minEdge[0] = 0;
		for(int i = 0; i < N; i++) {
			double min = Double.MAX_VALUE;
			int minV = 0;
			for(int j = 0; j < N; j++) {
				if(!v[j] && min > minEdge[j]) {
					min = minEdge[j];
					minV = j;
				}
			}
			
			v[minV] = true;
			res += minEdge[minV];
			
			for(int j = 0; j < N; j++) {
				if(!v[j] && adj[minV][j] != 0 && minEdge[j] > adj[minV][j]) {
					minEdge[j] = adj[minV][j];					
				}
			}
		}
//		System.out.println(Arrays.toString(minEdge));
		System.out.println(String.format("%.2f", res));
		
	}
}
