import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 간선이어가기2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, s, t;
	static int[][] map;
	static int[] D;
	static boolean[] v;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		v = new boolean[N+1];
		D = new int[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			map[v1][v2] = val;
			map[v2][v1] = val;
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			D[i+1] = Integer.MAX_VALUE;
		}

		D[s] = 0;
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
		System.out.println(D[t]);
	}

}
