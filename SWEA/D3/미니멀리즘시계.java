import java.io.IOException;
import java.util.Scanner;

public class 미니멀리즘시계 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int angle = sc.nextInt();
			int s = angle*2;
			int h = s / 60;
			int m = s % 60;
			System.out.println("#" + tc + " " + h + " " + m);
		}
	}
}
