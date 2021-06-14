import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			Queue<Doc> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			int[] importance = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int score = Integer.parseInt(st.nextToken());
				q.offer(new Doc(i, score));
				importance[i] = score;
			}
			Arrays.sort(importance);
			int ptr = N-1;
			int index = 0;
			while(!q.isEmpty()) {
				Doc cur = q.poll();
				if(importance[ptr] != cur.score) {
					q.offer(cur);
				}else {
					if(cur.idx == idx) {
						break;
					}
					index++;
					ptr--;
				}
			}
			sb.append(index+1 + "\n");
		}
		System.out.println(sb);
	}
	static class Doc{
		int idx, score;

		public Doc(int idx, int score) {
			super();
			this.idx = idx;
			this.score = score;
		}
	}
}
