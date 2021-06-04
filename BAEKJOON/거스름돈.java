import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거스름돈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int price = Integer.parseInt(br.readLine());
		
		int a = price / 5;
		int b = price / 2;
		int n1 = a;
		int n2 = (price - n1*5)/2;;
		for(int i = a; i <= b; i++) {
			if(5*n1 + 2 * n2 != price){
				n1--;
				n2 = (price - n1*5)/2;
			}
		}
		if(price != 1 && price != 3) System.out.println(n1+n2);
		else System.out.println(-1);
	}
}
