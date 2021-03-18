import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준30 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String[] tmp = br.readLine().split("");
		int[] numbers = new int[tmp.length];
		boolean flag = false;
		long sum = 0;
		for(int i = 0, size = tmp.length; i < size; i++) {
			numbers[i] = Integer.parseInt(tmp[i]);
			sum += numbers[i];
			if(numbers[i] == 0) flag = true;
		}

		if(!flag || sum % 3 != 0) {
			sb.append("-1");
		}else {
			Arrays.sort(numbers);
			for(int i = numbers.length-1; i >= 0; i--) {
				sb.append(numbers[i]);
			}
		}
		System.out.println(sb);
	}
}
