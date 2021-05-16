import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단어수학 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		String[] strs = new String[N];
		int[] numbers = new int[26];
		for(int i = 0; i < N; i++) {
			strs[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			int tmp = (int)Math.pow(10, strs[i].length()-1);
			for(int j = 0, size = strs[i].length(); j < size; j++) {
				numbers[(int)strs[i].charAt(j)-65] += tmp;
				tmp /= 10;
			}
		}

		Arrays.sort(numbers);
		int idx = 9;
		System.out.println(numbers.length);
		for(int i = numbers.length - 1; i >= 0; i-- ) {
			if(numbers[i] == 0) break;
			sum += numbers[i] * idx;

			idx--;
		}
		System.out.println(sum);
	}
}
