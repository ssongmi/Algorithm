import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Info{
		int height, weight, cnt;

		public Info() {}
		public Info(int height, int weight) {
			super();
			this.height = height;
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		Info[] person = new Info[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			person[i] = new Info(w, h);
		}
		
		for(int i = 0; i < N; i++) {
			int count= 0;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(person[j].weight > person[i].weight && person[j].height > person[i].height) {
					count++;
				}
			}
			person[i].cnt = count+1;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(person[i].cnt + " ");
		}
		System.out.println(sb);
	}
}
