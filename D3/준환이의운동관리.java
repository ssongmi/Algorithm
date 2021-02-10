import java.util.Scanner;

public class 준환이의운동관리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			System.out.print("#" + tc + " ");
			if(X < L) {
				System.out.println(L-X);
				continue;
			}else if( X >= L && X <= U) {
				System.out.println("0");
				continue;
			}else if(X > U) {
				System.out.println("-1");
			}
		}

	}

}
