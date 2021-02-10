import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 적고지우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] tmp = br.readLine().split("");
			int[] arr = new int[tmp.length];
			boolean[] duplicate = new boolean[tmp.length];
			for(int i = 0; i < tmp.length; i++) {
				arr[i] = Integer.parseInt(tmp[i]);
				duplicate[arr[i]] = !duplicate[arr[i]];
				System.out.println(Arrays.toString(duplicate));
			}
			int sum = 0;
			for(int i = 0; i < arr.length; i++) {
				if(duplicate[i])
					sum++;
			}
			System.out.print("#" + tc + " " + sum);
			System.out.println();
			
		}
	}
}
