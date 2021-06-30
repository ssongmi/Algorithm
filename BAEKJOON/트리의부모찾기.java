import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static ArrayList<Integer>[] adj;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		// 인접리스트 생성
		adj = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		p = new int[N+1];
		for(int i = 1; i < N; i++ ) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adj[v1].add(v2);
			adj[v2].add(v1);
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0, size = adj[1].size(); i < size; i++) {
			q.offer(adj[1].get(i));
			p[adj[1].get(i)] = 1;
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 0, size = adj[cur].size(); i < size; i++ ) {
				int next = adj[cur].get(i);
				if(p[next] == 0) {
					q.offer(next);
					p[next] = cur;
				}
			}
		}
		
		for(int i = 2; i < N+1; i++) sb.append(p[i]).append("\n");
		System.out.println(sb);
		
	}
	
}
