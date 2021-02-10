import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Summation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc= 1; tc <= T; tc++) {
			String[] arr = br.readLine().split(" ");
			int[] numbers = new int[arr.length];
			int MIN = Integer.MAX_VALUE;
			int MAX = Integer.MIN_VALUE;
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < arr[i].length(); j++) {
					numbers[i] += Integer.parseInt(arr[i].split("")[j]);
				}
				if(numbers[i] > MAX)
					MAX = numbers[i];
				if(numbers[i] < MIN)
					MIN = numbers[i];
			}
			System.out.println("#" + tc + " " + MIN + " " + MAX);
		}
	}
}
