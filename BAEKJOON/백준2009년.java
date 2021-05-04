import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2009년 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday", "Sunday"};
	static int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; 
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sum = 0;
		for(int i = 0; i < M-1; i++) {
			sum += month[i];
		}
		sum += D;
		System.out.println(day[(sum+2)%7]);
	}
}
