import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두가지빵의딜레마 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc= 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			int[] price = new int[2];
			price[0] = Integer.parseInt(s[0]);
			price[1] = Integer.parseInt(s[1]);
			int money = Integer.parseInt(s[2]);
			Arrays.sort(price);
			System.out.println("#" + tc + " " + money/price[0]);
		}
	}
}
