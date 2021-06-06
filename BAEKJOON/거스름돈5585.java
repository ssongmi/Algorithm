import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거스름돈5585 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int price = Integer.parseInt(br.readLine());
		
		int change = 1000 - price;
		int cnt = 0;
		int[] arr = {500, 100, 50, 10, 5, 1};
		
		for(int i = 0; i < 6; i++) {
			cnt += change / arr[i];
			change %= arr[i];
			if(change == 0 )break;
		}
		System.out.println(cnt);
	}
}
