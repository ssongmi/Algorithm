import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 숫자고르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, start;
	static int[] arr;
	static boolean[] v;
	static ArrayList<Integer> ans = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		v= new boolean[N+1];
		for(int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i < N+1; i++) {
			v[i] = true;
			start = i;
			dfs(i);
			v[i]=false;
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int n : ans) System.out.println(n);
	}
	private static void dfs(int idx) {
		if(start == arr[idx]) ans.add(start);
		
		if(!v[arr[idx]]) {
			v[arr[idx]] = true;
			dfs(arr[idx]);
			v[arr[idx]] = false;
		}
		
	}
}
