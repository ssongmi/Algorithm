import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// 동전의 종류 N과 동전 가치의 합 K를 입력받음
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		// N개의 동전을 오름차순으로 입력받음
		for(int i = 0; i < N; i++)
			coins[i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		// 금액이 큰 순서대로 나눈 몫을 count에 더해주기
		for(int i = N-1; i >= 0; i--) {
			cnt += K/coins[i];
			K %= coins[i];
		}
		System.out.println(cnt);
	}
}
