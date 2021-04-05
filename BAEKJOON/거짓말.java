import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 거짓말 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] p;
	static ArrayList<Integer>[] party;
	private static int find(int idx) {
		if (p[idx] < 0 || p[idx] == idx) return idx;
		return p[idx] = find(p[idx]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			if(aRoot == p[aRoot]) p[bRoot] = aRoot;
			else p[aRoot] = bRoot;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		party = new ArrayList[M+1];
		for(int i = 0; i < M+1; i++) {
			party[i] = new ArrayList<>();
		}
		p = new int[N + 1];
		Arrays.fill(p, -1);
		st = new StringTokenizer(br.readLine());
		int tN = Integer.parseInt(st.nextToken());
		for (int i = 0; i < tN; i++) {
			int idx = Integer.parseInt(st.nextToken());
			p[idx] = idx;
		}
		for (int i = 1; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int total = Integer.parseInt(st.nextToken());
			// 한명이라도 진실을 아는 사람이 있다면 진실을 말해야함

			for (int j = 0; j < total; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
			int size = party[i].size();
			if(size >=2) {
				int first = party[i].get(0);
				for(int j = 1; j < size; j++ ) {
					union(first, party[i].get(j));
				}
			}
		}
		int cnt = 0;
//		for(ArrayList sub : party)
//			System.out.println(Arrays.toString(sub.toArray()));
//		System.out.println(Arrays.toString(p));
//		
				
		for (int i = 1; i < M+1; i++) {
			for(int j = 0, size=party[i].size(); j < size; j++) {
				int tmp = find(party[i].get(j));
				if(p[tmp] != tmp) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);

	}
}
