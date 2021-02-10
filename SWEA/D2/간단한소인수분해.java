import java.util.Scanner;

public class 간단한소인수분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = { 2, 3, 5, 7, 11 };
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] num = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 1; j <= N / arr[i]; j++) {
					if (N % (Math.pow(arr[i] , j)) != 0) {
						num[i] = j - 1;
						break;
					}
				}
			}
			System.out.print("#" + tc + " ");
			for(int i = 0 ; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}

	}

}
