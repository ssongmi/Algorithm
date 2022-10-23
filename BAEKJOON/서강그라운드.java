import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강그라운드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, R;
	static int[][] map;
	static int[] D, items;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		items = new int[N+1];
		D = new int[N+1];
		map = new int[N+1][N+1];
		v = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			map[v1][v2] = dist;
			map[v2][v1] = dist;
		}
		
		int res = Integer.MIN_VALUE;
		
		for(int k = 1; k < N+1; k++) {
			int value = 0;
			
			v = new boolean[N+1];
			for(int i = 1; i < N+1; i++) {
				D[i] = Integer.MAX_VALUE;
			}
			
			D[k] = 0;
			for(int i = 1; i < N+1; i++) {
				int minIdx = 0;
				int min = Integer.MAX_VALUE;
				for(int j = 1; j < N+1; j++) {
					if(!v[j] && D[j] < min) {
						min = D[j];
						minIdx = j;
					}
				}
				
				v[minIdx] = true;
				
				for(int j = 1; j < N+1; j++) {
					if(!v[j] && map[minIdx][j] != 0 && map[minIdx][j] + D[minIdx] < D[j]) {
						D[j] = map[minIdx][j] + D[minIdx];
					}
				}
			}
			
			for(int i = 1; i < N+1; i++) {
				if(D[i] > M) continue;
				value += items[i];
			}
			res = Math.max(res, value);
		}
		
		System.out.println(res);
	}

}
