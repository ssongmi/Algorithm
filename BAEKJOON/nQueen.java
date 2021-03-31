import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nQueen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] row;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		row = new int[N];
		setQueen(0);
		System.out.println(cnt);
		
	}
	static int cnt = 0;
	private static void setQueen(int rowN) {
		if(rowN == N) {
			cnt++;
			return;
		}
		for(int i = 0; i < N; i++) {
			row[rowN] = i;
			if(isPossible(rowN)) {
				setQueen(rowN+1);
			}
		}
	}
	private static boolean isPossible(int rowN) {
		for(int i = 0; i < rowN; i++) {
			if(row[i] == row[rowN] ||rowN - i==Math.abs(row[i]-row[rowN]) ) return false;
			
		}
		return true;
	}
}
