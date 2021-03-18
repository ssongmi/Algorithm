import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타트와링크 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static int[][] ab;
	static int[] teams;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		ab = new int[N+1][N+1];
		arr = new int[N/2];

		// 능력치 입력
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
				ab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(1, 0);
		System.out.println(diff);
	}
	private static void comb(int start, int cnt) {
		if(cnt == N/2) {
			teams = new int[N+1];
			// 팀 1과 0으로 표시
			for(int i : arr)
				teams[i] = 1;
			getAb();
			
			
			return;
		}
		for(int i = start; i < N+1; i++) {
			arr[cnt] = i;
			comb(i+1, cnt+1);
		}
	}
	static int diff = Integer.MAX_VALUE;
	private static void getAb() {

		int link = 0;
		int start = 0;

		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {

				if(teams[i] == 0 && teams[j] == 0) {
					start += ab[i][j];					
				} 
				else if(teams[i] == 1 && teams[j] == 1) {
					link += ab[i][j];					
				} 

			}
		}

		int d = Math.abs(start - link);
		diff = Math.min(diff, d);
	}
}
