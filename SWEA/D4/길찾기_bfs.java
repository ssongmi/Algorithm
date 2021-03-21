import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 길찾기_bfs {
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
			if(bfs()) ans = 1;
			sb.append(String.format("#%d %d\n", tc, ans));
		}
		System.out.println(sb);
	}
	private static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == 99) return true;
			if(map[cur] != 0) q.offer(map[cur]);
			if(map2[cur] != 0) q.offer(map2[cur]);
		}
		return false;
	}
}
