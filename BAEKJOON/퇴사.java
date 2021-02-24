import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 퇴사 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int maxProfit = 0;
//	static int totalProfit = 0;
	static int[][] info; // 시작일, 끝나는 날, 이익
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 상담 가능한 남은 일수 받기
		N = Integer.parseInt(br.readLine());
		
		info = new int[N][3];
		// 소요 일수와 이익 받기 : 총 N개
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int profit = Integer.parseInt(st.nextToken());
			info[i][0] = i+1;
			info[i][1] = i + day;
			info[i][2] = profit;
		}
//		for(int[] sub : info)
//			System.out.println(Arrays.toString(sub));
		
//		Arrays.sort(info, new Comparator<int[]>(){
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				if(o1[1] != o2[1]) return o1[1]-o2[1];
//				return o1[0]-o2[0];
//			}
//			
//		});
//		for(int[] sub : info)
//			System.out.println(Arrays.toString(sub));
//		int prevEnd = 0;
//		for(int i = 0; i < N; i++) {
//			if(info[i][0] > prevEnd &&info[i][1] <= N) {			
//				totalProfit+=info[i][2];
//				prevEnd = info[i][1];
//			}
//		}
		search(0,0,0, 0);
		System.out.println(maxProfit);
	}
	private static void search(int idx ,int totalProfit, int prevEnd, int start) {
		if(idx == N ) {
			maxProfit = totalProfit > maxProfit ? totalProfit : maxProfit;
//			System.out.println(maxProfit);
			return;
		}
		for(int i = start; i < N; i++) {
			if(info[i][0] > prevEnd) {
//				System.out.println("idx = " + idx + ", i = " + i + ", total = " + totalProfit);
				if(info[i][1] <= N)
					search(idx + 1, totalProfit +info[i][2], info[i][1], i+1);
				search(idx + 1, totalProfit, prevEnd, i+1);				
			}
		}
		maxProfit = totalProfit > maxProfit ? totalProfit : maxProfit;
		return;
	}
	
}
