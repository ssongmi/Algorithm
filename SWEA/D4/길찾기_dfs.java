import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 길찾기_dfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] map;
	static int[] map2;
	public static void main(String[] args) throws IOException {
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			map = new int[100];
			map2 = new int[100];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int idx = Integer.parseInt(st.nextToken());
				int route = Integer.parseInt(st.nextToken());
				if(map[idx] == 0)map[idx] = route;
				else map2[idx] = route;
			}
//			System.out.println(Arrays.toString(map));
//			System.out.println(Arrays.toString(map2));
			int ans = 0;
			flag = false;
			dfs(0);
			if(flag) ans = 1;
			sb.append(String.format("#%d %d\n", tc, ans));
		}
		System.out.println(sb);
	}
	static boolean flag;
	private static void dfs(int i) {
		if(i == 99) {
			flag = true;
			return;
		}
		if(map[i] != 0) dfs(map[i]);
		if(map2[i] != 0) dfs(map2[i]);
	}
}
