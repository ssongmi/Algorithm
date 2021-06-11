import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회장뽑기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		int[][] adj = new int[N+1][N+1];
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			if(v1 == -1 && v2 == -1) break;
			
			adj[v1][v2] = 1;
			adj[v2][v1] = 1;
		}
		

		for(int j = 1; j < N+1; j++) {
			for(int i = 1; i < N+1; i++) {
				if(i == j) continue;
				for(int k = 1; k < N+1; k++) {
					if(i == k || j == k) continue;
					if(adj[i][j] != 0 && adj[j][k] != 0) {
						if(adj[i][k] == 0)adj[i][k] = adj[i][j]+adj[j][k];
						else adj[i][k] = Math.min(adj[i][k], adj[i][j]+adj[j][k]);
					}
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		int[] arr = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			int res = 0;
			for(int j = 1; j < N+1; j++) {
				if(i == j)continue;
				if(adj[i][j] == 0) {
					res = 0;
					break;
				}
				res = Math.max(res, adj[i][j]);
			}
			arr[i] = res;
			if(res < ans) ans = res;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <N+1; i++ ) {
			if(ans == arr[i])list.add(i);
		}
		
		sb.append(ans + " " + list.size()+"\n");
		for(int num : list) sb.append(num + " ");
		System.out.println(sb);
		
	}
}
