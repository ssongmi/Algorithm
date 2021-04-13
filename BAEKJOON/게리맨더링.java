import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] pop;
	static boolean[] v;
	static int N;
	static int[] p;
	static int total;
	static int[][] adj;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		pop = new int[N+1];
		v = new boolean[N+1];
		p = new int[N+1];
		adj = new int[N+1][N+1];
		total = 0;
		// 인구수 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
			total += pop[i];
		}
		
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < cnt; j++) {
				int cur = Integer.parseInt(st.nextToken());
				adj[i][cur] = 1;
				adj[cur][i] = 1;
			}
		}
//		for(int[] sub : adj)
//			System.out.println(Arrays.toString(sub));
		// powerset 시도해보고
		powerset(0);
		// 연결관계 파악하고
		// 연결관계가 만족되면 인구수 파악
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	static int min = Integer.MAX_VALUE;
	static int aIdx = -1, bIdx= -1;
	private static void powerset(int idx) {
		if(idx == N) {
			int[] temp = new int[N+1];
			for(int i = 1 ; i <= N; i++) {
				if(v[i]) {
					temp[i] = 0;
					aIdx = i;
				}else {
					temp[i] = 1;
					bIdx = i;
				}
			}
			visited = new boolean[N+1];
			if(aIdx > 0 && bIdx > 0 && check(temp, aIdx) && check(temp, bIdx)) { // 다 연결되어 있음을 확인했으면 인구의 총합을 구함
				int a = 0, b = 0;
//				System.out.println("aIdx = " + aIdx + ", bIdx = " + bIdx);
//				System.out.println(Arrays.toString(temp));
//				System.out.println(Arrays.toString(visited));
				for(int i = 1; i <= N; i++) {
					if(!visited[i])return;
				}
				for(int i = 1; i <= N; i++) {
					if(v[i]) a+=pop[i];
				}
				b = total - a;
				int diff = Math.abs(a-b);
				min = min > diff ? diff : min; 
//				System.out.println("a = " + a + ", b = " + b);
//				System.out.println("---------------------");
			}
			return;
		}
		
		v[idx] = true;
		powerset(idx+1);
		v[idx] = false;
		powerset(idx+1);
	}
	static boolean[] visited;
	private static boolean check(int[] temp, int idx) {

		
		Queue<Integer> q = new LinkedList<>();
		q.offer(idx);
		visited[idx] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
//			System.out.println("cur = " + cur);
			for(int i = 1; i < N+1; i++) {
				if(adj[cur][i] == 1 && !visited[i] && temp[idx] == temp[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		for(int i = 1; i < N+1; i++) {
			if(temp[i] == temp[idx] && !visited[i])return false;
		}
		return true;
	}
}
