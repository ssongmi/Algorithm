import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0, max = 0;
			int[][] arr = new int[100][100];
			// 입력받기
			for(int i = 0; i < arr.length; i++) {
				String[] s = br.readLine().split(" ");
				sum = 0;
				for(int j =0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
					sum += arr[i][j];
				}
				// 행에서 최대값 찾기
				max = sum > max ? sum : max;
			}
			// 열에서 찾기
			for(int i = 0; i < arr[0].length; i++) {
				sum = 0;
				for(int j = 0; j < arr.length; j++) {
					sum += arr[j][i];
				}
				max = sum > max ? sum : max;
			}
			// 우측으로 가는 대각선 확인
			for(int i = 0, j = 0; i < arr.length && j < arr.length; i++, j++) {
				sum += arr[i][j];
			}
			max = sum > max ? sum : max;
			for(int i = 0, j = arr.length-1; i < arr.length && j >= 0; i++, j--) {
				sum += arr[i][j];
			}
			max = sum > max ? sum : max;
			sb.append("#" + tc + " " + max);
		}
		System.out.println(sb);
	}
}
