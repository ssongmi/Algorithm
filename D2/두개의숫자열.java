import java.util.Scanner;

public class 두개의숫자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int sum = 0;
			int max = 0;
			int[] AN = new int[N];
			int[] AM = new int[M];

			for (int i = 0; i < N; i++)
				AN[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				AM[i] = sc.nextInt();

			if (N < M) {
				for (int i = 0; i < M - N + 1; i++) {
					sum = 0;
					for (int j = 0; j < N; j++) {
						sum += AN[j] * AM[j + i];
					}
					if(sum > max)
						max = sum;
				}
			} else {
				for (int i = 0; i < N - M + 1; i++) {
					sum = 0;
					for (int j = 0; j < M; j++) {
						sum += AM[j] * AN[j + i];
					}
					if(sum > max)
						max = sum;
				}

			}
			System.out.println("#" + tc + " " + max);
		}
		
	}
}
