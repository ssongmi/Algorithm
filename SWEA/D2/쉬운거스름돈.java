import java.util.Scanner;

public class 쉬운거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] num = new int[arr.length];
			
			for(int i = 0; i < arr.length; i++) {
				num[i] = N/arr[i];
				if(N == 0)
					break;
				N %= arr[i];
			}
			System.out.println("#" + tc);
			for(int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}
	}
}
