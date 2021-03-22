import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 도시의 개수
		// 버스의 개수
		// 버스 출발 도시 번호, 도착 도시 번호, 비용
		// 출발지
		// 도착지
		int V = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] adj = new ArrayList[V+1];
		boolean[] v = new boolean[V+1];
		int[] D = new int[V+1];
		
		for(int i = 0; i < V+1; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 1; i < V+1; i++) {
			D[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < B; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[from].add(new int[] {to, weight});
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		D[start] = 0;
		
		while(true) {
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			for(int i = 1; i < V+1; i++) {
				if(!v[i] && min > D[i]) {
					min = D[i];
					minIdx = i;
				}
			}
			v[minIdx] = true;
			if(minIdx == end) break;
			
			for(int i = 0, size = adj[minIdx].size(); i < size; i++) {
				int[] cur = adj[minIdx].get(i);
				if(!v[cur[0]] && D[cur[0]] > D[minIdx] + cur[1]) {
					D[cur[0]] = D[minIdx] + cur[1];
				}
			}
			
		}
		
		System.out.println(D[end]);
	}
}
