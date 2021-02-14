import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회문1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	// 평면 글자판
	static char[][] words = new char[8][8];
	static int N;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int tc= 1; tc <= 10; tc++) {
			
			// 찾아야 하는 회문 길이
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			for(int i = 0; i < 8; i++) 
				words[i] = br.readLine().toCharArray();

			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					rowCheck(i, j, j+N-1);
					colCheck(i, j, j+N-1);
				}
			}
			sb.append(String.format("#%d %d\n", tc, cnt));
		}
		System.out.println(sb);
	}
	// 행 회문 검사
	static void rowCheck(int row, int left, int right) {
		if(left < 0 || right > 7 || words[row][left] != words[row][right])
			return;
		if(right - left <= 0) {
			cnt++;
			return;
		}
		if(words[row][left] == words[row][right])
			rowCheck(row, left+1, right-1);
	}
	// 열 회문 검사
	static void colCheck(int col, int top, int bottom) {
		if(top < 0 || bottom > 7 || words[bottom][col] != words[top][col])
			return;
		if(bottom - top <= 0) {
			cnt++;
			return;
		}
		if(words[bottom][col] == words[top][col])
			colCheck(col, top+1, bottom-1);
	}
	
}






