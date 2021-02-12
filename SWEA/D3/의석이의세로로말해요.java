import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 의석이의세로로말해요 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String[][] arr = new String[5][];
			
			// 입력받기
			for(int i = 0; i < 5; i++) {
				arr[i] = br.readLine().split("");
			}
			
			sb.append("#" + tc + " "); 
			
			// j는 행을 i는 열을 담당하고 각 행당 열의 길이를 미리 알 수 없으므로 
			// 실제 j열의 길이만큼만 입력받을 수 있도록 함
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 5; j++) {
					if(i < arr[j].length)
						sb.append(arr[j][i]);
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
