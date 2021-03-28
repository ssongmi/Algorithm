import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 상근이의여행 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int adj[][] = new int[N+1][N+1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				adj[to][from] = 1;
				adj[from][to] = 1;
			}
			
			boolean[] v = new boolean[N+1];
			int[] minEdge = new int[N+1];
			int res = 0;
			
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			minEdge[1] = 0;
			for(int i = 0; i < N; i++) {
				int min = Integer.MAX_VALUE;
				int minV = 1; 
				for(int j = 1; j < N+1; j++) {
					if(!v[j] && min > minEdge[j]) {
						min = minEdge[j];
						minV = j;
					}
				}
				
				v[minV] = true;
				res += minEdge[minV];
				
				for(int j = 1; j < N+1; j++) {
					if(!v[j] && adj[minV][j] != 0 && minEdge[j] > adj[minV][j] )
						minEdge[j] = adj[minV][j];
				}
			}
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}
}
