import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		// 개수 입력
		N = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		
		// 부모 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			parents[i] = Integer.parseInt(st.nextToken());
		}
		
		// 지울 번호 입력
		int delete = Integer.parseInt(br.readLine());
		dfs(delete);

		boolean[] isNotLeaf = new boolean[N];
		
		int minus = 0;
		for(int i = 0; i < N; i++) {
			if(parents[i] < -1) minus++;
			else if(parents[i] >= 0) isNotLeaf[parents[i]] = true;
		}

		for(int i = 0; i < N; i++) {
			if(isNotLeaf[i]) minus++;
		}
		System.out.println(N-minus);
	}
	static void dfs(int p) {
		parents[p] = -2;
		// 지울 번호를 부모로 갖는 애들 삭제
		// 그 애들을 부모로 갖는 애들 삭제
		// 없을 때까지 반복
		for(int i = 0; i < N; i++ ) {
			if(parents[i] == p) {
				dfs(i);
			}
		}
		
	}
}
