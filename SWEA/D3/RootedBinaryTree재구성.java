import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RootedBinaryTree재구성 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int K, N;
	static int[] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			N = (int)Math.pow(2, K) -1;
			tree = new int[N];
			ans = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				tree[i] = Integer.parseInt(st.nextToken());
			
			
			search(0,N-1,1);
			sb.append("#" + tc + " ");
			cnt = 0;
			int i = 0;
			 while(cnt < N){
				for(int j = 0; j < Math.pow(2, i); j++) {
					sb.append(ans[cnt++]+" ");					
				} 
				i++;
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	static int[] ans;
	static int cnt;
	static void search(int start, int end, int number) {
		if(start < 0 || start > N || end > N || end < 0 || number > N) return;
		
		int idx = (start+end)/2;
		ans[number-1] = tree[idx]; 
		if(start == end) return;
		search(start, idx-1, 2*number);
		search(idx+1, end, 2*number+1);
	}
}
