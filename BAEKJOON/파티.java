import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 파티 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, X;
	static int[][] adj;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		adj = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[from][to] = weight;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < N+1; i++) {
			int temp = calc(i, X) + calc(X, i);
			max = temp > max ? temp : max;
		}
		System.out.println(max);
	}
	private static int calc(int start, int end) {
		
		int[] minEdge = new int[N+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[start] = 0;
		boolean[] v = new boolean[N+1];
		
		for(int i = 1; i < N+1; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			
			for(int j = 1; j < N+1; j++) {
				if(!v[j] && min > minEdge[j] ) {
					minIdx = j;
					min = minEdge[j];
				}
			}
			v[minIdx] = true;
			if(minIdx == end) break;
		
			for(int j = 1; j < N+1; j++) {
				if(!v[j] && adj[minIdx][j] != 0 && minEdge[j] > minEdge[minIdx] +adj[minIdx][j]) {
					minEdge[j] = minEdge[minIdx] + adj[minIdx][j];
				}
			}
		}
		return minEdge[end];
	}
}
