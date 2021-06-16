import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 가장가까운공통조상 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] parents = new int[N+1];
			for(int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				parents[c] = p;
			}
			
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			HashSet<Integer> hs = new HashSet<>(); 
			while(true) {
				hs.add(v1);
				if(parents[v1] != 0) v1 = parents[v1];
				else break;
			}
			
			while(true) {
				if(hs.remove(v2)) break;
				v2 = parents[v2];
			}
			
			sb.append(v2 + "\n");
		}
		System.out.println(sb);
	}
	
}
