import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GNS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static class alphabet implements Comparable<alphabet>{
		String type;
		int priority;
		
		public alphabet(String type) {
			super();
			this.type = type;
			switch(type) {
			case"ZRO": this.priority = 1; break;
			case"ONE": this.priority = 2; break;
			case"TWO": this.priority = 3; break;
			case"THR": this.priority = 4; break;
			case"FOR": this.priority = 5; break;
			case"FIV": this.priority = 6; break;
			case"SIX": this.priority = 7; break;
			case"SVN": this.priority = 8; break;
			case"EGT": this.priority = 9; break;
			case"NIN": this.priority = 10;break;
			}
		}

		@Override
		public int compareTo(alphabet o) {
			// TODO Auto-generated method stub
			return this.priority - o.priority;
		}
		
	}
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			String[] str = br.readLine().split(" ");
			alphabet[] list = new alphabet[N];
			
			for(int i = 0; i < N; i++)
				list[i] = new alphabet(str[i]);
			
			Arrays.sort(list);
			sb.append("#" + tc + "\n");
			for(alphabet a : list)
				sb.append(a.type + " ");
			sb.append("\n");
		}
	}
}
