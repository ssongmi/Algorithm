import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 직사각형길이찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			int[] arr = new int[s.length];
			int sum = 0;
			for(int i = 0; i < s.length; i++) {
				arr[i] = Integer.parseInt(s[i]);
				sum += arr[i];
			}
			Arrays.sort(arr);
			int ans = arr[0] == arr[1] ? arr[2] : arr[0];
			System.out.println("#" + tc + " " + ans);
		}
	}
}
