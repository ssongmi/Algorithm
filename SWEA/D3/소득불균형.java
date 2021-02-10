import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소득불균형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			String[] arr = s.split(" ");
			int[] numbers = new int[arr.length];
			double sum = 0;
			int count = 0;
			for(int i = 0; i < arr.length; i++) {
				numbers[i] = Integer.parseInt(arr[i]);
				sum += numbers[i];
			}
			sum /= numbers.length;
			for(int i = 0; i < arr.length; i++) {
				if(numbers[i] <= sum)
					count++;
			}
				
			System.out.println("# " + tc + " " + count);
 		}
	}
}
