import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 친구비 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, K;
	static int[] p;
	static int[] price;
	static void make() {
		for(int i = 1; i < N+1; i++) {
			p[i] = i;
		}
	}
	static int find(int i) {
		if(p[i] == i) return i;
		return p[i] = find(p[i]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		price = new int[N+1];
		make();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i < N+1; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = N;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(union(a, b)) cnt--;
		}
		boolean[] arr = new boolean[N+1];
		
		for(int i = 1; i < N+1; i++) {
			arr[find(i)] = true;
		}
		
		for(int i = 1; i < N+1; i++) {
			if(price[i] < price[p[i]]) price[p[i]] = price[i];
		}
		int ans = 0;
		for(int i = 1; i < N+1; i++) {
			if(arr[i]) ans+=price[i];
		}
		if(K >= ans) System.out.println(ans);
		else System.out.println("Oh no");

	}
}
