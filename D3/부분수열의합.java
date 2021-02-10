import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int N, K, totalCnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		// 테스트케이스 수 입력
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// 수열의 원소 개수 N과 만족시켜야 하는 합 K
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 수열을 배열로 입력받음
			String[] tmp = br.readLine().split(" ");
			arr = new int[tmp.length];
			for(int i =0; i < tmp.length; i++)
				arr[i] = Integer.parseInt(tmp[i]);
			
			totalCnt = 0;
			permutation(0,0);
			sb.append("#" + tc + " " + totalCnt + "\n");
		}
		System.out.println(sb);
		
	}
	static void permutation(int idx, int total) {
		if(idx == arr.length) {
			if(total == K) totalCnt++;
			return;
		}
		permutation(idx+1, total+arr[idx]);
		permutation(idx+1, total);
	}
}
