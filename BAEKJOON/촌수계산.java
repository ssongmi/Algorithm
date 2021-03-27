import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 촌수계산 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] adj = new  int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int N2 = Integer.parseInt(br.readLine());
		for(int i = 0; i < N2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		boolean flag = false;
		int[] minEdge = new int[N+1];
		boolean[] v = new boolean[N+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[start] = 0;
		for(int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int minV = 0;
			
			for(int j = 1; j < N+1; j++) {
				if(!v[j] && min > minEdge[j]) {
					min = minEdge[j];
					minV = j;
				}
			}
			
			v[minV] = true;
			if(minV == end) {
				flag = true;
				break;
			}
			for(int j = 1; j < N+1; j++) {
				if(!v[j] && adj[minV][j] != 0 && minEdge[j] > min + adj[minV][j] ) {
					minEdge[j] = min + adj[minV][j];
				}
			}
		}
//		for(int[] sub : adj)
//			System.out.println(Arrays.toString(sub));
//		System.out.println("=========================");
//		System.out.println(Arrays.toString(minEdge));

		if(flag)System.out.println(minEdge[end]);
		else System.out.println("-1");
	}
}
