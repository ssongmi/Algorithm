import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_Queen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int cnt, N;
	static int[] col;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			col = new int[N];
			cnt = 0;
			setQueen(0);
			sb.append(String.format("#%d %d\n", tc, cnt));
		}
		System.out.println(sb);
	}
	private static void setQueen(int rowNo) {
		if(rowNo == N) {
			cnt++;
			return;
		}
		for(int i = 0; i < N; i++ ) {
			col[rowNo] = i;
			if(isPossible(rowNo)) {
				setQueen(rowNo+1);
			}
		}
	}
	private static boolean isPossible(int rowNo) {
		for(int i = 0; i < rowNo; i++) {
			if(col[i] == col[rowNo] || rowNo - i == Math.abs(col[i]-col[rowNo])) return false;
		}
		return true;
	}
}
