import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 바이러스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[] p;
	static void make() {
		for(int i = 1; i < N+1; i++) {
			p[i] = i;
		}
	}
	static int find(int idx) {
		if(p[idx] == idx) return idx;
		return p[idx] = find(p[idx]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		if(aRoot < bRoot)p[bRoot] = aRoot;
		else p[aRoot] = bRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
		p = new int[N+1];
		make();
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		int cnt = 0;
		for(int i = 2; i < N+1; i++) {
			find(i);
			if(p[i] == 1) cnt++;
		}
//		System.out.println(Arrays.toString(p));
		System.out.println(cnt);
	}
}
