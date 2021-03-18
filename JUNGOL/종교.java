import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종교 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M; //학생수, 라인수
	static int[] rel; 
	static void make() {
		for(int i = 1; i < N+1; i++) {
			rel[i] = i;
		}
	}
	static int find(int i) {
		if(i == rel[i]) return i;
		return rel[i] = find(rel[i]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		rel[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		rel = new int[N+1];
		int cnt = N;
		make();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(union(a,b)) cnt--;
		}
		System.out.println(cnt);
	}
}
