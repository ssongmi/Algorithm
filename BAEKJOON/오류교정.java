import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 오류교정 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] parity;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		parity = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				parity[i][j] = Integer.parseInt(st.nextToken());
		}
		if(checkRow() && checkCol()) System.out.println("OK");
		else {
			if(revise()) System.out.println("Change bit (" + (nr+1) + "," + (nc+1) + ")");
			else System.out.println("Corrupt");
		}
	}
	static int nr = -1, nc = -1;
	private static boolean revise() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int temp = parity[i][j];
				parity[i][j] = temp == 0 ? 1 : 0;
				if(checkRow() && checkCol()) {
					nr = i; nc = j;
					return true;
				}
				parity[i][j] = temp;
			}
		}
		return false;
		
	}
	private static boolean checkRow() {
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				sum += parity[i][j];
			}
			if(sum%2 != 0) return false;
		}
		return true;
	}
	private static boolean checkCol() {
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				sum += parity[j][i];
			}
			if(sum%2 != 0) return false;
		}
		return true;
	}
}
