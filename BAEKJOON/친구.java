import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 친구 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] adj = new int[N][N];
		boolean[][] friends = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < N; j++) {
				char ch = tmp.charAt(j);
				if(ch == 'Y') {
					adj[i][j] = 1; 
					friends[i][j] = true;
				}
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				if(i == k) continue;
				for(int j = 0; j < N; j++) {
					if(j == k || j == i) continue;
					if(adj[i][k] == 1 && adj[k][j] == 1) friends[i][j] = true;
				}
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(friends[i][j]) cnt++;
			}
			max = cnt > max ? cnt :max;
		}
		System.out.println(max);
	}
}
