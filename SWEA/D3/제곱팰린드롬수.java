import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 제곱팰린드롬수 {
	public static int Palindrome(int n) {
		if(n < 10)
			return 1;
		String s = Integer.toString(n);
		int center = s.length()/2;
		String top = s.substring(0, center);
		String bottom = s.substring(s.length()%2 == 0 ? center : center+1,s.length());

		if(top.equals(bottom))
			return 1;
		else
			return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String[] tmp = br.readLine().split(" ");
			int lower = (int) Math.ceil((Math.sqrt(Integer.parseInt(tmp[0]))));
			int upper = (int) Math.sqrt(Integer.parseInt(tmp[1]));
			int count= 0;

			for(int i = lower; i <= upper; i++) {
				if(Palindrome(i)==1) {
					if(Palindrome(i*i) == 1) {
						count++;
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		} 
	}
}
