package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 서로소집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] parents;
	private static void make() {
		for(int i = 1; i < N; i++) {
			parents[i] = i;
		}		
	}
	private static int find(int i) {
		if(parents[i] == i) return i;
		return parents[i] = find(parents[i]);
	}
	private static boolean union(int i, int j) {
		int iP = find(i);
		int jP = find(j);
		if(iP == jP) return false;
		parents[jP] = iP;
		return true;
	}
	private static boolean check(int i, int j) {
		int iP = find(i);
		int jP = find(j);
		if(iP == jP) return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());// 연산의 개수
			
			parents = new int[N+1];
			make();
			sb.append("#" + tc + " ");
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int type = Integer.parseInt(st.nextToken()); // 명령 종류
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(type == 0) { // 합친다는 의미
					union(a, b);
				}else if(type == 1) { // 같은 집합에 있는지
					if(check(a, b)) sb.append("0");
					else sb.append("1");
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
	}
}
