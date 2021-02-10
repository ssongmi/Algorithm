import java.util.Scanner;

public class 지그재그숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		int N, ans;
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(sc.nextLine());
			
			ans = N%2 == 0 ? -N/2 : (N+1)/2;
			
			System.out.println("#" + tc + " " + ans);
		}

	}

}
